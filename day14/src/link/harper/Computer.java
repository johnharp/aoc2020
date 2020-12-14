package link.harper;

import java.util.Hashtable;

public class Computer {
    private Hashtable<Long, Long> memory = new Hashtable<>();

    public long read(long address) {
        if (memory.containsKey(address)) {
            return memory.get(address);
        } else {
            return 0;
        }
    }

    public void write(long address, long value) {
        memory.put(address, value);
    }

    public void coredump() {
        for(long key: memory.keySet()) {
            System.out.println("mem[" +
                    key + "]: " +
                    memory.get(key));
        }
    }
}
