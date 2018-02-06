package com.example;
/**
 * Created by bandaab on 1/4/18.
 */

public class RemoveSpaces {
    public static void main(String args[]) {
        String stringWithSpaces = "I am going to india";
//        String comma = "%20";
        char[] stringWithSpacesArray = stringWithSpaces.toCharArray();
//        char[] replaceArray = comma.toCharArray();
//        char[] stringWithOutSpacesArray = null;
//        for (int i =0;i<stringWithSpacesArray.length;i++){
//            if(stringWithSpacesArray[i] == ' '){
//                stringWithSpacesArray[i] = replaceArray;
//            }
//        }

//        System.out.print(new String(stringWithSpacesArray));
        repleaceSpaces(stringWithSpacesArray, stringWithSpacesArray.length);

    }

    static void repleaceSpaces(char[] str, int length){
        int spaces = 0;
        for (int i =0;i<str.length;i++){
            if(str[i] == ' '){
                spaces++;
            }
        }

        int index = length + spaces*2;
        char[] newStr = new char[index];

        for (int i = length-1;i>=0;i--){
            if(str[i] == ' '){
                newStr[index-1]='0';
                newStr[index-2]='2';
                newStr[index-3]='%';
                index = index-3;
            }else{
                newStr[index-1] = str[i];
                index--;
            }
        }

        System.out.print(new String(newStr));
    }

}
