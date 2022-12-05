package hamzmas.Year2022.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {


    public static int getSumOfRucksack() {
        int sum = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/Year2022/day3input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String firstHalf = line.substring(0, line.length()/2);
                String secondHalf = line.substring(line.length()/2);
                Character common = findCommonLetter(firstHalf, secondHalf);
                sum += getLetterValue(common);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static int getSumOfRucksacksPer3() {
        int sum = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/Year2022/day3input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String firstLine = line;
                String secondLine = bufferedReader.readLine();
                String thirdLine = bufferedReader.readLine();
                Character common = findCommonLetter(firstLine, secondLine, thirdLine);
                sum += getLetterValue(common);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
