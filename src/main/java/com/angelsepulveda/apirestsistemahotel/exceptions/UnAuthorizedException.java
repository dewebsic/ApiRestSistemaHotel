package com.angelsepulveda.apirestsistemahotel.exceptions;

import org.aspectj.weaver.ast.Not;

public class UnAuthorizedException extends RuntimeException{

    public UnAuthorizedException(String message){
        super(message);
    }
}
