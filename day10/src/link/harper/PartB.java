package link.harper;


public class PartB {

    public static void main(String[] args) throws Exception {
        System.out.println("Part B Answer");

        CalculatorB3 calc = new CalculatorB3();
        calc.loadInput("input.txt");

        long numValid = calc.numValidConfigurations();
        System.out.println("Number of valid configurations = " + numValid);
    }


}