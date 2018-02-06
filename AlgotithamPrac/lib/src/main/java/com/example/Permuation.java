package com.example;

import java.util.Arrays;
public class Permuation {
    public static void main(String args[]) {
        String text1 = "12345";
        String text2 = "54321";
        System.out.print("Permuation " + checkPermuation(text1,text2));
    }

    public static boolean checkPermuation(String text1, String text2){
        if(sortText(text1).equalsIgnoreCase(sortText(text2))){
            return true;
        }
        return false;
    }

    public static String sortText(String str){
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
