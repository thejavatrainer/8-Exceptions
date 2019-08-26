package com.frequentis.java.training.module7.exception;

public class Validator {

    private boolean isHexa(String number) {
        if ( number.length() == 0 ||
                (number.charAt(0) != '-' && Character.digit(number.charAt(0), 16) == -1))
            return false;
        if ( number.length() == 1 && number.charAt(0) == '-' )
            return false;

        for ( int i = 1 ; i < number.length() ; i++ )
            if ( Character.digit(number.charAt(i), 16) == -1 )
                return false;
        return true;
    }

    private Integer convertBase16(String number) throws ConversionException{

        if(isHexa(number)){
            return Integer.parseInt(number, 16) ;
        }
        else{
            throw new ConversionException("The string can't be converted to base 16!");
        }

    }
}
