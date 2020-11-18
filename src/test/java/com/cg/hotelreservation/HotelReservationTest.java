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

    @Test
    public void givenHotelList_ShouldReturnCheapestHotelInGivenDateRange() {
        hotelReservation = new HotelReservation();
        hotelReservation.hotelList.add(new Hotel("Lakewood", 110, "2020-01-25", "2020-01-26"));
        hotelReservation.hotelList.add(new Hotel("Bridgewod", 160, "2020-02-12", "2020-02-14"));
        hotelReservation.hotelList.add(new Hotel("Ridgewood", 220, "2020-11-01", "2020-11-04"));
        Hotel cheapestHotel = hotelReservation.findCheapestHotel("2020-01-01", "2020-12-31");
        Assert.assertEquals("Lakewood", cheapestHotel.hotelName);
    }

    @Test
    public void givenWeekendWeekdayRates_WhenHotelCreated_ShouldNotBeNull()
    {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26");
        Hotel hotel2 = new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14");
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04");
        Assert.assertNotNull(hotel1);
        Assert.assertNotNull(hotel2);
        Assert.assertNotNull(hotel3);
    }

    @Test
    public void givenHotelList_WhenCheapestByWeekendAndWeekdayRatesFound_ShouldReturntrue() {
        hotelReservation = new HotelReservation();
        hotelReservation.hotelList.add(new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26"));
        hotelReservation.hotelList.add(new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14"));
        hotelReservation.hotelList.add(new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04"));
        Hotel cheapestHotelByWeekdayRates = hotelReservation.findCheapestHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Hotel cheapestHotelByWeekendRates = hotelReservation.findCheapestHotelByWeekendRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Lakewood", cheapestHotelByWeekdayRates.hotelName);
        Assert.assertEquals("Bridgewood", cheapestHotelByWeekendRates.hotelName);
    }

    @Test
    public void givenDetailsIncludingRatings_WhenHotelObjectCreated_ShouldNotBeNull() {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26", 3);
        Hotel hotel2 = new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14",4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04",5);
        Assert.assertNotNull(hotel1);
        Assert.assertNotNull(hotel2);
        Assert.assertNotNull(hotel3);
    }

    @Test
    public void givenHotelList_WhenCheapestBestRatedHotelInGivenDateRangeFound_ShouldBeTrue() {
        hotelReservation = new HotelReservation();
        hotelReservation.hotelList.add(new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26", 3));
        hotelReservation.hotelList.add(new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14", 4));
        hotelReservation.hotelList.add(new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04", 5));
        Hotel cheapestBestRatedHotel = hotelReservation.findCheapestBestRatedHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Ridgewood", cheapestBestRatedHotel.hotelName);
    }
    @Test
    public void givenHotelList_WhenBestRatedHotelFound_ShouldBeTrue() {
        hotelReservation = new HotelReservation();
        hotelReservation.hotelList.add(new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26", 3));
        hotelReservation.hotelList.add(new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14", 4));
        hotelReservation.hotelList.add(new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04", 5));
        Hotel cheapestBestRatedHotel = hotelReservation.findCheapestBestRatedHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Ridgewood", cheapestBestRatedHotel.hotelName);
    }

    @Test
    public void givenSpecialRates_WhenAddedToHotel_ShouldBeEqual() {
        hotelReservation = new HotelReservation();
        Hotel hotel = new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14",4);
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26", 3);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04",5);
        hotel.specialWeekdayRate = 110;
        hotel.specialWeekendRate = 50;
        Assert.assertEquals(110, hotel.specialWeekdayRate, 0);
        Assert.assertEquals(50, hotel.specialWeekendRate, 0);
    }
    @Test
    public void givenDate_WhenInvalid_ShouldThrowException() {
        try {
            String startDate = "2020/12/01";
            hotelReservation.validateDate(startDate);
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(true);
        }
    }

    @Test
    public void givenCustomerType_WhenInvalid_ShouldThrowException() {
        try {
            String customerType = "Reward";
            hotelReservation.validateCustomerType(customerType);
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(true);
        }
    }

    @Test
    public void givenHotelList_WhenCheapestBestRatedHotelInGivenDateRangeForRewardCustomerFound_ShouldBeTrue() {
        hotelReservation = new HotelReservation();
        hotelReservation.hotelList.add(new Hotel("Lakewood", 110, 90, "2020-01-25", "2020-01-26", 3,
                80, 80, "Reward"));
        hotelReservation.hotelList.add(new Hotel("Bridgewood", 160, 50, "2020-02-12", "2020-02-14", 4,
                110, 50, "Reward"));
        hotelReservation.hotelList.add(new Hotel("Ridgewood", 220, 150, "2020-11-01", "2020-11-04", 5,
                100, 40, "Reward"));
        Hotel cheapestBestRatedHotelForRewardCustomers = hotelReservation.findCheapestBestRatedHotelByWeekdayRatesForRewardCustomers("2020-01-01", "2020-12-31");
        Assert.assertEquals("Ridgewood", cheapestBestRatedHotelForRewardCustomers.hotelName);
    }
}

