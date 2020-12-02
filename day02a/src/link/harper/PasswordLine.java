package link.harper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordLine {
    public Integer minNumOccurrences;
    public Integer maxNumOccurences;
    public String letter;
    public String password;

    public PasswordLine(String txt) {
        Pattern p = Pattern.compile("^([0-9]+)\\-([0-9]+)\\s+([a-z]):\\s+(.+)");
        Matcher m = p.matcher(txt);

        if (m.find()) {
            String minNumStr = m.group(1);
            minNumOccurrences = Integer.parseInt(minNumStr);

            String maxNumStr = m.group(2);
            maxNumOccurences = Integer.parseInt(maxNumStr);

            letter = m.group(3);
            password = m.group(4);
        }
    }
}
