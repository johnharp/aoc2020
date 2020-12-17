package link.harper;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Universe uni = new Universe();
        Scanner scanner = new Scanner(
                new File("example-input.txt"));

        int z = 0;
        int y = 0;
        while (scanner.hasNextLine()) {
            int x = 0;
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            for(char c: chars) {
                if (c == '#') {
                    uni.set(x, y, z, true);
                }
                x++;
            }
            y--;
        }

        System.out.println("Before any cycles:");
        System.out.println();
        System.out.println(uni);

    }
}
