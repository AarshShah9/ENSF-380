package edu.ucalgary.oop;

import java.util.regex.*;

public class Movement implements FormattedOutput, Cloneable {
    private String action;
    private String direction;
    private static final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException {
        Matcher movementMatcher = PATTERN.matcher(movement);
        this.action = null;
        this.direction = null;

        if (movementMatcher.find()) {
            for (Actions action : Actions.values()) {
                if (movementMatcher.group(1).compareTo(action.name()) == 0) {
                    this.action = movementMatcher.group(1);
                }

            }
            for (Directions direction : Directions.values()) {
                if (movementMatcher.group(2).compareTo(direction.name()) == 0) {
                    this.direction = movementMatcher.group(2);
                }
            }
        } else {
            System.out.println("Error is occuring for: Movement: " + movement);
            throw new IllegalArgumentException();
        }

        if (this.action == null || this.direction == null) {
            throw new IllegalArgumentException();
        }

    }

    public String getAction() {
        return this.action;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFormatted() {
        String formatted = "Action: " + this.action;
        formatted += ", Direction: " + Directions.valueOf(this.direction).toString();
        return formatted;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
