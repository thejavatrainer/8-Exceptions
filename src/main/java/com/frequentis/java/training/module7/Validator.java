package com.frequentis.java.training.module7;

import com.frequentis.java.training.module7.exception.ConversionException;
import com.frequentis.java.training.module7.exception.InvalidCombinedCaseDeliverable;
import com.frequentis.java.training.module7.exception.InvalidLowerCaseDeliverable;
import com.frequentis.java.training.module7.exception.InvalidUpperCaseDeliverable;

public class Validator {

    public boolean validateCaseType(final String input) throws InvalidCombinedCaseDeliverable, InvalidUpperCaseDeliverable, InvalidLowerCaseDeliverable {
        boolean upperCaseFound = false;
        boolean lowerCaseFound = false;

        for (int index = 0; index < input.length(); index++) {
            Character actualChar = input.charAt(index);

            if (Character.isLetter(actualChar)) {
                if (Character.isUpperCase(actualChar)) {
                    upperCaseFound = true;
                }

                if (Character.isLowerCase(actualChar)) {
                    lowerCaseFound = true;
                }

                if (lowerCaseFound && upperCaseFound) {
                    throw new InvalidCombinedCaseDeliverable();
                }
            }
        }

        if (upperCaseFound) {
            throw new InvalidUpperCaseDeliverable();
        } else if (lowerCaseFound) {
            throw new InvalidLowerCaseDeliverable();
        }

        return true;
    }


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

    private Integer convertBase16(String number) throws ConversionException {

        if(isHexa(number)){
            return Integer.parseInt(number, 16) ;
        }
        else{
            throw new ConversionException("The string can't be converted to base 16!");
        }

    }
}
