package com.frequentis.java.training.module7;

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
}
