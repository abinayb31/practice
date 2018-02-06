package com.example;

/**
 * Created by bandaab on 1/13/18.
 */

public class StringComaparission {
    public static void main(String[] args){
        String textString = "aanbbcchheeeeeaaah";
        String convertedString = ConvertString(textString);
        if(convertedString.length()<textString.length()){
            System.out.println("convertedString "+convertedString);
        }else{
            System.out.println("convertedString "+textString);
        }
    }

    public static String ConvertString(String initialString){

        int count = 1;
        String formatedString = "";
        char assignedChar = initialString.charAt(0);
        for(int i = 1;i<initialString.length();i++){
            if(assignedChar == initialString.charAt(i)){
                count++;
            }else{
                formatedString = formatedString + assignedChar + count;
                assignedChar = initialString.charAt(i);
                count = 1;
            }
        }
        formatedString = formatedString + assignedChar + count;
        return formatedString;
    }
}
