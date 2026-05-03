/**
 * 
 * Represents a golf course with a name, rating, and slope.
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
public class Course {
	private String courseName;
    private double courseRating;  
    private int    courseSlope;    

    /* Parameterized constructor.
     * Mutators are called so validation is applied automatically.
     */
    public Course(String courseName, double courseRating, int courseSlope) {
        this.courseName = courseName;
        setCourseRating(courseRating);
        setCourseSlope(courseSlope);
    }

    // Default constructor
    public Course() {
        this.courseName  = "Unknown Course";
        this.courseRating = 72.0;
        this.courseSlope  = 113;
    }

    // Accessors

    public String getCourseName()   { return courseName;   }
    public double getCourseRating() { return courseRating; }
    public int    getCourseSlope()  { return courseSlope;  }

    // Mutators 
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseRating(double courseRating) {
        if (courseRating >= 60.0 && courseRating <= 80.0) {
            this.courseRating = courseRating;
        } else {
            System.out.println("Error: Course rating " + courseRating +
                    " is out of range (60–80). Setting to default 72.0.");
            this.courseRating = 72.0;
        }
    }

    public void setCourseSlope(int courseSlope) {
        if (courseSlope >= 55 && courseSlope <= 155) {
            this.courseSlope = courseSlope;
        } else {
            System.out.println("Error: Course slope " + courseSlope +
                    " is out of range (55–155). Setting to default 113.");
            this.courseSlope = 113;
        }
    }

    @Override
    public String toString() {
        return String.format("%-30s %.1f    %d", courseName, courseRating, courseSlope);
    }
}