/**
 * Represents a single golf round score, linked to a Course object. Score is a gross score (no handicap applied).
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
 
public class Score {
	private Course course;
    private int    grossScore;
    private String date;

    /**
     * Parameterized constructor.
     * @param course     the Course object for this round
     * @param grossScore the player's unadjusted stroke total
     * @param date       date played (mm/dd/yyyy)
     */
    public Score(Course course, int grossScore, String date) {
        this.course     = course;
        this.grossScore = grossScore;
        this.date       = date;
    }

    // Default constructor 
    public Score() {
        this.course     = new Course();
        this.grossScore = 0;
        this.date       = "00/00/0000";
    }

    public Course getCourse()     { return course;     }
    public int    getGrossScore() { return grossScore; }
    public String getDate()       { return date;       }

    public void setCourse(Course course)      { this.course     = course;     }
    public void setGrossScore(int grossScore) { this.grossScore = grossScore; }
    public void setDate(String date)          { this.date       = date;       }

    @Override
    public String toString() {
        return String.format("%-6d  %-12s  %s",
                grossScore, date, course.toString());
    }
}