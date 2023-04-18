package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

// Author: Aarsh Shah

// UCID: 30150079

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " (" + key + ")";
    }

    // Constructor
    public Trip(String[] array) {
        // Sets each member function as their respect value which is passed
        // through with an array.
        this.arrival = new String(array[0]);
        this.departure = new String(array[1]);
        this.city = new String(array[2]);
        this.country = new String(array[3]);
    }

    // Given a date string, return just the year
    public static int getYear(String date) {
        return Integer.parseInt(date.substring(0, 4));
    }

    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date) {
        return Integer.parseInt(date.substring(5, 7));

    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.

    // 2023-07-10 (Arrival), 2023-08-11 (Departure), Vaduz (City), Liechtenstein
    // (Country)
    public String formatTrip() {

        String fullString = new String();
        fullString = fmtString("Arrival", this.arrival) + ", ";
        fullString += fmtString("Departure", this.departure) + ", ";
        fullString += fmtString("City", this.city) + ", ";
        fullString += fmtString("Country", this.country);

        return fullString;
    }

    // Getter
    public String getArrival() {
        return this.arrival;
    }

    // Getter
    public String getDeparture() {
        return this.departure;
    }

    // Getter
    public String getCity() {
        return this.city;
    }

    // Getter
    public String getCountry() {
        return this.country;
    }

    // Setter
    public void setArrival(String date) {
        this.arrival = new String(date);
    }

    // Setter
    public void setDeparture(String date) {
        this.departure = new String(date);
    }

    // Setter
    public void setCity(String city) {
        this.city = new String(city);
    }

    // Setter
    public void setCountry(String country) {
        this.country = new String(country);
    }

}
