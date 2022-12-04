package hamzmas.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {


    public static int getSumOfRucksack() {
        int sum = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/day3input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
