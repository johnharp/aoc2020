package link.harper;

public class Calculator {
    public int SeatId(String spec) {
        int row = SeatRow(spec);
        int col = SeatColumn(spec);

        int id = (row * 8) + col;
        return id;
    }

    public int SeatRow(String spec) {
        return 0;
    }

    public int SeatColumn(String spec) {
        return 0;
    }
}
