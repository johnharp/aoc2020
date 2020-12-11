package link.harper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Calculator {
    int[] data;
    public int[] getData() {
        return data;
    }

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

    public ArrayList<Integer> getGroupSizes() {
        ArrayList<Integer> groupSizes = new ArrayList<>();

        int numInGroup = 0;

        for(int i = 0; i<data.length-1; i++) {
            if (data[i+1] - data[i] >=3) {
                if (numInGroup > 0) {
                    groupSizes.add(numInGroup);
                }

                numInGroup = 0;
            } else {
                numInGroup++;
            }
        }

        return groupSizes;
    }

    public int numPossibilitiesInGroupSized(int size) throws Exception{
        switch(size) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 13;
            default:
                throw new Exception("Error -- ");
        }
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
