package link.harper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private ArrayList<String> rules;
    private ArrayList<String> messages;

    public ArrayList<String> getRules() {
        return rules;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public Input(String filename) throws FileNotFoundException {
        rules = new ArrayList<>();
        messages = new ArrayList<>();

        Scanner scanner = new Scanner(
                new File(filename));

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            rules.add(line);
        }

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            messages.add(line);
        }
    }
}
