package hamzmas.Year2022.day4;

import java.util.*;
import java.util.regex.*;
import static hamzmas.Year2022.util.ReadFile.getLinesFromFile;

public class Day4 {
    static List<String> lines = getLinesFromFile("src/main/resources/Year2022/day4input.txt");

    public static int getSumOfPairsInRange() {
        int sum = 0;
        for(String line : lines) {
                if (isPairInRange(line)) {
                    sum += 1;
                }
        }
        return sum;
    }

    public static int getSumOfPairsOverlapping() {
        int sum = 0;
        for(String line : lines) {
                if (doesPairOverlap(line)) {
                    sum += 1;
                }
        }
        return sum;
    }


    private static Boolean isPairInRange(String pairing) {
        List<Integer> numbers = getNumbers(pairing);
        Boolean isInRange = false;
        int elf1Start = numbers.get(0);
        int elf1End = numbers.get(1);
        int elf2Start = numbers.get(2);
        int elf2End = numbers.get(3);

        if(elf1Start <= elf2Start && elf2End <= elf1End || elf2Start <= elf1Start && elf1End <= elf2End) {
            isInRange = true;
        }
        return isInRange;
    }

    private static Boolean doesPairOverlap(String pairing) {
        List<Integer> numbers = getNumbers(pairing);
        Boolean doesOverlap = false;
        int elf1Start = numbers.get(0);
        int elf1End = numbers.get(1);
        int elf2Start = numbers.get(2);
        int elf2End = numbers.get(3);

        if(elf2End >= elf1Start && elf1End >= elf2Start) {
            doesOverlap = true;
        }
        return doesOverlap;
    }


    private static List<Integer> getNumbers(String pairing) {
        Pattern p = Pattern.compile("[0-9]+");
        List<Integer> numbers = new ArrayList<>();
        Matcher m = p.matcher(pairing);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
    }

}
