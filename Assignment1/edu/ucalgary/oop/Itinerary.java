package edu.ucalgary.oop;
// Author: Aarsh Shah

// UCID: 30150079

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " (" + key + ")";
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        int i = 0;
        for (String[] val : myTrips) {
            this.trips[i] = new Trip(val);
            i++;
        }
    }

    // Getter
    public Trip[] getTrips() {
        return this.trips;
    }

    public String formatByArrival() {

        String fullResult = "";
        int currentMonth = 0, currentYear = 0, index = 0;

        for (Trip trip : this.trips) {
            if (trip == null) {
                break;
            }

            if (Trip.getYear(trip.getArrival()) != currentYear) {

                currentYear = Trip.getYear(trip.getArrival());
                fullResult += fmtString("Year", String.valueOf(currentYear));
                fullResult += '\n';
            }
            if (Trip.getMonth(trip.getArrival()) != currentMonth) {
                currentMonth = Trip.getMonth(trip.getArrival());
                fullResult += "--";
                fullResult += fmtString("Month", String.valueOf(currentMonth));
                fullResult += '\n';
            }
            fullResult += "----" + fmtString("City", trip.getCity());
            fullResult += ", " + fmtString("Country", trip.getCountry());
            fullResult += " (Place)";

            if ((index + 1) != this.trips.length) {
                if (this.trips[index + 1] != null)
                    fullResult += '\n';
            }
            index++;
        }

        return fullResult;
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {

        String[][][] dateArray = new String[3][12][this.trips.length];

        for (int i = 0; i < 3; i++) {

            for (int month = 0; month < 12; month++) {

                int instance = 0, index = 0;
                for (Trip trip : this.trips) {

                    if (trip == null) {
                        break;
                    }

                    if ((Trip.getYear(trip.getArrival()) == 2021 + i)
                            && (Trip.getMonth(trip.getArrival()) == month + 1)) {

                        dateArray[i][month][instance] = fmtString("City", trip.getCity());
                        dateArray[i][month][instance] += ", ";
                        dateArray[i][month][instance] += fmtString("Country", trip.getCountry());
                        instance++;
                    } else {
                        dateArray[i][month][index] = null;

                    }
                    index++;

                }

            }

        }
        return dateArray;
    }
}
