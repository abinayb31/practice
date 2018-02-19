package com.example.Searching;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bandaab on 2/15/18.
 */
public class Trip {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("a","b");
        map.put("b","c");
        map.put("c","e");
        map.put("e","f");
        map.put("d","a");

        for (Map.Entry<String, String> entry : map.entrySet()){
            if(!map.containsValue(entry.getKey())){
                System.out.println("start-->"+entry.getKey());
            }

            if(!map.containsKey(entry.getValue())){
                System.out.println("Dest-->"+entry.getValue());
            }
        }
    }
}
