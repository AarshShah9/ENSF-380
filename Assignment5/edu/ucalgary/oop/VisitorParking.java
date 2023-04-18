package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class VisitorParking {
    HashMap<String, TreeSet<LocalDate>> visitorLicence = new HashMap<>();
    HashMap<String, TreeSet<LocalDate>> parkingRecord = new HashMap<>();

    public VisitorParking() {
    }

    public VisitorParking(String licence) throws IllegalArgumentException {
        String standardizedlicence = Parking.standardizeAndValidateLicence(licence);

        if (standardizedlicence == null) {
            throw new IllegalArgumentException("licence plate is not valid");
        }
        this.visitorLicence.put(standardizedlicence, new TreeSet<LocalDate>());
        this.visitorLicence.get(standardizedlicence).add(LocalDate.now());

    }

    public VisitorParking(String licence, LocalDate date) throws IllegalArgumentException {
        String standardizedlicence = Parking.standardizeAndValidateLicence(licence);

        if (standardizedlicence == null || date == null || date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("licence plate or date is not valid");
        }
        this.visitorLicence.put(standardizedlicence, new TreeSet<LocalDate>());
        this.visitorLicence.get(standardizedlicence).add(date);

    }

    public void addVisitorReservation(String licence) throws IllegalArgumentException {
        String standardizedlicence = Parking.standardizeAndValidateLicence(licence);
        LocalDate now = LocalDate.now();

        if (checkIfValidVistor(standardizedlicence, now)) {
            if (!visitorLicence.containsKey(standardizedlicence)) {
                visitorLicence.put(standardizedlicence, new TreeSet<LocalDate>());
                visitorLicence.get(standardizedlicence).add(now);

            } else {
                visitorLicence.get(standardizedlicence).add(now);
            }

            ArrayList<LocalDate> dates = new ArrayList<>(visitorLicence.get(standardizedlicence));
            Collections.sort(dates, Collections.reverseOrder());
            visitorLicence.get(standardizedlicence).clear();
            for (LocalDate date : dates) {
                visitorLicence.get(standardizedlicence).add(date);
            }

        } else {
            throw new IllegalArgumentException("Cannot add visitor reservation");
        }
    }

    public void addVisitorReservation(String licence, LocalDate date) throws IllegalArgumentException {
        String standardizedlicence = Parking.standardizeAndValidateLicence(licence);

        if (checkIfValidVistor(standardizedlicence, date)) {
            if (!visitorLicence.containsKey(standardizedlicence)) {
                visitorLicence.put(standardizedlicence, new TreeSet<LocalDate>());
                visitorLicence.get(standardizedlicence).add(date);

            } else {
                visitorLicence.get(standardizedlicence).add(date);
            }
            // this doesnt work
            ArrayList<LocalDate> dates = new ArrayList<>(visitorLicence.get(standardizedlicence));
            Collections.sort(dates, Collections.reverseOrder());
            visitorLicence.get(standardizedlicence).clear();
            for (LocalDate date2 : dates) {
                visitorLicence.get(standardizedlicence).add(date2);
            }

        } else {
            throw new IllegalArgumentException("Cannot add visitor reservation");
        }
    }

    private boolean checkIfValidVistor(String licence, LocalDate date) {
        if (licence == null || date == null || date.isBefore(LocalDate.now())) {
            return false;
        }

        // ArrayList<String> licences = new ArrayList<>();
        ArrayList<LocalDate> allDaysLicences = new ArrayList<>();

        allDaysLicences.add(date);
        allDaysLicences.add(date.plusDays(1));
        allDaysLicences.add(date.plusDays(2));

        // Loop through the main HashMap
        for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {

            // Get the key and value for the current entry
            String key = entry.getKey();
            TreeSet<LocalDate> val = entry.getValue();

            // Loop through the ArrayList of dates (the value)
            for (LocalDate date2 : val) {

                // add all 3 dates to the arraylist for each date
                allDaysLicences.add(date2);
                allDaysLicences.add(date2.plusDays(1));
                allDaysLicences.add(date2.plusDays(2));

                // Get the difference between the two dates
                long diff = Math.abs(ChronoUnit.DAYS.between(date, date2));

                // If the licence is already registered for the date (within 3 days), return
                // false
                if (licence.equals(key) && diff < 3) {
                    return false;
                }

            }

        }

        // might change this to loop though all of the licences not just the flagged
        // ones

        // now check if a single local date is in the array list more than twice
        for (LocalDate date2 : allDaysLicences) {
            int count = 0;
            for (LocalDate date3 : allDaysLicences) {
                if (date2.equals(date3)) {
                    count++;
                }
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        // This method checks the visitorLicence HashMap to see if the licence is
        // registered for the date given
        // If the licence is registered for the date, return true otherwise return false
        licence = Parking.standardizeAndValidateLicence(licence);

        if (visitorLicence.containsKey(licence)) {
            for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {
                String key = entry.getKey();
                TreeSet<LocalDate> val = entry.getValue();
                if (key.equals(licence)) {
                    for (LocalDate date2 : val) {
                        if (date.equals(date2) || date.equals(date2.plusDays(1)) || date.equals(date2.plusDays(2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        LocalDate date = LocalDate.now();
        licence = Parking.standardizeAndValidateLicence(licence);

        if (visitorLicence.containsKey(licence)) {
            for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {
                String key = entry.getKey();
                TreeSet<LocalDate> val = entry.getValue();
                if (key.equals(licence)) {
                    for (LocalDate date2 : val) {
                        if (date.equals(date2) || date.equals(date2.plusDays(1)) || date.equals(date2.plusDays(2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        // This method returns an ArrayList of all the licence plates registered for the
        // current date
        ArrayList<String> licencePlates = new ArrayList<String>();
        LocalDate date = LocalDate.now();

        for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {
            String key = entry.getKey();
            TreeSet<LocalDate> val = entry.getValue();
            for (LocalDate date2 : val) {
                if (date.equals(date2) || date.equals(date2.plusDays(1)) || date.equals(date2.plusDays(2))) {
                    licencePlates.add(key);
                    break; // TODO check if this is correct
                }
            }
        }
        return licencePlates;

    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
        // This method returns an ArrayList of all the licence plates registered for the
        // current date
        ArrayList<String> licencePlates = new ArrayList<String>();

        for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {
            String key = entry.getKey();
            TreeSet<LocalDate> val = entry.getValue();
            for (LocalDate date2 : val) {
                if (date.equals(date2) || date.equals(date2.plusDays(1)) || date.equals(date2.plusDays(2))) {
                    licencePlates.add(key);
                    break; // TODO check if this is correct
                }
            }
        }

        return licencePlates;

    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {
        // This method returns an ordered list of the entire period for which a licence
        // is registered.
        licence = Parking.standardizeAndValidateLicence(licence);

        ArrayList<LocalDate> timePeriods = new ArrayList<LocalDate>();

        for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {
            String key = entry.getKey();
            TreeSet<LocalDate> val = entry.getValue();
            if (key.equals(licence)) {
                for (LocalDate date : val) {
                    timePeriods.add(date);
                    timePeriods.add(date.plusDays(1));
                    timePeriods.add(date.plusDays(2));
                }
            }
        }
        timePeriods.sort(null);
        return timePeriods;
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
        // This method returns an ordered list of the entire period for which a licence
        // is registered.
        licence = Parking.standardizeAndValidateLicence(licence);

        ArrayList<LocalDate> timePeriods = new ArrayList<LocalDate>();

        for (Map.Entry<String, TreeSet<LocalDate>> entry : visitorLicence.entrySet()) {
            String key = entry.getKey();
            TreeSet<LocalDate> val = entry.getValue();
            if (key.equals(licence)) {
                for (LocalDate date : val) {
                    timePeriods.add(date);
                }
            }
        }
        timePeriods.sort(null);
        return timePeriods;
    }

    public HashMap<String, TreeSet<LocalDate>> getParkingRecord() {
        HashMap<String, TreeSet<LocalDate>> parkingRecord = new HashMap<>();

        for (String key : visitorLicence.keySet()) {
            TreeSet<LocalDate> reversed = new TreeSet<>(Collections.reverseOrder());
            reversed.addAll(visitorLicence.get(key));
            parkingRecord.put(key, reversed);
        }

        return parkingRecord;
    }

}
