package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.regex.*;

public class RobotDataLine implements Cloneable {
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;
    private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    public RobotDataLine(String line) throws IllegalArgumentException {

        Matcher robotMatcher = ROBOT_PATTERN.matcher(line);
        Matcher dateMatcher = DATE_PATTERN.matcher(line);

        if (robotMatcher.find() && dateMatcher.find()) {
            this.dataLine = line;
            this.robotID = robotMatcher.group(1); // issue is here
            this.movement = new Movement(line);
            this.sensor = new Sensor(line);
            try {
                this.date = LocalDate.of(Integer.parseInt(dateMatcher.group(3)),
                        Integer.parseInt(dateMatcher.group(2)),
                        Integer.parseInt(dateMatcher.group(1)));
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format");
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getRobotID() {
        return this.robotID;
    }

    public String getDataLine() {
        return this.dataLine;
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    public Movement getMovement() {
        return this.movement;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Object clone() throws CloneNotSupportedException {
        RobotDataLine clone = (RobotDataLine) super.clone();
        clone.sensor = (Sensor) this.sensor.clone();
        clone.movement = (Movement) this.movement.clone();

        return clone;
    }
}
