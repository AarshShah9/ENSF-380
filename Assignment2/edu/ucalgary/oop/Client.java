package edu.ucalgary.oop;

public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private RewardsProfile rewardsInfo;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rewardsInfo = new RewardsProfile();
    }

    public boolean enrollRewards(String newNumber) {
        try {
            this.rewardsInfo = new RewardsProfile(newNumber);
            return true;

        } catch (InvalidRewardsNumException e) {
            return false;
        }

    }

    public int getRewardsPoints() {
        return this.rewardsInfo.getPoints();
    }

    public String getRewardsNumber() {
        return this.rewardsInfo.getNumber();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String num) {
        this.phoneNumber = num;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updatePoints(int addPoints) {
        this.rewardsInfo.setPoints(addPoints + this.rewardsInfo.getPoints());
    }

}
