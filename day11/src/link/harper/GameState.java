package link.harper;

import java.util.List;

public class GameState {
    int numCols;
    int numRows;

    int[][] chairs;
    int[][] currentState;
    int[][] nextState;


    public void initialize(List<String> lines) {
        String firstLine = lines.get(0);
        numCols = firstLine.length();
        numRows = lines.size();

        // Give the board a margin of one space all the way around
        // This top, bottom, left, right margin will never have seats
        // or occupants and will never be calculated, but will allow
        // us to not bound check when calculating the inner spaces
        chairs = new int[numCols+2][numRows+2];
        currentState = new int[numCols+2][numRows+2];
        nextState = new int[numCols+2][numRows+2];

        int row = 1;
        for(String line: lines) {
            int col=1;
            char[] chars = line.toCharArray();
            for(char c: chars) {
                if (c == 'L') {
                    chairs[row][col] = 1;
                }
                col++;
            }

            row++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Remember the margin is:
        // row = 0, row = numRows+1
        // col = 0, col = numCols+1
        for (int row = 1; row <= numRows; row++ ) {

            for (int col = 1; col <= numCols; col++) {
                char c;

                if (currentState[row][col] == 1) {
                    c = '#';
                } else if (chairs[row][col] == 1) {
                    c = 'L';
                } else {
                    c = '.';
                }

                sb.append(c);
            }

            // Don't append a trailing newline on the end of the
            // last row
            if (row < numRows) sb.append(System.lineSeparator());
        }

        return sb.toString();
    }


    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int[][] getChairs() {
        return chairs;
    }

    public void setChairs(int[][] chairs) {
        this.chairs = chairs;
    }

    public int[][] getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int[][] currentState) {
        this.currentState = currentState;
    }

    public int[][] getNextState() {
        return nextState;
    }

    public void setNextState(int[][] nextState) {
        this.nextState = nextState;
    }
}
