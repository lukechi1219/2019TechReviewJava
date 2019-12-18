package com.nv.tech.retrofit2.example;

import java.io.IOException;
import java.util.List;

import com.nv.tech.retrofit2.example.dto.Repo;
import com.nv.tech.retrofit2.example.dto.SBOBETResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartRetrofit2 {

	public static void main(String[] args) throws IOException {

		testGitHub();

		System.out.println("----");

		testSBOBET();
	}

	private static void testGitHub() throws IOException {

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		GitHubService service = retrofit.create(GitHubService.class);

		Call<List<Repo>> repos = service
			.listRepos("lukechi1219", "test"); // , "aa123"

		Response<List<Repo>> response = repos.execute();

		if (response.isSuccessful()) {
			List<Repo> list = response.body();
			if (list != null) {
				System.out.println(list.size());
				System.out.println(list.get(0).getName());
				System.out.println(list.get(0).getFullName());
			}
		}
	}

	private static void testSBOBET() throws IOException {

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://api-vipbet888.xxttgg.com/web-root/restricted/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		SBOBETApi api = retrofit.create(SBOBETApi.class);

		String companyKey = "2yc8paub38cjmxmcknckodg5iflbxsj71kjx1819qn2d1abaklnwj15zsg0jzsok";

		String param = "{\"companyKey\":\"" + companyKey + "\",\"username\":\"test\",\"serverId\":\"KF888\"}";

		Call<SBOBETResponse> apiCall = api.getPlayerBalance(param);

		Response<SBOBETResponse> response = apiCall.execute();

		if (response.isSuccessful() && response.body() != null) {

			SBOBETResponse body = response.body();

			if (body.getError() != null) {
				System.out.println(body.getError().getId());
				System.out.println(body.getError().getMsg());
			}
			System.out.println(body.getUsername());
			System.out.println(body.getBalance());
			System.out.println(body.getOutstanding());
			System.out.println(body.getServerId());
		}
	}
}
