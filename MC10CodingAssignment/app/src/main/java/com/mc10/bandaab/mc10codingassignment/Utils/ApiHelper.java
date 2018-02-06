package com.mc10.bandaab.mc10codingassignment.Utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mc10.bandaab.mc10codingassignment.Model.Login;
import com.mc10.bandaab.mc10codingassignment.Model.Study;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bandaab on 1/16/18.
 */

public class ApiHelper {

    public static String convertInputStreamToString(InputStream inputstream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream), 1024);
        try {
            return readLines(reader);
        } finally {
            reader.close();
        }
    }

    protected static String readLines(BufferedReader reader) throws IOException {
        //Read response line by line
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line + '\n');
        }
        return builder.toString();
    }

    public static Login jsonToResponse(String jsonResponse) {
        // convert Json object to java object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonResponse, Login.class);
    }

    public static ArrayList<Study> studiesJsonToResponse(String jsonResponse) {
        // convert Json object to java object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonResponse, Study[].class);
    }

    public static String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    public static String getGetDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append(":");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    public static String CovertDate(String seconds){
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM dd, yyyy h:mm a");
        return formatter.format(new Date(Long.parseLong(seconds)));
    }
}
