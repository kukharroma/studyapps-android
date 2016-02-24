package com.cook.datastorage.network.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The api service implementation
 */
public class ApiServiceImpl implements ApiService {
    private OkHttpClient mOkHttpClient;
    private RetrofitService mApi;

    public ApiServiceImpl() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        mApi = new Retrofit.Builder()
                .baseUrl(RetrofitService.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build()
                .create(RetrofitService.class);
    }

    @Override
    public Call<String> requestToRetrofitServiceExample() {
        return mApi.getDataRequestExample();
    }
}