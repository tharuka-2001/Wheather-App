package com.example.weatherapp.Domains;

public class Hourly {
    private String hour;
    private int temp;
    private String picPath;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Hourly(int temp, String picPath, String hour) {
        this.temp = temp;
        this.picPath = picPath;
        this.hour = hour;
    }
}
