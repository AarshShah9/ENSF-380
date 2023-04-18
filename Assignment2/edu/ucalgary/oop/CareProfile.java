package edu.ucalgary.oop;

public class CareProfile {

    String[] medList;
    String medInstructions;
    String feedingInstructions;

    public CareProfile(String[] medList, String meds, String feeding) {
        this.medList = medList;
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }

    public String summarizeCareInstructions() {
        String summary = new String("");
        for (String med : medList) {
            summary += med;
            if (med != medList[medList.length - 1])
                summary += ", ";
        }
        summary += '\n' + medInstructions + '\n' + feedingInstructions;
        return summary;
    }

}
