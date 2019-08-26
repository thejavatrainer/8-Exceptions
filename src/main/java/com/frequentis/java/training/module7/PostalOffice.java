package com.frequentis.java.training.module7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.frequentis.java.training.module7.exception.InvalidCombinedCaseDeliverable;
import com.frequentis.java.training.module7.exception.InvalidLowerCaseDeliverable;
import com.frequentis.java.training.module7.exception.InvalidUpperCaseDeliverable;

public class PostalOffice {
    private final PostalSafe safe;
    private List<Deliverable> deliverables;

    public PostalOffice() {
        this.safe = new PostalSafe();
    }

    public void process(List<String> deliverables) {
        this.deliverables = new ArrayList<>();
        // ...

        for (String deliverable : deliverables) {
            // ...
            // parseDeliverable(deliverable); // would be great to catch just one type of exception
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

    private void parseDeliverable(String deliverable) throws InvalidLowerCaseDeliverable, InvalidUpperCaseDeliverable,
                                                             InvalidCombinedCaseDeliverable { // and maybe more
        // ...
        int radix = getPossibleRadixFromString(deliverable);
        int internalNumber = Integer.parseInt(deliverable, radix);
        // ...
        deliverables.add(new Deliverable(internalNumber));
    }

    private int getPossibleRadixFromString(String deliverable) {
        // check if this can be a base2 number
        // check if this can be a base10 number
        // check if this can be a base16 number
        // handle ambigous case ex (1001 is now a base2, base10 or base16 number?) Hint: just throw exception if can be a number with more than 2 number system
        return 0;
    }

    /*
    You can give test data to program by creating an Application launcher from Run/Debug Configuration,
    and by adding numbers to Program Arguments!
     */
    public static void main(String[] args) {
        PostalOffice office = new PostalOffice();
        // ...
        office.process(Arrays.asList(args));
    }
}
