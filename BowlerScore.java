/**
 * Represents a single bowling game score.
 * 
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
public class BowlerScore {

    private String laneName;
    private int    score;
    private String date;

    /** Parameterized constructor.
     * @param laneName 
     * @param score 
     * @param date
     */
    public BowlerScore(String laneName, int score, String date) {
        this.laneName = laneName;
        this.score    = score;
        this.date     = date;
    }

    // Default constructor — sets safe default values. 
    public BowlerScore() {
        this.laneName = "Unknown Lane";
        this.score    = 0;
        this.date     = "00/00/0000";
    }

    // Accessors

    public String getLaneName() { return laneName; }
    public int    getScore()    { return score;    }
    public String getDate()     { return date;     }

    // Mutators 

    public void setLaneName(String laneName) { this.laneName = laneName; }
    public void setScore(int score)          { this.score    = score;    }
    public void setDate(String date)         { this.date     = date;     }

    
    @Override
    public String toString() {
        return String.format("%-6d  %-12s  %s", score, date, laneName);
    }
}
