package link.harper;


public class PartB {

    public static void main(String[] args) throws Exception {
        System.out.println("Part B Answer");

        CalculatorB calc = new CalculatorB();
        calc.loadInput("input.txt");
        System.out.println("Loaded: " + calc.getAllAdaptors());

        long numValid = calc.calcNumValidChains();
        System.out.println("Valid num chains: " + numValid);
    }


}