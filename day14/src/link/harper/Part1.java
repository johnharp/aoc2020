package link.harper;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static Pattern maskPattern = Pattern.compile("^mask = ([01X]+)$");
    private static Pattern memPattern = Pattern.compile("^mem\\[([0-9])+\\] = ([0-9]+)$");

    public static void main(String[] args) throws Exception{
        Input in = new Input("example1-input.txt");
        for(String line : in.getLines()) {
            Matcher maskMatcher = maskPattern.matcher(line);
            Matcher memMatcher = memPattern.matcher(line);

            if (maskMatcher.find()) {
                System.out.println("Set mask to " + maskMatcher.group(1));
            } else if (memMatcher.find()) {
                System.out.println("Set mem at [" + memMatcher.group(1) +
                        "] to " + memMatcher.group(2));
            } else {
                throw new Exception("Unknown input found: " + line);
            }
        }
    }

}
