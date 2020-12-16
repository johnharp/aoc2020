package link.harper;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static Pattern rulePattern = Pattern.compile("^([^:]+): ([0-9]+)-([0-9]+) or ([0-9]+)-([0-9]+)$");
    public void load(String prefix) throws Exception{
        String rulesFile = prefix + "-rules.txt";
        String ticketFile = prefix + "-ticket.txt";
        String nearbyTicketsFile = prefix + "-nearby.txt";

        loadRules(rulesFile);
    }

    private void loadRules(String rulesFile) throws Exception{
        Scanner scanner = new Scanner(
                new File(rulesFile));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher ruleMatcher = rulePattern.matcher(line);

            if (ruleMatcher.find()) {
                String fieldName = ruleMatcher.group(1);
                String rangeStart1 = ruleMatcher.group(2);
                String rangeEnd1 = ruleMatcher.group(3);
                String rangeStart2 = ruleMatcher.group(4);
                String rangeEnd2 = ruleMatcher.group(5);

                System.out.println("field '" + fieldName + "' " +
                        "can be from " + rangeStart1 + " to " + rangeEnd1 +
                        " or can be from " + rangeStart2 + " to " + rangeEnd2);
            } else {
                throw new Exception("un-parsable rule: '" + line + "'");
            }

        }
    }
}
