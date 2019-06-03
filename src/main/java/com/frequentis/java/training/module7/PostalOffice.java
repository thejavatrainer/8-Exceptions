package com.frequentis.java.training.module7;

import com.frequentis.java.training.module7.exception.BombNumber;
import com.frequentis.java.training.module7.exception.InvalidCombinedCaseDeliverable;
import com.frequentis.java.training.module7.exception.InvalidLowerCaseDeliverable;
import com.frequentis.java.training.module7.exception.InvalidUpperCaseDeliverable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Long.parseLong;

public class PostalOffice {
    private final PostalSafe safe;
    private List<Deliverable> deliverables;
    private String deliverable;

    public PostalOffice() {
        this.safe = new PostalSafe();
    }

    private boolean containsUpperCase(String deliverable) {
        char ch;
        boolean upperCaseFlag = false;
        for (int i = 0; i < deliverable.length(); i++) {
            ch = deliverable.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            }

        }

        return upperCaseFlag;
    }

    private boolean containsLowerCase(String deliverable) {
        char ch;
        boolean lowerCaseFlag = false;
        for (int i = 0; i < deliverable.length(); i++) {
            ch = deliverable.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }

        }

        return lowerCaseFlag;
    }


    public void process(List<String> deliverables) throws InvalidLowerCaseDeliverable, InvalidUpperCaseDeliverable, Exception,
            InvalidCombinedCaseDeliverable {
        this.deliverables = new ArrayList<>();
        // ...

        for (String deliverable : deliverables) {
            // ...
            parseDeliverable(deliverable); // would be great to catch just one type of exception
            // ...
        }

        // ...
        performDeliverableActions();
        // ...
    }

    private void performDeliverableActions() {
        for (Deliverable deliverable : deliverables) {
            // ...
            deliverable.performAction();
            // ...
        }
    }

    private void parseDeliverable(String deliverable) throws InvalidLowerCaseDeliverable, InvalidUpperCaseDeliverable, Exception,
            InvalidCombinedCaseDeliverable { // and maybe more
        // ...
        int radix = getPossibleRadixFromString(deliverable);
        try {
            int internalNumber = Integer.parseInt(deliverable, radix);
            if (internalNumber==2147483647){
                throw new BombNumber("Bomb Number");
            }
            deliverables.add(new Deliverable(internalNumber));
        } catch (java.lang.NumberFormatException e) {
            if (containsUpperCase(deliverable) && containsLowerCase(deliverable)) {
                try {
                    throw new InvalidCombinedCaseDeliverable(deliverable + " Contains both upper and lower case");
                } catch (InvalidCombinedCaseDeliverable ex) {
                    System.out.println(ex);
                }

            } else {
                if (containsLowerCase(deliverable)) {
                    try {
                        throw new InvalidLowerCaseDeliverable(deliverable + " Contains only lower case");
                    }  catch (InvalidLowerCaseDeliverable ex) {
                    System.out.println(ex);
                }

                } else if (containsUpperCase(deliverable)) {
                    try{
                    throw new InvalidUpperCaseDeliverable(deliverable + " Contains only upper case");
                    }  catch (InvalidUpperCaseDeliverable ex) {
                        System.out.println(ex);
                    }
                }
            }
        }

        // ...

    }

    private int getPossibleRadixFromString(String deliverable) throws Exception {


        try {
            parseLong(deliverable, 2);
            return 2;
        } catch (NumberFormatException e) {
            try {
                parseLong(deliverable, 10);
                return 10;
            } catch (NumberFormatException f) {

                try {
                    parseLong(deliverable, 16);
                    return 16;
                } catch (NumberFormatException g) {
                    return 0;
                }
            }

        }
    }

    // check if this can be a base2 number
    // check if this can be a base10 number
    // check if this can be a base16 number
    // handle ambigous case ex (1001 is now a base2, base10 or base16 number?) Hint: just throw exception if can be a number with more than 2 number system


    /*
    You can give test data to program by creating an Application launcher from Run/Debug Configuration,
    and by adding numbers to Program Arguments!
     */
    public static void main(String[] args) throws Exception {
        PostalOffice office = new PostalOffice();
        PostalSafe safe = new PostalSafe();
        safe.open();
        // ...

        office.process(Arrays.asList("12156", "12434", "ASaDR", "sdasdg", "AAAAFGR","214748347"));

        safe.close();


    }
}
