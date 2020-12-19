package link.harper;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {
    private final static Pattern rootPattern = Pattern.compile("^([0-9]+): \"([a-z])\"");

    private int num;
    private String rootValid;
    private ArrayList<ArrayList<Rule>> subGroups;

    public Rule(String str) {
        rootValid = null;
        subGroups = new ArrayList<>();

        Matcher m = rootPattern.matcher(str);

        if (m.find()) {
            num = Integer.parseInt(m.group(1));
            rootValid = m.group(2);
        }
    }

    public ArrayList<String> getValids() {
        ArrayList<String> valids = new ArrayList<>();
        if (rootValid == null) {
            for (ArrayList<Rule> subGroup: subGroups) {
                StringBuilder sb = new StringBuilder();
                for (Rule sub: subGroup) {
                    for (String v: sub.getValids()) {
                        sb.append(v);
                    }
                }
                valids.add(sb.toString());
            }
        } else {
            valids.add(rootValid);
        }

        return valids;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(num);
       sb.append(": ");
       sb.append(getValids());

       return sb.toString();
    }
}
