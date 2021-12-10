package com.example.prueba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.example.prueba.io.MensajeAPIAdapter;
import com.example.prueba.model.Mensaje;
import com.example.prueba.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG="Mensajes";

    public void onReceive(Context context, Intent intent) {

        Bundle bundle= intent.getExtras();
        SmsMessage [] msgs;

        String str="";
        //Mensaje obj_m= new Mensaje();
        if(bundle!=null){
            Object[] pdus=(Object[]) bundle.get("pdus");
            msgs=new SmsMessage[pdus.length];
            for (int i=0;i<msgs.length;i++){
                msgs[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                str+="SMS de"+msgs[i].getOriginatingAddress();
                //seteo el nro al objeto
                //obj_m.setData(msgs[i].getOriginatingAddress());
                str+=" :";
                str+= msgs[i].getMessageBody();
                //seteo el mensaje al objeto
                //obj_m.setData(str);
                //envio la información al api
                //sendSms(str);
                //intent = new Intent(this, MainActivity.class);
                //intent.putExtra("data_sms", str);
                //startActivity(intent);
                registrarSms(str);
                //str+="";
            }
            //Toast.makeText(context,str,Toast.LENGTH_LONG).show();
            Toast.makeText(context,str,Toast.LENGTH_LONG).show();

        }


    }
    public void registrarSms(String str){
        //registro el sms en la BD
        Call<Mensaje> msj = MensajeAPIAdapter.getApiService("https://apigw.test.statkraft.com/peru/v1/medidor").registrarSms(str,"ewqewq","\t\n" +
                "897c4f68609d433293ef2227f07ebbd1");
        msj.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                if (response.isSuccessful()){
                    Mensaje msj = response.body();
                    Log.i(TAG,"Mensaje"+msj.getMessage_data());
                }else{
                    Log.e(TAG,"onresponse:"+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {
                Log.e(TAG,"onfailure:"+t.getMessage());
            }
        });
    }
    public void authtok(String str){
        //registro el sms en la BD
        Call<User> u = MensajeAPIAdapter.getApiService("https://apigw.test.statkraft.com/").login("client_credentials","1674e775-4043-4ee5-a1a5-5c8cf6f1783f","0y07Q~N4K-toQ8XAXYobC.zk~Y5XRGPFF.0ye","api://1674e775-4043-4ee5-a1a5-5c8cf6f1783f/energyinfo-monitoring");
        u.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User u = response.body();
                    Log.i(TAG,"Mensaje"+u.getResource());
                }else{
                    Log.e(TAG,"onresponse:"+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG,"onfailure:"+t.getMessage());
            }
        });

    }


}
