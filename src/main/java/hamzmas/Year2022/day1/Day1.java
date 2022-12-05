package hamzmas.Year2022.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static hamzmas.Year2022.util.ReadFile.getLinesFromFile;

public class Day1 {

    static List<String> lines = getLinesFromFile("src/main/resources/Year2022/day1input.txt");

    public static int getMostCalories() {
        ArrayList<Integer> caloriesList = new ArrayList<>();
        int total = 0;
        for(String line : lines) {
            if(line.isEmpty()) {
                caloriesList.add(total);
                total = 0;
            }
            else {
                total += Integer.parseInt(line);
            }
        }
        return Collections.max(caloriesList);
    }

    public static int getTotalOfTopThreeElves() {
        int first = 0, second = 0, third = 0;
        int total = 0;
        for(String line : lines) {
            if(line.isEmpty()) {
                if(total > first) {
                    third = second;
                    second = first;
                    first = total;
                }
                else if(total > second) {
                    third = second;
                    second = total;
                }
                else if(total > third){
                    third = total;
                }
                total = 0;
            }
            else {
                total += Integer.parseInt(line);
                if(total > third) {
                    third = total;
                }
            }
        }
        return first + second + third;
    }
}
