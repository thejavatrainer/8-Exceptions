package com.frequentis.java.training.module7.exception;

public class InvalidLowerCaseDeliverable extends Exception {

    public InvalidLowerCaseDeliverable() {
    }

    public InvalidLowerCaseDeliverable(String message) {
        super(message);
    }

    public InvalidLowerCaseDeliverable(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLowerCaseDeliverable(Throwable cause) {
        super(cause);
    }

    public InvalidLowerCaseDeliverable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
