package com.example;

/**
 * Created by bandaab on 1/13/18.
 */

public class OneAway {
    public static void main(String[] args){
        String one = "abinay";
        String two = "binay";
        System.out.println(checkOneEdit(one,two));
    }

    public static boolean checkOneEdit(String text1, String text2){
        int countDifference = 0;
        int j = 0;
        for(int i = 0; i<text1.length(); i++){
            if(text1.charAt(i) != text2.charAt(j)){
                countDifference++;
            }else {
                j++;
            }
            if(countDifference>1){
                return false;
            }
        }
        return true;
    }
}
