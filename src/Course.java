public class Course {

    private String name;
    private Grade grade;
    private String letter;
    private String year;
    private int credits;
    private int classAvg;


    // Constructor for a class in progress
    Course (String name, String year, int credits) {
        this.name = name;
        this.year = year;
        this.credits = credits;
    }

    //Constructor for a completed class
    Course (String name, int grade, String year, int credits, int classAvg) {
        this.name = name;
        this.grade = new Grade(grade);
        this.letter = this.grade.getLetter();
        this.year = year;
        this.credits = credits;
        this.classAvg = classAvg;
    }

    double getGrade() {
        return grade.getGrade();
    }
}
