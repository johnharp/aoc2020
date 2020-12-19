package link.harper;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Input in = new Input("input.txt");

        System.out.println("----");
        System.out.println(in.getRules());
        System.out.println("----");
        System.out.println(in.getMessages());
        System.out.println("----");

    }
}
