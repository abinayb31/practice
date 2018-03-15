package com.example.Searching;

/**
 * Created by bandaab on 3/2/18.
 */

import java.io.*;
public class TimeConversion {
        public static void main (String[] args) {
            System.out.print(timeConversion("07:05:45AM"));
        }

        public static boolean getisPM(String time){
            String pmoram = time.substring(8);
            if(pmoram.equalsIgnoreCase("PM")){
                return true;
            }
            return false;
        }

        public static String timeConversion(String inputTime) {
            String hours = inputTime.substring(0,2);
            String min = inputTime.substring(3,5);
            String sec = inputTime.substring(6,8);
            int hoursInt = Integer.parseInt(hours);

            if(getisPM(inputTime)){
                hoursInt = hoursInt+12;
                return String.valueOf(hoursInt)+":"+min+":"+sec;

            } else {
                return inputTime.substring(0,8);
            }
        }
}
