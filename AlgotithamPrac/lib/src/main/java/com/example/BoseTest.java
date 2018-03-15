package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bandaab on 2/22/18.
 */

public class BoseTest {


    //Using Switch case
    public static int romanToInt(String s) {
        int[] numbers = new int[s.length()];
        int value = 0;
        for(int i = 0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    numbers[i]=1000;
                    break;
                case 'D':
                    numbers[i]=500;
                    break;
                case 'C':
                    numbers[i]=100;
                    break;
                case 'L':
                    numbers[i]=50;
                    break;
                case 'X' :
                    numbers[i]=10;
                    break;
                case 'V':
                    numbers[i]=5;
                    break;
                case 'I':
                    numbers[i]=1;
                    break;
            }
        }

        for(int i =0; i<numbers.length-1; i++){
            if(numbers[i]<numbers[i+1]){
                value -= numbers[i];
            } else {
                value += numbers[i];
            }
        }
        return value+numbers[numbers.length-1];
    }

    //Using map
    public static int romanToIntUsingMap(String s) {
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
        for(int i = 0;i<s.length();i++){
            if(romanMap.containsKey(s.charAt(i))){
                numbers[i] = romanMap.get(s.charAt(i));
            }
        }

        for(int i =0; i<numbers.length; i++){
            if(i == numbers.length-1){
                value += numbers[i];
            }else if(numbers[i]<numbers[i+1]){
                value += (numbers[i+1]-numbers[i]);
                i=i+1;
            } else {
                value += numbers[i];
            }
        }

        return value;
    }

    //support range 1 to 4999 because roman number above 5000 is invalid
    public static String intToRoman(int num) {
        if(num<=0 || num>=5000) return "Invalid Number range is from 1 to 4999";
        String M[] = {"", "M", "MM", "MMM","MMMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args){
        int number = 4999;
        String roman= "MMMMCMXCIX";
        System.out.println("Roman to Number-->"+roman+"-->"+romanToInt(roman));
        System.out.println("Roman to Number using Map-->"+roman+"-->"+romanToIntUsingMap(roman));
        System.out.println("Number to Roman-->"+number+"-->"+intToRoman(number));
    }
}
