package com.example.android.sunshinepractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SunshineAdapter extends RecyclerView.Adapter<SunshineAdapter.ForecastAdapterViewHolder> {

   // private int mNumberItems;
    private Context context;
   // private LayoutInflater inflater;
    private ArrayList<WeatherDetails> weatherDetailsList;
    private int resource;
   // WeatherDetails current;
   // int currentPos=0;


    public SunshineAdapter(@NonNull Context context, int resource, ArrayList<WeatherDetails> weatherDetailsList) {
        this.context=context;
        //inflater= LayoutInflater.from(context);
        this.weatherDetailsList=weatherDetailsList;
        this.resource=resource;

    }






    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

       public TextView mWeatherTextView;
        public TextView  mWeatherTextView1;


        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = view.findViewById(R.id.item_number1);
            mWeatherTextView1=view.findViewById(R.id.item_number2);
        }
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////
    }


    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.weatherlist;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
       // String weatherForThisDay = mWeatherData[position];
       // forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
        //ForecastAdapterViewHolder myHolder=(ForecastAdapterViewHolder)forecastAdapterViewHolder;
        WeatherDetails currentDetails =weatherDetailsList.get(position);
        Double i=currentDetails.getHumidity();
        Double j=currentDetails.getPressure();
        forecastAdapterViewHolder.mWeatherTextView.setText(String.valueOf(i));
        forecastAdapterViewHolder.mWeatherTextView1.setText(String.valueOf(j));


    }

    @Override
    public int getItemCount() {
        return weatherDetailsList.size();

    }


   // public void setWeatherData(String[] weatherData) {
       // mWeatherData = weatherData;
      //  notifyDataSetChanged();
    //}
}