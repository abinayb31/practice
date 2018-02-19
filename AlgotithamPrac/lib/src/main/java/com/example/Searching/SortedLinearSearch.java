package com.example.Searching;

/**
 * Created by bandaab on 2/10/18.
 */

public class SortedLinearSearch {
    public static void main(String[] args){
        int[] numbers = {1,3,5,6,8,9,10,12,15,17,18};
        System.out.println("result-->"+searchInt(numbers, 10)[0]);
        System.out.println("result binary-->"+searchByBinary(numbers, 18));
    }

    public static String[] searchInt(int[] list, int number){
        String[] result = new String[2];
        for(int i = 0;i<list.length;i++){
            if(list[i]== number){
                result[0] = "true";
                result[1] = String.valueOf(i);
            } else if(list[i]>number){
                result[0] = "false";
                result[1] = String.valueOf(i);
            }
        }
        return result;


    }

    public static int searchByBinary(int[] list, int number){
        int first = 0;
        int last = list.length-1;
        int mid;
        while(first<=last){
            mid = first + (last-first)/2;
            if(list[mid] == number){
                return mid;
            } else if(list[mid] > number){
                last = mid-1;
            } else{
                first = mid+1;
            }
        }

        return -1;
    }
}
