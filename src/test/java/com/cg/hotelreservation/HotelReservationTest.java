package com.cg.hotelreservation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
    HotelReservation hotelReservation;

    @Test
    public void givenDetails_WhenHotelObjectCreated_ShouldReturnTrue() {
        hotelReservation = new HotelReservation();
        String hotelName = "Lakewood";
        int rate = 110;
        Hotel hotel = new Hotel(hotelName, rate);
        Assert.assertTrue(hotel != null);
    }

    @Test
    public void givenHotelList_WhenHotelsAdded_ShouldReturnCountTrue() {
        hotelReservation = new HotelReservation();
        hotelReservation.hotelList.add(new Hotel("Lakewood", 110));
        hotelReservation.hotelList.add(new Hotel("Bridgewood", 160));
        hotelReservation.hotelList.add(new Hotel("Ridgewood", 220));
        Assert.assertEquals(3, hotelReservation.hotelList.size());
    }
}
