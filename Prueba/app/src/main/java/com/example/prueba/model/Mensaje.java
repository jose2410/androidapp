package com.example.prueba.model;

public class Mensaje {

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getMessage_data() {
        return message_data;
    }

    public void setMessage_data(String message_data) {
        this.message_data = message_data;
    }

    public String getMessage_date() {
        return message_date;
    }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    private int message_id;
    private String message_data;
    private String message_date;
    private String api_key;


}
