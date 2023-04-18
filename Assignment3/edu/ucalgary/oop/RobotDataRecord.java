package edu.ucalgary.oop;

import java.util.*;

public class RobotDataRecord implements Cloneable {
    private ArrayList<RobotDataLine> log;

    public RobotDataRecord(String[] array) {
        this.log = new ArrayList<RobotDataLine>();
        for (String line : array) {
            try {
                this.log.add(new RobotDataLine(line));

            } catch (IllegalArgumentException e) {
                continue;

            }
        }
    }

    public RobotDataLine getLine(int index) {
        return this.log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord() {
        return this.log;
    }

    public Object clone() throws CloneNotSupportedException {

        RobotDataRecord clone = (RobotDataRecord) super.clone();
        clone.log = new ArrayList<RobotDataLine>();

        for (int i = 0; i < this.log.size(); i++) {
            clone.log.add((RobotDataLine) this.log.get(i).clone());

        }

        return clone;
    }

}
