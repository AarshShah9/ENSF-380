package edu.ucalgary.oop;

import java.util.regex.*;

public class Sensor implements FormattedOutput, Cloneable {

    private String sensor;
    private static final String REGEX = "\\(([a-z]+)\\)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException {
        Matcher sensorMatcher = PATTERN.matcher(sensor);
        if (sensorMatcher.find()) {
            this.sensor = sensorMatcher.group(1);

        } else {
            throw new IllegalArgumentException();
        }

    }

    public String getSensor() {
        return this.sensor;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getFormatted() {
        return "Sensor: " + this.sensor;
    }

}
