import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads player data from data.txt, builds an array of Player objects
 * (Golfers & Bowlers), then prints each of their info.
 * 
 * @author Enaya S. Laborn
 * @since 6 April 2026
 * 
 * Version 1.0.0
 */
public class PlayerTester {

    private static final int MAX_PLAYERS = 20;

    public static void main(String[] args) {

        Player[] players   = new Player[MAX_PLAYERS];
        int      numPlayers = 0;

        // Read  file 
        try {
            Scanner sc = new Scanner(new File("data.txt"));

            while (sc.hasNextLine()) {

                // Read scores skip blank lines
                String raw = sc.nextLine().trim();
                if (raw.isEmpty()) continue;

                int    numScores = Integer.parseInt(raw);
                String type      = sc.nextLine().trim();         // G or B
                String nameLine  = sc.nextLine().trim();         // Name,extra

                String[] nameParts = nameLine.split(",", 2);
                String   name      = nameParts[0].trim();

                if (type.equalsIgnoreCase("G")) {

                    // Build Golfer 
                    Golfer golfer = new Golfer(name);

                    for (int i = 0; i < numScores; i++) {
                        String   scoreLine = sc.nextLine().trim();
                        String[] parts     = scoreLine.split(",");

                        String courseName  = parts[0].trim();
                        int    grossScore  = Integer.parseInt(parts[1].trim());
                        String date        = parts[2].trim();
                        double rating      = Double.parseDouble(parts[3].trim());
                        int    slope       = Integer.parseInt(parts[4].trim());

                        Course course = new Course(courseName, rating, slope);
                        Score  score  = new Score(course, grossScore, date);
                        golfer.addScore(score);
                    }

                    players[numPlayers++] = golfer;

                } else if (type.equalsIgnoreCase("B")) {

                    // Build Bowler
                    String teamName = (nameParts.length > 1)
                                      ? nameParts[1].trim()
                                      : "No Team";

                    Bowler bowler = new Bowler(name, teamName);

                    for (int i = 0; i < numScores; i++) {
                        String   scoreLine = sc.nextLine().trim();
                        String[] parts     = scoreLine.split(",");

                        String laneName = parts[0].trim();
                        int    score    = Integer.parseInt(parts[1].trim());
                        String date     = parts[2].trim();

                        BowlerScore bs = new BowlerScore(laneName, score, date);
                        bowler.addScore(bs);
                    }

                    players[numPlayers++] = bowler;

                } else {
                    System.out.println("Unknown player type: " + type + ". Skipping.");
                }
            }
            sc.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: data.txt not found. "
                    + "Please place it in the same directory as the program.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing file: " + e.getMessage());
            return;
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(players[i].toString());
        }

        System.out.println("\nTotal players loaded: " + numPlayers);
    }
}
