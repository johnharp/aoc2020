package link.harper;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.open("input.txt");

        Calculator calc = new Calculator();
        int maxSeatId = 0;

        for(String line = input.line(); line != null; line = input.line()) {
            int seatId = calc.SeatId(line);
            if (seatId > maxSeatId) {
                maxSeatId = seatId;
            }
        }

        System.out.println("Max seat ID = " + maxSeatId);
    }
}
