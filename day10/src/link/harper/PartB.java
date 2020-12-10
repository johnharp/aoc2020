package link.harper;


public class PartB {

    public static void main(String[] args) throws Exception {
        System.out.println("Part B Answer");

        CalculatorB2 calc = new CalculatorB2();
        calc.loadInput("input.txt");

        for(int num : calc.getData()) {
            System.out.println(num);
        }
        System.out.println("Total count = " + calc.getData().length);

        long numValidConfigurations = calc.numValidConfigurations();
        System.out.println("Total valid configs = " + numValidConfigurations);
    }


}