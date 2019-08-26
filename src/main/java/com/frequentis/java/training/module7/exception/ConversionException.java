package com.frequentis.java.training.module7.exception;

public class ConversionException extends Throwable {

    private String message;

    public ConversionException(String message){
        this.message = message;
    }


}
