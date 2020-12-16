package link.harper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws Exception {
        //Input in = new Input("example1-input.txt");
        Input in = new Input();
        in.load("example");

        for(Integer n: new ArrayList<Integer>(Arrays.asList( 7, 1, 14, 4))) {
            System.out.println("value " + n + ": " + Rule.getRulesValidFor(n));
        }
    }
}
