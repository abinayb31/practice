package com.example;

import java.util.Arrays;

/**
 * Created by bandaab on 1/8/18.
 */

public class PalPermutation {

     static int count = 0;

    public static void main(String args[]) {
        String text1 = "abinay abinay bandari bandai";
        System.out.println("palPermuation " + checkPalindrome(removeSpaces(text1)));
        System.out.println("count " + count);

    }

    public static boolean checkPalindrome(String wordToCheck) {
        char[] sortedChar = sortText(wordToCheck);
        if(sortedChar.length%2 == 0){
            return getEvenSolution(sortedChar);
        } else {
            return getOddSolution(sortedChar);
        }
    }

    public static boolean getEvenSolution(char[] sortedChar){
        for(int i =0;i<sortedChar.length;i=i+2){
            if(sortedChar[i] != sortedChar[i+1]){
                return false;
            }
        }
        return true;
    }

    public static String removeSpaces(String str){
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
                newStr[index-1] = Character.toLowerCase(str.charAt(i));
                index--;
            }
        }
        return new String(newStr);
    }

    public static boolean getOddSolution(char[] sortedChar){
        int j = 0;
        boolean[] repetedValues = new boolean[sortedChar.length];
        for(int i =0;i<sortedChar.length-1;i++,j++){
            if(sortedChar[i] == sortedChar[i+1]){
                repetedValues[j] = true;
                i++;
            }else{
                repetedValues[j] = false;
            }
        }
        return analyzeArray(removedNotUsedSpaces(repetedValues,j));
    }

    public static boolean[] removedNotUsedSpaces(boolean[] fullValues, int length){
        boolean[] filteredValues = new boolean[length];
        for(int i = 0;i<length;i++){
            filteredValues[i]=fullValues[i];
        }
        return filteredValues;
    }

    public static boolean analyzeArray(boolean[] values){
        int falseValuesCount = 0;
        for(int i =0;i<values.length;i++){
            if(!values[i]){
                falseValuesCount++;
            }
        }
        if(falseValuesCount>1){
            return false;
        }
        return true;
    }

    public static char[] sortText(String str){
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        return tempArray;
    }
}
