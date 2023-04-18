package edu.ucalgary.oop;

public class EmergVet {

    String name;
    String phoneNum;

    public EmergVet(String name, String phoneNumber) {
        this.name = name;
        this.phoneNum = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }
}
