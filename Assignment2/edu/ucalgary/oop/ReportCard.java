package edu.ucalgary.oop;

public class ReportCard {

    private final Booking REPORT;

    public ReportCard(Booking reportInfo) {
        this.REPORT = reportInfo;
    }

    public String printReport() {
        String result = "";
        result += this.REPORT.getCaregiver().getName();
        result += " enjoyed taking care of ";
        result += this.REPORT.getBookedPet().getName();
        result += ". See you next time!";

        return result;
    }
}
