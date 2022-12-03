package hamzmas.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {

    static BufferedReader reader;
    public static int getMostCalories() {
        ArrayList<Integer> caloriesList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/day1input.txt"))) {
            String line;
            int total = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.isEmpty()) {
                    caloriesList.add(total);
                    total = 0;
                }
                else {
                    total += Integer.parseInt(line);
                }
            }
        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.max(caloriesList);
    }

    public static int getTotalOfTopThreeElves() {
        int first = 0, second = 0, third = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/day1input.txt"))) {
            String line;
            int total = 0;
            while ((line = bufferedReader.readLine()) != null) {
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
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return first + second + third;
    }
}
