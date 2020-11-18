package com.cg.hotelreservation;

import java.util.ArrayList;

public class HotelReservation {

    public ArrayList<Hotel> hotelList = new ArrayList<>();

    public String findCheapestHotel()
    {
        String minRateHotel = hotelList.get(0).hotelName;
        double minRate = hotelList.get(0).rate;
        for (Hotel hotel : hotelList) {
            if (hotel.rate < minRate) {
                minRate = hotel.rate;
                minRateHotel = hotel.hotelName;
            }
        }
        return minRateHotel;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to hotel Reservation");
    }
}

