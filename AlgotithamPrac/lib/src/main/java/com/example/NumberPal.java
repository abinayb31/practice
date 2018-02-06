package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bandaab on 1/20/18.
 */

public class NumberPal {
    public static void main(String[] args){
        System.out.println("romanToInt"+ romanToInt("DV"));
    }

    public static boolean isPalindrome(int x) {
        int y = 0;
        int temp = x;
         if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
             return false;
         }
        while(temp != 0){
            y = (y*10) + (temp%10);
            temp = temp/10;
        }

        // while(x != 0){
        //     y = y*10 + x%10;
        //     if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE ) return 0;
        //     x = x/10;
        // }

        System.out.println("y  : "+y);
        System.out.println("x  : "+x);

        if(y != x){
            return false;
        }else{
            return true;
        }
    }

    public static int romanToInt(String s) {
        int[] numbers = new int[s.length()];
        int value = 0;
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        //for(int i = 0;i<s.length();i++){

        //}
        for(int i = 0;i<s.length();i++){
            System.out.println(s.charAt(i));
            System.out.println(romanMap.get("D"));
            if(romanMap.containsKey(s.charAt(i))){
                System.out.println(romanMap.get(s.charAt(i)));
                numbers[i] = romanMap.get(s.charAt(i));
            }
        }

        for(int i =0; i<numbers.length; i++){
            System.out.println(numbers[i]);
            if(i == numbers.length-1){
                value = value+numbers[i];
            }else if(numbers[i]<numbers[i+1]){
                value = value+(numbers[i+1]-numbers[i]);
            } else {
                value = value+numbers[i];
            }
        }

        return value;
    }

    public boolean isValid(String s) {
        System.out.println(s);
        if(s.length() <2 || s.length()%2 != 0 ) return false;
        for(int i = 0; i<s.length();i++){
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(i+1));
            if(getClosingValue(s.charAt(i)) != s.charAt(i+1)){
                return false;
            } else {
                i = i+1;
            }
        }
        return true;
    }

    public char getClosingValue(char c){
        switch (c) {
            case '[':
                return ']';
            case '{':
                return '}';
            case '(':
                return ')';
        }
        return ' ';
    }
}
