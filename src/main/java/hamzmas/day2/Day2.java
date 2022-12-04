package hamzmas.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day2 {

    static Map <String, Integer> handPoints = Map.of(
            "Rock", 1,
            "Paper", 2,
            "Scissors", 3,
            "Win", 6,
            "Draw", 3
    );

    static Map<String, String> handValues = Map.of(
            "A", "Rock",
            "B", "Paper",
            "C", "Scissors",
            "X", "Rock",
            "Y", "Paper",
            "Z", "Scissors"
    );

    static Map<String, String> handValuesWithOutcome = Map.of(
            "A", "Rock",
            "B", "Paper",
            "C", "Scissors",
            "X", "Loss",
            "Y", "Draw",
            "Z", "Win"
    );

    private static int checkResult(String opponent, String player) {
        int points = 0;
        String opponentInput = handValues.get(opponent);
        String playerInput = handValues.get(player);

        if(playerInput.equals("Rock")) {

            if(opponentInput.equals("Scissors")) {
                points += handPoints.get("Rock") + handPoints.get("Win");
            }
            else if(opponentInput.equals("Paper")) {
                points += handPoints.get("Rock");
            }
            else if(opponentInput.equals("Rock")) {
                points += handPoints.get("Rock") + handPoints.get("Draw");
            }
        }

        else if(playerInput.equals("Paper")) {
             if(opponentInput.equals("Rock")) {
                points += handPoints.get("Paper") + handPoints.get("Win");
            }
            else if(opponentInput.equals("Scissors")) {
                points += handPoints.get("Paper");
            }
            else if(opponentInput.equals("Paper")) {
                points += handPoints.get("Paper") + handPoints.get("Draw");
            }
        }

        else if(playerInput.equals("Scissors")) {
            if(opponentInput.equals("Paper")) {
                points += handPoints.get("Scissors") + handPoints.get("Win");;
            }
            else if(opponentInput.equals("Rock")) {
                points += handPoints.get("Scissors");
            }
            else if(opponentInput.equals("Scissors")) {
                points += handPoints.get("Scissors") + handPoints.get("Draw");
            }
        }

        return points;
    }

    private static int checkResultToReachOutcome(String opponent, String result) {
        int points = 0;
        String opponentInput = handValuesWithOutcome.get(opponent);
        String gameResult = handValuesWithOutcome.get(result);
        if(opponentInput.equals("Rock")) {

            if(gameResult.equals("Loss")) {
                points += handPoints.get("Scissors");
            }
            else if(gameResult.equals("Draw")) {
                points += handPoints.get("Rock") + handPoints.get("Draw");
            }
            else if(gameResult.equals("Win")) {
                points += handPoints.get("Paper") + handPoints.get("Win");
            }
        }

        else if(opponentInput.equals("Paper")) {
            if(gameResult.equals("Loss")) {
                points += handPoints.get("Rock");
            }
            else if(gameResult.equals("Draw")) {
                points += handPoints.get("Paper") + handPoints.get("Draw");
            }
            else if(gameResult.equals("Win")) {
                points += handPoints.get("Scissors") + handPoints.get("Win");
            }
        }

        else if(opponentInput.equals("Scissors")) {
            if(gameResult.equals("Loss")) {
                points += handPoints.get("Paper");
            }
            else if(gameResult.equals("Draw")) {
                points += handPoints.get("Scissors") + handPoints.get("Draw");
            }
            else if(gameResult.equals("Win")) {
                points += handPoints.get("Rock") + handPoints.get("Win");
            }
        }

        return points;
    }


    public static int getRockPaperScissorsScore() {
        int score = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/day2input.txt"))) {
            String line;
            ArrayList<String> opponentInputs = new ArrayList<>();
            ArrayList<String> playerInputs = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                opponentInputs.add(line.substring(0,1));
                playerInputs.add(line.substring(2,3));
            }
            for(int i = 0; i < opponentInputs.size(); i++) {
                score += checkResult(opponentInputs.get(i),playerInputs.get(i));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }


    public static int getRockPaperScissorsScoreWithOutcomeInput() {
        int score = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/day2input.txt"))) {
            String line;
            ArrayList<String> opponentInputs = new ArrayList<>();
            ArrayList<String> playerInputs = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                opponentInputs.add(line.substring(0,1));
                playerInputs.add(line.substring(2,3));
            }
            for(int i = 0; i < opponentInputs.size(); i++) {
                score += checkResultToReachOutcome(opponentInputs.get(i),playerInputs.get(i));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }
}
