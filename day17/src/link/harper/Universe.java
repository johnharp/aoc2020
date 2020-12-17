package link.harper;

import java.util.Collections;
import java.util.Hashtable;

public class Universe {
    private Hashtable<Integer, Hashtable<Integer, Hashtable<Integer, Boolean>>> cubes =
            new Hashtable<>();

    public Boolean get(int x, int y, int z) {

        if (cubes.containsKey(x)) {
            Hashtable<Integer, Hashtable<Integer, Boolean>> xSlice;
            xSlice = cubes.get(x);

            if (xSlice.containsKey(y)) {
                Hashtable<Integer, Boolean> ySlice;
                ySlice = xSlice.get(y);

                if (ySlice.containsKey(z)) {
                    return ySlice.get(z);
                }
            }
        }

        return false;
    }

    public void set(int x, int y, int z, Boolean value) {
        Hashtable<Integer, Hashtable<Integer, Boolean>> xSlice;
        Hashtable<Integer, Boolean> ySlice;

        if (cubes.containsKey(x)) {
            xSlice = cubes.get(x);
        } else {
            xSlice = new Hashtable<>();
            cubes.put(x, xSlice);
        }

        if (xSlice.containsKey(y)) {
            ySlice = xSlice.get(y);
        } else {
            ySlice = new Hashtable<>();
            xSlice.put(y, ySlice);
        }

        ySlice.put(z, value);

        // don't allow contraction
//        if (value == false) {
//            ySlice.remove(z);
//        } else {
//            ySlice.put(z, true);
//        }
    }

    public Extent measureExtent() {
        Extent ext = new Extent();
        ext.minX = Collections.min(cubes.keySet());
        ext.maxX = Collections.max(cubes.keySet());

        for (int x = ext.minX; x <= ext.maxX; x++) {
            if (!cubes.containsKey(x)) continue;

            Hashtable<Integer, Hashtable<Integer, Boolean>> xSlice;
            xSlice = cubes.get(x);
            int minYInSlice = Collections.min(xSlice.keySet());
            int maxYInSlice = Collections.max(xSlice.keySet());

            if (minYInSlice < ext.minY) ext.minY = minYInSlice;
            if (maxYInSlice > ext.maxY) ext.maxY = maxYInSlice;

            for (int y = ext.minY; y <= ext.maxY; y++) {
                if (!xSlice.containsKey(y)) continue;

                Hashtable<Integer, Boolean> ySlice;
                ySlice = xSlice.get(y);

                int minZInSlice = Collections.min(ySlice.keySet());
                int maxZInSlice = Collections.max(ySlice.keySet());

                if (minZInSlice < ext.minZ) ext.minZ = minZInSlice;
                if (maxZInSlice > ext.maxY) ext.maxZ = maxZInSlice;

                for (int z = ext.minZ; z <= ext.maxZ; z++) {
                    if (ySlice.containsKey(z)) ext.count++;
                }
            }

        }

        return ext;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Extent ext = measureExtent();

        for (int z = ext.minZ; z<= ext.maxZ; z++) {
            sb.append("z=" + z);
            sb.append(System.lineSeparator());
            for (int y = ext.maxY; y >= ext.minY; y--) {
                for (int x = ext.minX; x <= ext.maxX; x++) {
                    if (get(x, y, z)) {
                        sb.append('#');
                    } else {
                        sb.append('.');
                    }
                }
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
