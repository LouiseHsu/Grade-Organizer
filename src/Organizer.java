import java.util.ArrayList;
import java.util.List;

public class Organizer {

    List<Course> courses;
    private static Organizer organizer;

    //Constructor

    private Organizer() {
        courses = new ArrayList<>();
    }

    public static Organizer getOrganizer() {
        if (organizer == null) {
            organizer = new Organizer();
        }
        return organizer;
    }

    public void addCourse(boolean completed, String name, int grade, String year, int credits, int classAvg) {
        if (completed) {
            courses.add(new Course(name, grade, year, credits, classAvg));
            System.out.println(name + " added with a grade of " + grade + "!");
        } else {
            courses.add(new Course(name, year, credits));
            System.out.println(name + " added!");
        }
    }

    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < courses.size(); i++) {
            sum+= courses.get(0).getGrade();
        }
        return sum/courses.size();
    }
}
