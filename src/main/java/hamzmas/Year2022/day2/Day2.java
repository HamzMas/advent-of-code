package hamzmas.Year2022.day2;

import java.util.*;
import static hamzmas.Year2022.util.ReadFile.getLinesFromFile;

public class Day2 {

    static List<String> lines = getLinesFromFile("src/main/resources/Year2022/day2input.txt");

    public static int getRockPaperScissorsScore() {
        int score = 0;
        for(String line : lines) {
            Character opponentInput = line.substring(0,1).charAt(0);
            Character playerInput = line.substring(2,3).charAt(0);
            score += checkResult(opponentInput,playerInput);
        }
        return score;
    }

    public static int getRockPaperScissorsScoreWithOutcomeInput() {
        int score = 0;
        for(String line : lines) {
            Character opponentInput = line.substring(0,1).charAt(0);
            Character gameOutcome = line.substring(2,3).charAt(0);
            score += checkResultToReachOutcome(opponentInput,gameOutcome);
        }
        return score;
    }

    private static int getHandScore(Character player) {
        int totalScore = 0;
        if (player == 'X'){
            totalScore += 1;
        }
        else if (player == 'Y') {
            totalScore += 2;
        }
        else if (player == 'Z') {
            totalScore += 3;
        }
        return totalScore;
    }

    private static int checkResult(Character opponent, Character player) {
        int points = 0;
        int gameResult = player - opponent;

        if ((gameResult == 21 || opponent < player - 23) && gameResult != 25){
            points += getHandScore(player) + 6 ;
        }
        else if (gameResult == 25 || opponent > player - 23 ) {
            points += getHandScore(player);
        }
        else if (gameResult == 23){
            points += getHandScore(player) + 3;
        }
        return points;
    }

    private static int checkResultToReachOutcome(Character opponent, Character outcome) {
        int points = 0;

        if (outcome == 'X') {
            if (opponent - 66 < 0) {
                points += 3;
            }
            else {
                points += opponent - 65;
            }
        }
        else if(outcome == 'Y') {
            points += opponent - 64 + 3;
        }
        else if (outcome == 'Z') {
            points += 6;
            if(opponent - 64 > 2) {
                points += 1;
            }
            else {
                points += opponent - 63;
            }
        }

        return points;
    }
}
