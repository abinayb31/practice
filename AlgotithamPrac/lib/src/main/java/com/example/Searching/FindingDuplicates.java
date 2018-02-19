package com.example.Searching;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by bandaab on 2/10/18.
 */

public class FindingDuplicates {
    public static void main(String[] args){
        int[] numbers = {1,5,3,2,8,11,13,6,11,2,11,4,11};
        System.out.println("result-->");
//        printDuplicatesON2(numbers);
//        printDuplicatesONLogN(numbers);
        printDuplicateshash(numbers);
//        printDuplicatesON(numbers);
    }


    public static void printDuplicatesON2(int[] nums){
        for(int i = 0;i<nums.length;i++){
            for (int j= i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    System.out.println("duplicate of -->"+nums[i]+" at "+j);
                }
            }
        }
    }

    public static void printDuplicatesONLogN(int[] nums){
        Arrays.sort(nums);
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                System.out.println("duplicate of ONLogN-->"+nums[i]);
            }
        }
    }

    public static void printDuplicateshash(int[] nums){
        HashSet<Integer> set =  new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                System.out.println("duplicate of ONLogN-->"+nums[i]+" at "+i);
            } else {
                set.add(nums[i]);
            }
        }
    }

    //This works only if we know range
    public static void printDuplicatesON(int[] nums){
        int[] count = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            count[i] = 0;
        }
        for(int i = 0;i<nums.length;i++){
            if(count[nums[i]] == 1){
                System.out.println("duplicate of ONLogN-->"+nums[i]+" at "+i);
            } else{
                count[nums[i]]++;
            }
        }
    }
}
