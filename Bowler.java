/**
 * This class is for each individual bowler extends Player and holds up to 10 BowlerScore objects.
 * Handicap is based on the average of the last 5 scores vs. a base of 200.
 * 
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
public class Bowler extends Player {

    private static final int MAX_SCORES  = 10;
    private static final int BASE        = 200;
    private static final double PCT      = 0.80;

    private String       teamName;
    private BowlerScore[] scores;
    private int           numScores;

    /** Parameterized constructor.
     * @param name     the bowler's full name
     * @param teamName the name of the bowler's team
     */
    public Bowler(String name, String teamName) {
        super(name);
        this.teamName = teamName;
        scores        = new BowlerScore[MAX_SCORES];
        numScores     = 0;
    }

    // Default constructor. 
    public Bowler() {
        super();
        this.teamName = "No Team";
        scores        = new BowlerScore[MAX_SCORES];
        numScores     = 0;
    }

    /** Adds a BowlerScore to the array if space is available.
     * @param bs the BowlerScore object to add
     */
    public void addScore(BowlerScore bs) {
        if (numScores < MAX_SCORES) {
            scores[numScores++] = bs;
        } else {
            System.out.println("Error: Score array is full for " + getName());
        }
    }

    // Accessors

    public String       getTeamName()        { return teamName;  }
    public int          getNumScores()        { return numScores; }
    public BowlerScore[] getScores()          { return scores;    }
    public BowlerScore  getScore(int index)   { return scores[index]; }

    // Mutators

    public void setTeamName(String teamName) { this.teamName = teamName; }

    // Handicap calculation ]

    /** Calculates and returns the bowler's current handicap.
     * Returns 0.0 if no scores have been entered.
     */
    @Override
    public double calculateHandicap() {
        if (numScores == 0) return 0.0;

        // Use the last 5 scores (or all of them if fewer than 5)
        int count    = Math.min(5, numScores);
        int startIdx = numScores - count;

        double sum = 0.0;
        for (int i = startIdx; i < numScores; i++) {
            sum += scores[i].getScore();
        }

        double avg      = sum / count;
        double handicap = (BASE - avg) * PCT;
        return Math.round(handicap * 100.0) / 100.0;
    }

    // Returns a formatted display of the bowler's profile and all games.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
          .append(String.format("  Team Name: %s  Current Handicap: %.2f%n",
                  teamName, calculateHandicap()));
        sb.append(String.format("%-6s  %-12s  %s%n", "Score", "Date", "Lane"));
        for (int i = 0; i < numScores; i++) {
            sb.append(scores[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
