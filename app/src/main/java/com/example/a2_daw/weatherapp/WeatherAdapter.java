package com.example.a2_daw.weatherapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2_daw.weatherapp.model.Weather;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

private List<Weather> mWeatherList;

    public WeatherAdapter(List<Weather> mWeatherList) {
        this.mWeatherList = mWeatherList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.temperature_list_row_item, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        Weather weather = mWeatherList.get(position);

        holder.max_temp.setText(weather.getMax_temp().toString());
        holder.min_temp.setText(weather.getMin_temp().toString());
        holder.weekday.setText(weather.getWeakday());

    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }
}
