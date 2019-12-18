package com.nv.tech.retrofit2.example.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Repo {

	@Getter
	private long id;
	@Getter
	private String name = "";
	@SerializedName("full_name")
	@Getter
	private String fullName;
}
