package com.example;

import java.util.Arrays;

/**
 * Created by bandaab on 1/8/18.
 */

public class PermutationMultiplewords {

     static int count = 0;

    public static void main(String args[]) {
        String text1 = "123456 abinay";
        String text2 = "123546 baniay";
        System.out.println("Permuation " + checkBrokenString(text1,text2));
        System.out.println("count " + count);

    }

    public static boolean checkBrokenString(String text1, String text2){
        String[] strings1 = text1.split(" ");
        String[] strings2 = text2.split(" ");
        if(strings1.length != strings2.length){
            return false;
        } else{
            boolean[] valueResults = new boolean[strings1.length];
            for(int i = 0; i<strings1.length; i++){
                count++;
                if((strings1[i].length() == strings2[i].length()) && checkPermuation(strings1[i],strings2[i])){
                    valueResults[i] = true;
                } else {
                    valueResults[i] = false;
                }
            }
            return checkArray(valueResults);
        }
    }

    public static boolean checkArray(boolean[] value){
        for(int i = 0;i<value.length;i++){
            if(!value[i]){
                return false;
            }
        }
        return true;
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
