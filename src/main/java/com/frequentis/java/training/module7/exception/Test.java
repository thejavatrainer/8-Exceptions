package com.frequentis.java.training.module7.exception;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        reverseString("Dorine");
        anotherReverseString("Dorine");
        System.out.println();
        Test test = new Test();
        test.checkParity(-1);
        test.anotherCheckParity(1);
        test.carryCheckParity((-17));
        System.out.println(test.getInteger(-72.3f));
       // test.doNothing();
       // test.anotheDoNothing();
        try {
            test.checkNumberCount(Arrays.asList(5, 7, 8, 9));
        }catch(IOException e){
            //DO NOT NOT NOT DO THIS
            //e.getStackTrace()[0].
            //LOG.err("Error occured when checking the member list length.", e);

        }
    }

    public static void reverseString(String str) {
        StringBuffer bf = new StringBuffer(str);
        bf.reverse();

        System.out.println(bf);


    }

    public static void anotherReverseString(String bla) {
        for (int i = bla.length() - 1; i >= 0; i--) {
            System.out.print(bla.charAt(i));
        }
    }

    public void checkParity(int num) {
        System.out.println(((num % 2) == 1) ? "impar" : "par");
    }

    public void anotherCheckParity(int num) {
        int aux = Math.abs(num) % 2;
        switch (aux) {
            case 0:
                System.out.println("par");
                break;
            case 1:
                System.out.println("impar");
                break;
        }
    }
    public void carryCheckParity(final int num){
        if(((num >> 1) << 1) == num ){
            System.out.println("par");
        }
        else{
            System.out.println("impar");
        }
    }

    public long getInteger(float num){
        if (num>0)
            return (long) Math.floor(num);
        else return (long) Math.ceil(num);

    }

    public void doNothing(){
        while (true)
           // System.out.println(ch);
        ;
    }

    public void anotheDoNothing(){
        for (;;);
    }

    public void checkNumberCount (List <Integer> list) throws IOException {
        IOException ioex = new IOException ("The given list contains less then 5 elements");
        if (list.size() < 5)
            throw ioex;
    }
}
