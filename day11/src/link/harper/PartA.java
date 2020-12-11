package link.harper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class PartA {

    public static void main(String[] args) throws Exception {
        System.out.println("Part A Answer");
        Input input = new Input();
        input.readAll("example1-input.txt");

        GameState state = new GameState();
        state.initialize(input.getLines());

        System.out.println(state);

    }

    @Test
    public void testGameStateInitialize() {
        Input input = new Input();
        input.readAll("example1-input.txt");

        GameState state = new GameState();
        state.initialize(input.getLines());
        Assertions.assertEquals(
                "L.LL.LL.LL\n" +
                        "LLLLLLL.LL\n" +
                        "L.L.L..L..\n" +
                        "LLLL.LL.LL\n" +
                        "L.LL.LL.LL\n" +
                        "L.LLLLL.LL\n" +
                        "..L.L.....\n" +
                        "LLLLLLLLLL\n" +
                        "L.LLLLLL.L\n" +
                        "L.LLLLL.LL",
                state.toString()
        );
    }


}