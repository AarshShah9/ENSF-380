package edu.ucalgary.oop;

public class RewardsProfile {

    private String rewardsNum = new String("Not enrolled");
    private int pointsTotal = 10;

    public RewardsProfile() {
    }

    public RewardsProfile(String newNumber) throws InvalidRewardsNumException {
        if (newNumber.length() != 7 || !newNumber.matches("[0-9]+")) {
            throw new InvalidRewardsNumException();
        } else {
            this.rewardsNum = newNumber;

        }
    }

    public void setPoints(int addPoints) {
        this.pointsTotal = addPoints;
    }

    public int getPoints() {
        return this.pointsTotal;
    }

    public String getNumber() {
        return this.rewardsNum;
    }

}
