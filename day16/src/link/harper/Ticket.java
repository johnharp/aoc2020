package link.harper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ticket {
    int[] fieldValues;

    private static ArrayList<Ticket> allTickets = new ArrayList<>();

    public static ArrayList<Ticket> getAllTickets() {
        return allTickets;
    }

    public static ArrayList<Ticket> getValidTickets() {
        ArrayList<Ticket> validTickets = new ArrayList<>();

        for(Ticket t: Ticket.getAllTickets()) {
            boolean isValid = true;
            for(int fieldValue: t.fieldValues) {
                List<FieldRule> fieldRules = FieldRule.getFieldRulesValidFor(fieldValue);
                if (fieldRules == null || fieldRules.size() == 0) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                validTickets.add(t);
            }
        }

        return validTickets;
    }

    public Ticket(String fieldValuesStr) {
        fieldValues = Arrays.stream(fieldValuesStr.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        allTickets.add(this);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<fieldValues.length; i++) {
            sb.append(fieldValues[i]);
            if (i < fieldValues.length - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}
