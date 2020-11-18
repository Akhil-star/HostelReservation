package com.cg.hotelreservation;

public class Hotel {
    public String hotelName;
    public double rate;
    public String startDate;
    public String endDate;
    public Hotel(String hotelName, double rate) {
        this.hotelName = hotelName;
        this.rate = rate;
    }

    public Hotel(String hotelName, double rate, String startDate, String endDate) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
