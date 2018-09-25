package com.example.inpota00.sosapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by inpota00 on 05-09-2018.
 */

public interface APIInterface {

    @GET("{feed_name}")
    Call<WeatherApi> getWeatherCondition(@Path(value="feed_name", encoded=true) String url);

    @POST("{feed_name}")
    Call<CloudantResponse> uploadToCloudant(@Path(value="feed_name", encoded=true) String url,@Body Cloudant cloudantRequest);
}
