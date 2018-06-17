import java.util.ArrayList;
import java.util.List;

public class GradePortion {
    //with each entered grade, show avg grade (reduces need for separate classes)
    // a section of overall grade, eg lab, exam, assignment(s)

    //private PortionType type;
    private double grade;
    private double worth; // percentage, 0 < worth < 1
    private boolean compound; //Portions that themselves contain assignments eg. Assignments are 15%, there are 3 of them, 5% each.
    private String type;
    private List<Integer> grades;
    private int numParts;

    GradePortion(int numParts, boolean compound, double worth, int grade, String type) {
        this.type = type;
        this.grade = grade;
        this.worth = worth;
        this.compound = compound;
        if (compound) {
            grades = new ArrayList<>();
            this.numParts = numParts;
        }
    }

    double getWorth() {
        return this.worth;
    }

    double getGrade() {
        if (compound) {
            int sum = 0;
            for (int i = 0; i < grades.size(); i++) {
                sum += grades.get(i);
            }
            grade = sum/grades.size();
            return grade;
        }
        return grade;
    }

    double getGradewithWorth() {
        getGrade();
        return grade * worth;
    }
}
