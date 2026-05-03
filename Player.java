/**
 * Abstract class representing a generic player. Serves as the superclass for Golfer and Bowler.
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
public abstract class Player{
	private String name;
    private int IDNum;
    private static int nextIDNum = 1000;

    //Parameterized constructor — sets name and auto-assigns the next ID.
    public Player(String name) {
        this.name = name;
        this.IDNum = nextIDNum++;
    }

    //Default constructor
    public Player() {
        this.name = "Unknown";
        this.IDNum = nextIDNum++;
    }

    // Accessors

    public String getName()  { return name; }
    public int    getIDNum() { return IDNum; }

    // Mutators 

    public void setName(String name) { this.name = name; }

    //Assigns the next available auto-generated ID to this player 
    public void setIDNum() { this.IDNum = nextIDNum++; }


    /*/Calculates and returns the player's current handicap
     * Subclasses must provide sport-specific logic
     */
    public abstract double calculateHandicap();

    @Override
    public String toString() {
        return String.format("%s  ID Number: %d", name, IDNum);
    }
}