package link.harper;

import java.util.ArrayList;
import java.util.List;

public class Calculator2 {
    private List<Bus> buses = new ArrayList<>();
    private long largestBusId;


    public List<Bus> getBuses() {
        return buses;
    }

    public long getLargestBusId() {
        return largestBusId;
    }

    public long getFirstTimeToTry() {
        Bus largestBus =
                buses.get(0);

        return largestBus.getBusId() - largestBus.getIndex();
    }

    public boolean allBusesValidAtTime(long t) {
        for (Bus bus: buses) {
            if (!bus.isValidTime(t)) return false;
        }

        return true;
    }
    

    public void loadInput(String filename) {
        Input input = new Input();
        input.readAll(filename);

        // Discard first line
        String busIdsStr = input.getLines().get(1);

        // Second line is the bus info
        String[] components = busIdsStr.split(",");
        long index = 0;
        for(String component: components) {
            if (!component.equals("x")) {
                long busId = Long.parseLong(component);
                buses.add(new Bus(busId, index));
            }
            index++;
        }

        buses.sort(new BusIdComparator().reversed());
        largestBusId = buses.get(0).getBusId();
    }
}
