package com.cg.hotelreservation;

import java.util.ArrayList;
import java.util.Optional;

public class HotelReservation {

    public ArrayList<Hotel> hotelList = new ArrayList<>();

    public Hotel findCheapestHotel(String startDate, String endDate) {
        Optional<Hotel> cheapestHotel = hotelList.stream()
                .filter(hotel -> hotel.startDate.compareTo(startDate) > 0 && hotel.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.rate < hotel2.rate ? hotel1 : hotel2);
        if (cheapestHotel.isPresent())
            return cheapestHotel.get();
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to hotel Reservation");
    }
}

