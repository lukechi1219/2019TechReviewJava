package com.nv.tech.jdeferred2;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nv.tech.retrofit2.example.GitHubService;
import com.nv.tech.retrofit2.example.dto.Repo;
import org.jdeferred2.Deferred;
import org.jdeferred2.Promise;
import org.jdeferred2.impl.DefaultDeferredManager;
import org.jdeferred2.impl.DeferredObject;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartJDeferred2 {

	private static GitHubService gitHubService;
	private static ExecutorService executorService = Executors.newSingleThreadExecutor();
	private static DefaultDeferredManager deferredManager = new DefaultDeferredManager();

	public static void main(String[] args) {

		jDeferredTest();

		System.out.println("----");

		gitHubTest();

		System.out.println("main end");
	}

	/**
	 *
	 */
	private static void jDeferredTest() {

		boolean success = false;
		//	boolean success = true;

		Deferred<String, String, String> deferred = new DeferredObject<>();

		Promise<String, String, String> promise = deferred.promise();

		promise
			.progress(progress ->
				System.out.println("Job is in progress: " + progress)
			)
			.done(result ->
				System.out.println("Job done: " + result)
			)
			.fail(rejection ->
				System.out.println("Job fail: " + rejection)
			)
			.always((state, result, rejection) ->
				System.out.println("Job execution ended: " + state + ", " + result + ", " + rejection));

		deferred.notify("50%");

		if (success) {
			deferred.resolve("done");
		} else {
			deferred.reject("oops");
		}
		/*
Job is in progress: 50%
Job fail: oops
Job execution ended: REJECTED, null, oops
----
Job is in progress: 50%
Job done: done
Job execution ended: RESOLVED, done, null
		 */
	}

	/**
	 *
	 */
	private static void gitHubTest() {

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		gitHubService = retrofit.create(GitHubService.class);

		// 1
		withoutJDeferred();
		// 2
		withJDeferred();

		executorService.shutdown();
		deferredManager.shutdown();
	}

	/**
	 *
	 */
	private static void withoutJDeferred() {

		CompletableFuture<List<Repo>> future = repositories1("lukechi1219");

		//	future.whenComplete();
		future.whenCompleteAsync((list, e) -> {
			if (e != null) {
				System.out.println("whenCompleteAsync: " + e.getMessage());
			}
			System.out.println(list.size()); // !!!! Null Pointer Exception !!!!
			System.out.println(list.get(0).getName());
			System.out.println(list.get(0).getFullName());

		}).exceptionally(err -> {
			System.out.println("withoutJDeferred: " + err.getMessage());
			return null;
		});
	}

	/**
	 *
	 */
	private static void withJDeferred() {

		repositories2("lukechi1219")
			.done(list -> {
				System.out.println(list.size());
				System.out.println(list.get(0).getName());
				System.out.println(list.get(0).getFullName());
			})
			// exception
			.fail(err -> System.out.println("withJDeferred: " + err))
			// finally
			.always((state, list, rejection) ->
				System.out.println("Job execution ended: " + state + ", " + list.size() + ", " + rejection));
	}

	/**
	 * @param user user id in url path
	 */
	private static CompletableFuture<List<Repo>> repositories1(final String user) {

		return CompletableFuture.supplyAsync(() -> {

			//			Response<List<Repo>> response = gitHubService.listRepos(user, "test").execute();
			Response<List<Repo>> response;
			try {
				response = gitHubService.listRepos(user, "test").execute();

			} catch (IOException e) {
				throw new IllegalStateException(e);
			}

			if (response.isSuccessful()) {
				return response.body();
			}
			throw new IllegalStateException(response.message());

		}, executorService);
	}

	/**
	 * @param user user id in url path
	 */
	public static Promise<List<Repo>, Throwable, Void> repositories2(final String user) {

		return deferredManager.when(() -> {

			Response<List<Repo>> response = gitHubService.listRepos(user, "test").execute();

			if (response.isSuccessful()) {
				return response.body();
			}
			throw new IllegalStateException(response.message());
		});
	}

}