package link.harper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws Exception {
        Input in = new Input();
        in.load("puzzle");

        ArrayList<Ticket> validTickets = Ticket.getValidTickets();
        int numFields = in.getMyTicket().fieldValues.length;
        int numTickets = Ticket.getAllTickets().size();

        for (int ticketNum = 0; ticketNum < numTickets; ticketNum++) {
            for (int position = 0; position < numFields; position++) {
                int value = Ticket.getValueTicketField(ticketNum, position);


                ArrayList<Integer> valid = FieldRule.getFieldsValidFor(value);
                ArrayList<Integer> notValid = FieldRule.getFieldsNotValidFor(value);

                if (notValid.size() > 0) {
                    System.out.println("Ticket " + ticketNum + " has value " + value + " in field position " + position +
                            " so it can't be these fields: " + notValid);
                }
            }
        }
    }
}
