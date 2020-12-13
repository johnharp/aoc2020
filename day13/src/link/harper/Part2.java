package link.harper;

public class Part2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Part B Answer");

        Calculator2 calc = new Calculator2();
        //calc.loadInput("example6-input.txt");
        calc.loadInput("input.txt");


        long t = 1;
        for(Bus bus: calc.getBuses()) {
            t *= bus.getBusId();
            System.out.println(bus);
        }

        System.out.println(t);

//        long t = calc.getFirstTimeToTry();
//        while (!calc.allBusesValidAtTime(t)) {
//            System.out.println(t);
//            t += calc.getLargestBusId();
//        }
//        System.out.println("Solution: " + t);
        //100000000000000
        //105771058159
    }
}
