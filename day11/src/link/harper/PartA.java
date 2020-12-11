package link.harper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PartA {

    public static void main(String[] args) throws Exception {
        System.out.println("Part A Answer");
        Input input = new Input();
        input.readAll("input.txt");

        GameState state = new GameState();
        state.initialize(input.getLines());

        state.runUntilStable();
        state.countOccupiedSeats();

    }



    @Test
    public void test0steps() {
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

    @Test
    public void test1steps() {
        Input input = new Input();
        input.readAll("example1-input.txt");

        GameState state = new GameState();
        state.initialize(input.getLines());
        state.nSteps(1);
        Assertions.assertEquals(
                "#.##.##.##\n" +
                        "#######.##\n" +
                        "#.#.#..#..\n" +
                        "####.##.##\n" +
                        "#.##.##.##\n" +
                        "#.#####.##\n" +
                        "..#.#.....\n" +
                        "##########\n" +
                        "#.######.#\n" +
                        "#.#####.##",
                state.toString()
        );
    }

    @Test
    public void test2steps() {
        Input input = new Input();
        input.readAll("example1-input.txt");

        GameState state = new GameState();
        state.initialize(input.getLines());
        state.nSteps(2);
        Assertions.assertEquals(
                "#.LL.L#.##\n" +
                        "#LLLLLL.L#\n" +
                        "L.L.L..L..\n" +
                        "#LLL.LL.L#\n" +
                        "#.LL.LL.LL\n" +
                        "#.LLLL#.##\n" +
                        "..L.L.....\n" +
                        "#LLLLLLLL#\n" +
                        "#.LLLLLL.L\n" +
                        "#.#LLLL.##",
                state.toString()
        );
    }

    @Test
    public void test5steps() {
        Input input = new Input();
        input.readAll("example1-input.txt");

        GameState state = new GameState();
        state.initialize(input.getLines());
        state.nSteps(5);
        Assertions.assertEquals(
                "#.#L.L#.##\n" +
                        "#LLL#LL.L#\n" +
                        "L.#.L..#..\n" +
                        "#L##.##.L#\n" +
                        "#.#L.LL.LL\n" +
                        "#.#L#L#.##\n" +
                        "..L.L.....\n" +
                        "#L#L##L#L#\n" +
                        "#.LLLLLL.L\n" +
                        "#.#L#L#.##",
                state.toString()
        );
    }
}