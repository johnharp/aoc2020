package link.harper;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FieldRule {
    private String fieldName;
    private Range range1;
    private Range range2;

    private static Hashtable<Integer, List<FieldRule>> ruleIndex = new Hashtable<>();
    // the number of fields = the number of rules
    private static int numRules = 0;

    public static List<FieldRule> getFieldRulesValidFor(int n) {
        return ruleIndex.get(n);
    }


    public boolean contains(int n) {
        return range1.contains(n) ||
                range2.contains(n);
    }

    public FieldRule(String name, int min1, int max1, int min2, int max2) {
        fieldName = name;
        range1 = new Range(min1, max1);
        range2 = new Range(min2, max2);

        for (int i = min1; i<= max1; i++) {
            addToIndex(i);
        }

        for (int i = min2; i <= max2; i++) {
            addToIndex(i);
        }
        numRules++;
    }

    private void addToIndex(int n)
    {
        List<FieldRule> validFieldRules;
        if (ruleIndex.containsKey(n)) {
            validFieldRules = ruleIndex.get(n);
        } else {
            validFieldRules = new ArrayList<>();
            ruleIndex.put(n, validFieldRules);
        }

        validFieldRules.add(this);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(fieldName);
        sb.append(" = ");
        sb.append(range1);
        sb.append(" ");
        sb.append(range2);
        return sb.toString();
    }
}
