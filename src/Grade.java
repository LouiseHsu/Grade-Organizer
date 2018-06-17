import java.util.ArrayList;
import java.util.List;

public class Grade {

    private double totalGrade;
    private List<GradePortion> gradesPortions;

    //completed courses
    Grade(int grade) {
        this.totalGrade = grade;
    }

    //in progress courses
    Grade() {
        this.totalGrade = 0;
        gradesPortions = new ArrayList<>();
    }

    String getLetter() {
        if (totalGrade >= 90) {
            return "A";
        }
        if (totalGrade >= 85) {
            return "A-";
        }
        if (totalGrade >= 80) {
            return "A";
        }
        if (totalGrade >= 76) {
            return "B+";
        }
        if (totalGrade >= 72) {
            return "B";
        }
        if (totalGrade >= 68) {
            return "B-";
        }
        if (totalGrade >= 64) {
            return "C+";
        }
        if (totalGrade >= 60) {
            return "C";
        }
        if (totalGrade >= 55) {
            return "C-";
        }
        if (totalGrade >= 50) {
            return "D";
        }
        else {
            return "F";
        }
    }




    double getTotalGrade() {
        double sum = 0;
        for (int i = 0; i < gradesPortions.size() - 1; i++) {
            sum += gradesPortions.get(i).getGradewithWorth();
        }
        totalGrade = sum;
        return totalGrade;
    }

    void addPortion (int numParts, boolean compound, double worth, int grade, String type) throws OverWorthException {
        gradesPortions.add(new GradePortion(numParts, compound, worth, grade, type));

        if (checkWorth() == 1) {
            throw new OverWorthException("WARNING: Total grade break down sums to less than 100%");
        }
    }

    int checkWorth() throws OverWorthException {
        int totalSum = 0;
        for (int i = 0; i < gradesPortions.size(); i++) {
            totalSum += gradesPortions.get(i).getWorth();
        }

        if (totalSum == 1) {
            return 0;
        } else if (totalSum < 1) {
            System.out.println("Total breakdown sums to " + totalSum + ".");
            return -1;
        } else {
            // Over 100%, exception clause
            throw new OverWorthException("WARNING: Total grade break down sums to MORE than 100%");
        }
    }

    public class OverWorthException extends Exception {

        public OverWorthException(String message) {
            super(message);
        }

        public OverWorthException(String message, Throwable throwable) {
            super(message, throwable);
        }

    }

}