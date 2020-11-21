package com.trc.app.repositories;

import com.google.gson.GsonBuilder;
import com.trc.app.utils.ConstantKey;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient mInstance;
    private static Retrofit mRetrofit;

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    private RetrofitClient() {
        //mRetrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        mRetrofit = new Retrofit.Builder().baseUrl(ConstantKey.SERVER_URL).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        //mRetrofit = new Retrofit.Builder().client(new OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS).readTimeout(100,TimeUnit.SECONDS).build()).baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public RetrofitApi getApi() {
        return mRetrofit.create(RetrofitApi.class);
    }

}
