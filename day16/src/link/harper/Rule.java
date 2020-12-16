package link.harper;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Rule {
    private String fieldName;
    private Range range1;
    private Range range2;

    private Hashtable<Integer, List<Rule>> ruleIndex = new Hashtable<>();
    // the number of fields = the number of rules
    private static int numRules = 0;

    public boolean contains(int n) {
        return range1.contains(n) ||
                range2.contains(n);
    }

    public Rule(String name, int min1, int max1, int min2, int max2) {
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
        List<Rule> validRules;
        if (ruleIndex.containsKey(n)) {
            validRules = ruleIndex.get(n);
        } else {
            validRules = new ArrayList<>();
            ruleIndex.put(n, validRules);
        }

        validRules.add(this);
    }
}
