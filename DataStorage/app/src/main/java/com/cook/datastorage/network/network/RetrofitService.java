package com.cook.datastorage.network.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * A custom retrofit service.
 */
public interface RetrofitService {
    String END_POINT = "https://www.example.com/";

    // Add your requests here

    @GET("example/path")
    Call<String> getDataRequestExample();

}
