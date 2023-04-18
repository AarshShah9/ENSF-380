package edu.ucalgary.oop;

import java.io.*;

/*
 * TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of
 * 19L.
 * Member data names should be based on those implied by the getters. Member
 * data are not final.
 */

/*
 * getSentence()
 * Getter method, returns String
 */

/*
 * getMonths()
 * Getter method, returns String[]
 */

/*
 * getDays()
 * Getter method, returns String[]
 */

/*
 * getMonth()
 * Accepts an integer 0-11 corresponding to an index in the months array,
 * and returns the value at that index. (e.g., 0 = January)
 */

/*
 * getDay()
 * Accepts an integer 0-30 corresponding to an index in the day array,
 * and returns the value at that index. (e.g., 30 = 31st)
 */

/*
 * Constructor
 * Accepts a String array of months, a String array of days, and a String
 * containing a sentence with formatting.
 */
public class TranslationText implements Serializable {
    static final long serialVersionUID = 19L;
    private String[] months;
    private String[] days;
    private String sentence;

    public TranslationText(String[] months, String[] days, String sentence) {
        this.months = months;
        this.days = days;
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }

    public String[] getMonths() {
        return this.months;
    }

    public String[] getDays() {
        return this.days;
    }

    public String getMonth(int month) {
        return this.months[month];
    }

    public String getDay(int day) {
        return this.days[day];
    }

}
