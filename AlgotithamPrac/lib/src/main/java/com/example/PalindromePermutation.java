package com.example;

import java.util.Arrays;

/**
 * Created by bandaab on 1/8/18.
 */

public class PalindromePermutation {

    static int count = 0;

    public static void main(String args[]) {
        String text1 = "abin aay";
        String text2 = "ayin abb";
        System.out.println("Permuation " + checkBrokenString(text1,text2));
        System.out.println("count " + count);

    }

    public static boolean checkBrokenString(String text1, String text2){
        String[] strings1 = text1.split(" ");
        String[] strings2 = text2.split(" ");
        if(strings1.length != strings2.length){
            return false;
        } else if(checkPermuation(removeSpaces(text1),removeSpaces(text2))){
                   return true;
        }
        return false;
    }

    public static char[] removeSpaces(String str){
        int spaces = 0;
        for (int i =0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                spaces++;
            }
        }

        int index = str.length() - spaces;
        char[] newStr = new char[index];

        for (int i = str.length()-1;i>=0;i--){
            if(str.charAt(i) != ' '){
                newStr[index-1] = str.charAt(i);
                index--;
            }
        }
        return newStr;
    }


    public static boolean checkPermuation(char[] text1, char[] text2){
        if(sortText(text1).equalsIgnoreCase(sortText(text2))){
            return true;
        }
        return false;
    }

    public static String sortText(char[] str){
        char[] tempArray = str;
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
