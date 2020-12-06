package link.harper;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.open("input.txt");

        List<String> group = input.group();

        while(group != null) {
          System.out.println(group);

          group = input.group();
        }
    }
}
