package com.example.inpota00.sosapp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


class ServiceGenerator {

    private static Retrofit retrofit = null;

    private static Retrofit getRetrofit = null;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                                    .addInterceptor(interceptor)
                                    .addInterceptor(new BasicAuthInterceptor("b157aa5e-708c-4665-9d2e-0e9f64c4bcb0","3NnNr2Jw2V"))
                                    .readTimeout(60, TimeUnit.SECONDS)
                                    .connectTimeout(60, TimeUnit.SECONDS)
                                    .build();



        retrofit = new Retrofit.Builder()
                .baseUrl("https://twcservice.eu-gb.mybluemix.net/api/weather/v1/geocode/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }

    static Retrofit getClientForCloudant() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new BasicAuthInterceptor("f0acf2e4-4111-4aff-a0dd-a61f1dd6eb69-bluemix","7687671e014ded3b96aa8ffec8465f53186e36f53a99976377d15f57c43cac61"))
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();



        retrofit = new Retrofit.Builder()
                .baseUrl("https://f0acf2e4-4111-4aff-a0dd-a61f1dd6eb69-bluemix.cloudant.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }

}
