package com.example.Searching;

/**
 * Created by bandaab on 2/10/18.
 */

public class LinearSearch {
    public static void main(String[] args){
        int[] numbers = {1,5,3,2,8,11,6};
        System.out.print("result-->"+searchInt(numbers, 4)[0]+"--> at: "+searchInt(numbers, 4)[1]);
    }

    public static String[] searchInt(int[] list, int number){
        String[] result = new String[2];
        for(int i = 0;i<list.length;i++){
            if(list[i]== number){
                result[0] = "true";
                result[1] = String.valueOf(i);
            }
        }
        return result;
    }
}
