package link.harper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Calculator {
    int[] data;

    Hashtable<Integer, Integer> differences = new Hashtable<>();

    public void loadInput(String filename) {
        List<Integer> dataList = new ArrayList<>();

        Input input = new Input();
        input.open(filename);

        String line = input.line();

        while(line != null) {
            int inputNum = Integer.parseInt(line);
            dataList.add(inputNum);

            line = input.line();
        }

        // seat adapter
        dataList.add(0);
        Collections.sort(dataList);

        int max = dataList.get(dataList.size()-1);

        // built-in adaptor
        dataList.add(max + 3);

        data = dataList.stream().mapToInt(i -> i).toArray();
    }

    public Hashtable<Integer, Integer> summarizeDifferences() {
        for (int i = 1; i<data.length; i++) {
            int diff = data[i] - data[i-1];

            if (!differences.containsKey(diff)) {
                differences.put(diff, 0);
            }

            differences.put(diff, differences.get(diff) + 1);
        }

        return differences;
    }
}
