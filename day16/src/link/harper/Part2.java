package link.harper;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws Exception {
        Input in = new Input();
        in.load("puzzle");

        ArrayList<Ticket> validTickets = Ticket.getValidTickets();
        int numFields = in.getMyTicket().fieldValues.length;
        int numTickets = Ticket.getAllTickets().size();

        FieldRule.printAll();

        // outer list is the field position
        // inner list is the list of possible field that could be that position
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();

        for (int fieldPosition = 0; fieldPosition < numFields; fieldPosition++) {
            ArrayList<Integer> possibles = new ArrayList<>();
            solution.add(possibles);

            for (int i = 0; i<numFields; i++) {
                possibles.add(i);
            }

            for (int ticketNum = 0; ticketNum < numTickets; ticketNum++) {
                int val = Ticket.getValueTicketField(0, 0);
                ArrayList<Integer> invalid = FieldRule.getFieldsNotValidFor(val);
                System.out.println("invalid: " + invalid);
                for (int num: invalid) {
                    if (possibles.contains(num)) {
                        possibles.remove(num);
                    }
                }
            }
        }


        System.out.println(solution);
    }
}
