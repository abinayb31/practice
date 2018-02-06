package com.practice.bandaab.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bandaab on 2/6/18.
 */

public class MainFragment extends Fragment{

    String searchText = "trees";
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        listView = view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private class ListAdapter extends ArrayAdapter<String>{

        public ListAdapter(@NonNull Context context, int resource, Searchresponce object) {
            super(context, resource);
            for(int )
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }
    }



    protected class FetchData extends AsyncTask<Void, Void, Void> {
        protected String JSON_URL = "";
        private InputStream inputStream;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = new URL(JSON_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                jsonResponse = convertInputStreamToString(inputStream);
                response = jsonToResponse(jsonResponse);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (response != null) {
                mSearchView.OnSearchSuccess(response);
            } else {
                mSearchView.OnSearchFail("Search failed please try again");
            }

        }
    }


}
