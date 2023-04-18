package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // // List of dates inserted
        // ArrayList<LocalDate> expectedDays = new ArrayList<LocalDate>();

        // // Test data - values may be changed in actual tests
        // String licence = "Ei n";
        // String extraLicence = "ZWEI";
        // LocalDate aDate = LocalDate.of(2119, 8, 10);
        // int counter = 7;

        // // Insert reservations for a particular licence for multiple days, out of
        // order
        // var vp = new VisitorParking();
        // for (int i = 0; i < counter; i++) {
        // expectedDays.add(aDate);
        // vp.addVisitorReservation(licence, aDate);
        // aDate = aDate.minusDays(3);
        // }
        // aDate = aDate.plusDays(1365);
        // vp.addVisitorReservation(licence, aDate);
        // expectedDays.add(aDate);

        // // Add in values for another licence - these should not be included in the
        // data
        // // structure for desired licence
        // vp.addVisitorReservation(extraLicence, aDate);
        // aDate = aDate.minusDays(1360);
        // vp.printVisitorLicence();
        // System.out.println(aDate);
        // vp.addVisitorReservation(extraLicence, aDate);

        // // Put expectedDays in reverse order
        // Collections.sort(expectedDays, Collections.reverseOrder());

        // // Retrieve the data structure, create an ArrayList of dates
        // ArrayList<LocalDate> actualDays = new ArrayList<LocalDate>();
        // HashMap<String, TreeSet<LocalDate>> data = vp.getParkingRecord();
        // TreeSet<LocalDate> registeredDays =
        // data.get(Parking.standardizeAndValidateLicence(licence));
        // Iterator<LocalDate> iter = registeredDays.iterator();
        // while (iter.hasNext()) {
        // actualDays.add(iter.next());
        // }

        // // Compare String values
        // String expectedString = expectedDays.toString();
        // String actualString = actualDays.toString();
        // String[] outcome = { expectedString, actualString };

        String name = "Annie, Oliver, and Mowgli";
        if (name.contains("Annie")) {
            System.out.println("Name is valid");
        } else {
            System.out.println("Name is invalid");
        }

    }

}
