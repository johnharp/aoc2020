package link.harper;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {
    private static Hashtable<Integer, Rule> ruleIndex =
            new Hashtable<>();

    public static Set<Integer> getRuleNumbers() {
        return ruleIndex.keySet();
    }

    public static Rule get(Integer ruleNum) {
        return ruleIndex.get(ruleNum);
    }

    private final static Pattern rootPattern = Pattern.compile("^([0-9]+): \"([a-z])\"");
    private final static Pattern singlePattern =
            Pattern.compile("^([0-9]+): ([0-9]+(?: [0-9]+)*)$");
    private final static Pattern doublePattern =
            Pattern.compile("^([0-9]+): ([0-9]+(?: [0-9]+)* \\| [0-9]+(?: [0-9]+)*)$");

    private int num;
    private String rootValid;
    private ArrayList<ArrayList<Integer>> subGroups;

    public Rule(String str) throws Exception {
        rootValid = null;
        subGroups = new ArrayList<>();

        Matcher m0 = rootPattern.matcher(str);
        Matcher m1 = singlePattern.matcher(str);
        Matcher m2 = doublePattern.matcher(str);

        if (m0.find()) {
            num = Integer.parseInt(m0.group(1));
            rootValid = m0.group(2);
        } else if (m1.find()) {
            num = Integer.parseInt(m1.group(1));
            ArrayList<Integer> group1 = new ArrayList<>();

            String[] split1 = m1.group(2).split(" " );


            for(int i =0; i<split1.length; i++) {
                Integer val = Integer.parseInt(split1[i]);
                group1.add(val);
            }
            subGroups.add(group1);

        } else if (m2.find()) {
            num = Integer.parseInt(m2.group(1));
            String[] split1 = m2.group(2).split(" \\| " );

            for (int i = 0; i<split1.length; i++) {
                ArrayList<Integer> group = new ArrayList<>();

                String grpline = split1[i];

                String[] split2 = grpline.split(" ");
                for(int j =0; j<split2.length; j++) {
                    Integer val = Integer.parseInt(split2[j]);
                    group.add(val);
                }
                subGroups.add(group);
            }

//            ArrayList<Integer> group1 = new ArrayList<>();
//            group1.add(Integer.parseInt(m2.group(2)));
//            group1.add(Integer.parseInt(m2.group(3)));
//
//            subGroups.add(group1);
//
//            ArrayList<Integer> group2 = new ArrayList<>();
//            group1.add(Integer.parseInt(m2.group(4)));
//            group1.add(Integer.parseInt(m2.group(5)));
//
//            subGroups.add(group2);
        } else {
            throw new Exception("Unknown rule pattern: " + str);
        }

        ruleIndex.put(num, this);
    }

    public ArrayList<String> getValids() {
        ArrayList<String> valids = new ArrayList<>();
        if (rootValid == null) {
            for (ArrayList<Integer> subGroup: subGroups) {
                StringBuilder sb = new StringBuilder();
                for (Integer ruleNum: subGroup) {
                    Rule sub = ruleIndex.get(ruleNum);
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
