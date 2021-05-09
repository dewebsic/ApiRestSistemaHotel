package com.angelsepulveda.apirestsistemahotel.exceptions;

public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message){
        super(message);
    }
}
