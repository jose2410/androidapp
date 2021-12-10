package com.example.prueba.io.response;

import com.example.prueba.model.Mensaje;

import java.util.ArrayList;

public class MensajeResponse {

    public ArrayList<Mensaje> getResults() {
        return results;
    }

    public void setResults(ArrayList<Mensaje> results) {
        this.results = results;
    }

    private ArrayList<Mensaje> results;

}
