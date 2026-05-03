import java.util.Arrays;

/** This class is for each individual golfer. Extends Player and holds up to 10 Score objects.
 * Calculates handicap index from the 5 lowest differentials of the last 10 rounds.
 * 
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
	public class Golfer extends Player {

	    private static final int MAX_SCORES = 10;

	    private Score[] scores;
	    private int     numScores;

	    /** Parameterized constructor.
	     * @param name the golfer's full name
	     */
	    public Golfer(String name) {
	        super(name);
	        scores    = new Score[MAX_SCORES];
	        numScores = 0;
	    }

	    // Default constructor
	    public Golfer() {
	        super();
	        scores    = new Score[MAX_SCORES];
	        numScores = 0;
	    }
	    
	    /** Adds a Score to the array if space is available.
	     * @param score the Score object to add
	     */
	    public void addScore(Score score) {
	        if (numScores < MAX_SCORES) {
	            scores[numScores++] = score;
	        } else {
	            System.out.println("Error: Score array is full for " + getName());
	        }
	    }

	    // ── Accessors ──────────────────────────────────────────────────────────

	    public int     getNumScores()      { return numScores; }
	    public Score[] getScores()         { return scores;    }
	    public Score   getScore(int index) { return scores[index]; }

	    // ── Handicap calculation ───────────────────────────────────────────────

	    /**
	     * Calculates and returns the golfer's current handicap index.
	     * Returns 0.0 if no scores have been entered.
	     */
	    @Override
	    public double calculateHandicap() {
	        if (numScores == 0) return 0.0;

	        // Step 1: compute a differential for each stored round
	        double[] diffs = new double[numScores];
	        for (int i = 0; i < numScores; i++) {
	            Score  s    = scores[i];
	            double diff = (s.getGrossScore() - s.getCourse().getCourseRating())
	                          * (113.0 / s.getCourse().getCourseSlope());
	            diffs[i] = Math.round(diff * 100.0) / 100.0;
	        }
	        double[] sorted = Arrays.copyOf(diffs, numScores);
	        Arrays.sort(sorted);
	        int useCount = Math.min(5, numScores);
	        double sum = 0.0;
	        for (int i = 0; i < useCount; i++) {
	            sum += sorted[i];
	        }
	        double avg = sum / useCount;
	        return Math.round(avg * 0.96 * 100.0) / 100.0;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();

	        sb.append(super.toString())
	          .append(String.format("  Current Handicap: %.2f%n", calculateHandicap()));

	        sb.append(String.format("%-6s  %-12s  %-30s  %-6s  %-5s%n",
	                "Score", "Date", "Course", "Rating", "Slope"));

	        for (int i = 0; i < numScores; i++) {
	            sb.append(scores[i].toString()).append("\n");
	        }

	        return sb.toString();
	    }
	}
