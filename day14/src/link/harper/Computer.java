package link.harper;

import java.util.Hashtable;

public class Computer {
    public Hashtable<Long, Long> getMemory() {
        return memory;
    }

    private Hashtable<Long, Long> memory = new Hashtable<>();
    private static long thirtySixOnesMask = 68719476735L;
    public static long maxNumber = thirtySixOnesMask;


    public long read(long address) throws Exception{
        if (address > thirtySixOnesMask) throw new Exception("address overflow: " + address);
        if (memory.containsKey(address)) {
            return memory.get(address);
        } else {
            return 0;
        }
    }

    public void write(long address, long value) throws Exception {
        if (address > thirtySixOnesMask) throw new Exception("address overflow: " + address);
        if (value > thirtySixOnesMask) throw new Exception("value overflow: " + value);

        if (memory.keySet().contains(address)) {
            System.out.println(
                    "Overwriting address " + address + " old " + read(address)
                            + " new " + value);
        }
        memory.put(address, value);
    }

    public void coredump() {
        for(long key: memory.keySet()) {
            System.out.println("mem[" +
                    key + "]: " +
                    memory.get(key));
        }
    }

    public long sumAllMemory() {
        long sum = 0;

        for(long key: memory.keySet()) {
            long v = memory.get(key);
            //v = v & thirtySixOnesMask;

            sum += v;

            //sum = sum & thirtySixOnesMask;
        }

        return sum;
    }
}
