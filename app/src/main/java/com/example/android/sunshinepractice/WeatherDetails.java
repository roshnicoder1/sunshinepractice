package com.example.android.sunshinepractice;


import java.io.Serializable;

public class WeatherDetails  implements Serializable {
    private double pressure;
    private double humidity;

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }




}
