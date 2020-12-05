package link.harper;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.open("input.txt");

        for(String line = input.line(); line != null; line = input.line()) {
            System.out.println(line);
        }
    }
}
