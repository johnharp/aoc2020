package link.harper;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws Exception {
        Input in = new Input("example-input.txt");


        for (String line: in.getRuleLines()) {
            Rule r = new Rule(line);
            System.out.println(r);
        }
    }
}
