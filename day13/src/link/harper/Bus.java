package link.harper;

public class Bus {
    private long busId;
    private long index;

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }



    public Bus(long id, long index) {
        this.busId = id;
        this.index = index;
    }

    public boolean isValidTime(long time) {
        return ((time + index) % busId) == 0;
    }

    @Override
    public String toString() {
        return "Bus " + busId + " at index " + index;
    }



}


