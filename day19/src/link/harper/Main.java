package link.harper;

import java.io.FileNotFoundException;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Input in = new Input("example-input.txt");


        for (String line: in.getRuleLines()) {
            Rule r = new Rule(line);
            //System.out.println(r);
        }


        for (Integer ruleNum: Rule.getRuleNumbers()) {
            Rule r = Rule.get(ruleNum);
            System.out.println(r);
        }
    }
}
