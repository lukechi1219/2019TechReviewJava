package com.nv.tech.retrofit2.example;

import java.util.List;

import com.nv.tech.retrofit2.example.dto.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {

	//	@FormUrlEncoded
	//	@POST("users/{user}/repos")
	@GET("users/{user}/repos")
	Call<List<Repo>> listRepos(
		@Path("user")
			String user,
		@Query("name")
			String name
		//		, @Field("token")
		//			String token
	);
}
