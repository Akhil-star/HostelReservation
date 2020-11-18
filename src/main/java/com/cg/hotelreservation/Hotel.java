package com.cg.hotelreservation;

public class Hotel {
    public String hotelName;
    public double rate;
    public String startDate;
    public String endDate;
    public double weekdayRate;
    public double weekendRate;
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

    public Hotel(String hotelName, double weekdayRate, double weekendRate, String startDate, String endDate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.startDate = startDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.endDate = endDate;
    }
}
