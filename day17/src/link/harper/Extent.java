package link.harper;

public class Extent {
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;;
    int minZ = Integer.MAX_VALUE;;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    int maxZ = Integer.MIN_VALUE;

    int count = 0;

    public void expand() {
        minX--;
        maxX++;
        minY--;
        maxY++;
        minZ--;
        maxZ++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x:[" + minX + "," + maxX + "] ");
        sb.append("y:[" + minY + "," + maxY + "] ");
        sb.append("z:[" + minZ + "," + maxZ + "] ");
        sb.append("count:" + count);
        return sb.toString();
    }
}
