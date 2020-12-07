package link.harper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BagSpec {
    private String color;
    private int count;
    private List<BagSpec> contains;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BagSpec> getContains() {
        return contains;
    }

    public void setContains(List<BagSpec> contains) {
        this.contains = contains;
    }

    public static void parseLine(String line) {
        //  ([0-9]+)(,\s*[0-9]+)*.$
        String linePattern = "^(\\S+\\s\\S+) bag[s]? contain (\\d+) (\\S+\\s\\S+) bag[s]?(?:, (\\d+) (\\S+\\s\\S+) bag[s]?)*\\.$";
        Pattern p = Pattern.compile(linePattern);
        Matcher m = p.matcher(line);

        if (m.find()) {
            System.out.println("OK, matches: " + line);
            System.out.println(m.group(1));
            System.out.println("\t[" + m.group(2) + " => " + m.group(3) + "]");

            System.out.println("\t" + m.groupCount());

            for (int i = 4; i<m.groupCount(); i+=2) {
                System.out.println("\t[" + m.group(i)+ " => " + m.group(i+1) + "]");
            }

        }
    }
}
