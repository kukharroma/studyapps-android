package com.cook.datastorage.network.network;

import retrofit2.Call;


/**
 * A custom api service
 */
public interface ApiService {

    // Your requests to the retrofit service goes here

    Call<String> requestToRetrofitServiceExample();
}
