package com.example.prueba.io;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MensajeAPIAdapter {

    private static MensajeAPIService API_SERVICE;

    public static MensajeAPIService getApiService(String url){

        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String base_url = "https://apigw.test.statkraft.com/";
        String login_url = "account/Authenticate";
        String post_url = "post";

        String baseUrl = "http://192.168.1.3/API_Android/";
        //"http://192.168.1.3/API_Android/"

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            //implementa la interfaz
            API_SERVICE = retrofit.create(MensajeAPIService.class);
        }

        return API_SERVICE;
    }

}