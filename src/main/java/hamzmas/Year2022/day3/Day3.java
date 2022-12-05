package hamzmas.Year2022.day3;

import java.util.List;
import static hamzmas.Year2022.util.ReadFile.getLinesFromFile;

public class Day3 {

    static List<String> lines = getLinesFromFile("src/main/resources/Year2022/day3input.txt");
    public static int getSumOfRucksack() {
        int sum = 0;
        for(String line : lines) {
            String firstHalf = line.substring(0, line.length() / 2);
            String secondHalf = line.substring(line.length() / 2);
            Character common = findCommonLetter(firstHalf, secondHalf);
            sum += getLetterValue(common);
        }
        return sum;
    }

    public static int getSumOfRucksacksPer3() {
        int sum = 0;
        for(int i = 0; i < lines.size(); i+=3) {
            String firstLine = lines.get(i);
            String secondLine = lines.get(i+1);
            String thirdLine = lines.get(i+2);
            Character common = findCommonLetter(firstLine, secondLine, thirdLine);
            sum += getLetterValue(common);
        }
        return sum;
    }

    private static int getLetterValue(Character character) {
        int score = character.charValue();
        if (score >= 65 && score <= 90) {
            score -= 64 - 26;
        } else {
            score -= 96;
        }
        return score;
    }


    private static Character findCommonLetter(String s1, String s2) {
        Character commonChar = null;
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    commonChar = s1.charAt(i);
                    break;
                }
            }
        }
        return commonChar;
    }


    private static Character findCommonLetter(String s1, String s2, String s3) {
        Character commonChar = null;
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                for(int k = 0; k < s3.length(); k++) {
                    if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) ==  s3.charAt(k)) {
                        commonChar = s1.charAt(i);
                        break;
                    }
                }
            }
        }
        return commonChar;
    }
}
