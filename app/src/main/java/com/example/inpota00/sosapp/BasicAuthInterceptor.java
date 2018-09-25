package com.example.inpota00.sosapp;


/**
 * Created by inpota00 on 05-09-2018.
 */

import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicAuthInterceptor implements Interceptor {

    private String credentials;

    public BasicAuthInterceptor(String user, String password) {
        this.credentials = Credentials.basic(user, password);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String stringurl = request.url().toString();
        stringurl = stringurl.replace("%2F", "/");
        stringurl = stringurl.replace("%3F", "?");


        Request authenticatedRequest = request.newBuilder()
                .url(stringurl)
                .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);
    }

}
