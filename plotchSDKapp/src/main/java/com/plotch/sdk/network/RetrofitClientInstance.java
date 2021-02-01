package com.plotch.sdk.network;

import com.plotch.sdk.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static Retrofit retrofit2;

    public static Retrofit getRetrofitInstance(String url) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        } else {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }


        return retrofit;
    }

    public static Retrofit getRetrofitInstanceEternal(String url) {

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            if (retrofit2 == null) {
                retrofit2 = new Retrofit.Builder()
                        .baseUrl(url)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        } else {
            if (retrofit2 == null) {
                retrofit2 = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }


        return retrofit2;
    }
}
