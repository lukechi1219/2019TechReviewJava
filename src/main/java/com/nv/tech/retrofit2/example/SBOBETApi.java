package com.nv.tech.retrofit2.example;

import com.nv.tech.retrofit2.example.dto.SBOBETResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SBOBETApi {

	@FormUrlEncoded
	@POST("player/get-player-balance.aspx")
	@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
	Call<SBOBETResponse> getPlayerBalance(
		@Field("param")
			String param
	);
}
