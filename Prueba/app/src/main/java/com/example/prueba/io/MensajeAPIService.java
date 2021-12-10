package com.example.prueba.io;

import com.example.prueba.io.response.MensajeResponse;
import com.example.prueba.model.Mensaje;
import com.example.prueba.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface MensajeAPIService {

    @GET("api/Mensaje")
    Call<ArrayList<Mensaje>> getSms(@Query("message_data") String d);
    @GET("api/mensajes")
    Call<ArrayList<Mensaje>> obtenerSms();
    @POST("api/Mensaje")
    @FormUrlEncoded
    Call<Mensaje> registrarSms(@Field("message_data") String msj,@Field("token") String token,@Field("api_key") String a_p);

    @POST("account/Authenticate")
    @FormUrlEncoded
    Call<User> login (@Field("grant_type") String g_type,@Field("client_id") String c_id, @Field("client_secret") String c_secret, @Field("resource") String r);
}
