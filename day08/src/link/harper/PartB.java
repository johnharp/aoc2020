package link.harper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartB {

    public static void main(String[] args) throws Exception {
        System.out.println("Part A Answer");
        Cpu cpu = new Cpu();
        cpu.loadProgram("input.txt");

        while(!cpu.isInfiniteLoopDetected() &&
            !cpu.isProgramTerminated()) {
            cpu.step();
        }

        if (cpu.isInfiniteLoopDetected()) {
            System.out.println("Infinite loop detected.");
        }

        if (cpu.isProgramTerminated()) {
            System.out.println("Program terminated normally.");
        }

        System.out.println("\tprogram counter = " + cpu.getProgramCounter());
        System.out.println("\taccumulator = " + cpu.getAccumulator());

    }


}
