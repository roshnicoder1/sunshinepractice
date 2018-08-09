package com.example.android.sunshinepractice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.sunshinepractice.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

 private static final int NUM_LIST_ITEMS=100;
 private SunshineAdapter mAdapter;
 private RecyclerView mweatherList;
    ArrayList<WeatherDetails> weatherlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        mweatherList= findViewById(R.id.recyclerid);

        mweatherList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mweatherList.setHasFixedSize(true);



        URL githubSearchUrl = NetworkUtils.buildUrl();
        // COMPLETED (4) Create a new GithubQueryTask and call its execute method, passing in the url to query
        new FetchWeatherTask().execute(githubSearchUrl);




    }

    public class FetchWeatherTask extends AsyncTask<URL, Void, String> {

        // COMPLETED (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        // COMPLETED (3) Override onPostExecute to display the results in the TextView
       @Override
        protected void onPostExecute(String githubSearchResults) {
            super.onPostExecute(githubSearchResults);
            JSONObject jsonObject = null;
            try {
                //Parent JSON Object. Json object start at { and end at }
                jsonObject = new JSONObject(githubSearchResults);
               // ArrayList<WeatherDetails> weatherlist=new ArrayList<>();

                //Array of parent JSON object
//               Map<String, Integer> companiesMap = new HashMap<>();

                //JSON Array of parent JSON object. Json array starts from [ and end at ]
                JSONArray jsonArray = jsonObject.getJSONArray("list");

                //Reading JSON object inside Json array
                for (int i =0; i<jsonArray.length();i++)
                {
                    //Reading JSON object at 'i'th position of JSON Array
                    JSONObject object = jsonArray.getJSONObject(i);
                    WeatherDetails weatherDetails=new WeatherDetails();

                    weatherDetails.setHumidity(object.getDouble("humidity"));
                    weatherDetails.setPressure(object.getDouble("pressure"));

                    weatherlist.add(weatherDetails);
                }

                mAdapter=new SunshineAdapter(MainActivity.this,R.layout.weatherlist,weatherlist);
               // mweatherList.setHasFixedSize(true);
                // mAdapter=new SunshineAdapter(NUM_LIST_ITEMS);
                mweatherList.setAdapter(mAdapter);

                //mweatherList.setAdapter(mAdapter);






            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }



}

