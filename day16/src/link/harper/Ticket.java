package link.harper;

import java.util.ArrayList;
import java.util.Arrays;

public class Ticket {
    int[] fieldValues;

    private static ArrayList<Ticket> allTickets = new ArrayList<>();

    public static ArrayList<Ticket> getAllTickets() {
        return allTickets;
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
