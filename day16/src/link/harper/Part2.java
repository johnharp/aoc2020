package link.harper;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws Exception {
        Input in = new Input();
        in.load("example2");

        ArrayList<Ticket> validTickets = Ticket.getValidTickets();
        int numFields = in.getMyTicket().fieldValues.length;
        

    }
}
