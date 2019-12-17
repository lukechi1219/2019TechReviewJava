package com.nv.tech.retrofit2.example;

import java.util.List;

import com.nv.tech.retrofit2.example.dto.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

	@GET("users/{user}/repos")
	Call<List<Repo>> listRepos(
		@Path("user")
			String user);
}
