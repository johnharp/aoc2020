package link.harper;


public class PartB {

    public static void main(String[] args) throws Exception {
        System.out.println("Part B Answer");

        CalculatorB calc = new CalculatorB();
        calc.loadInput("example-input1.txt");
        System.out.println("Loaded: " + calc.getAllAdaptors());

    }


}