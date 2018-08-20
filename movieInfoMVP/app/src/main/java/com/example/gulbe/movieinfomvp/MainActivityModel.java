package com.example.gulbe.movieinfomvp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by gulbe on 7.08.2018.
 */

public class MainActivityModel implements MainActivityContract.Model {

    ArrayList<String> listOfNames=new ArrayList<>();
    ArrayList<String> listOfImages=new ArrayList<>();
    ArrayList<Float>  listOfScores=new ArrayList<>();





    @Override
    public ArrayList getListOfNames(){

        new getListOfActorInfo().execute();

        return listOfNames;

    }

    @Override
    public ArrayList getListOfImages(){

        new getListOfActorInfo().execute();

        return listOfImages;

    }

    @Override
    public ArrayList getListOfScores(){

        new getListOfActorInfo().execute();

        return listOfScores;

    }
    public class getListOfActorInfo extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.themoviedb.org/3/person/popular?api_key=d02975d5573c79ee96589cb51031c259");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String json;
                while ((json = bufferedReader.readLine()) != null) {
                    sb.append(json + "\n");
                }
                return sb.toString().trim();
            }

            catch (Exception e) {

                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);



            try {
                loadActorInfo(s);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }


    public  void loadActorInfo(String json) throws JSONException {
        listOfScores.clear();
        listOfNames.clear();
        listOfImages.clear();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray=jsonObject.getJSONArray("results");

        for(int i=0;i<jsonArray.length();i++){

            JSONObject obj = jsonArray.getJSONObject(i);
            listOfImages.add("https://image.tmdb.org/t/p/original/"+obj.getString("profile_path"));
            listOfNames.add(obj.getString("name"));
            listOfScores.add((float) obj.getDouble("popularity"));
        }

    }


}


