package link.harper;

import java.util.List;

public class PartA {

    public static void main(String[] args) {
        System.out.println("Part A Answer");

        Input input = new Input();
        input.open("input.txt");

        Calculator calc = new Calculator();

        List<String> group = input.group();
        while(group != null) {
            System.out.println(group);
            group = input.group();
        }
    }
}
