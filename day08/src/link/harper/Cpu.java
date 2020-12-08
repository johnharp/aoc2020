package link.harper;

import java.util.ArrayList;
import java.util.List;

public class Cpu {
    private List<Instruction> program = new ArrayList<>();
    private int accumulator = 0;
    private int programCounter = 0;

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public void loadProgram(String filename) {
        Input input = new Input();
        input.open(filename);

        String line = input.line();
        while(line != null) {
            loadInstruction(line);

            line=input.line();
        }
    }

    public void loadInstruction(String line) {
        String[] parts = line.split(" ");
        String operation = parts[0];
        int argument = Integer.parseInt(parts[1]);

        Instruction instruction = new Instruction();
        instruction.setOperation(operation);
        instruction.setArgument(argument);

        program.add(instruction);
    }

    public Instruction getInstructionAt(int lineNum) {
        return program.get(lineNum);
    }

    public boolean isInfiniteLoopDetected() {
        return getInstructionAt(programCounter)
                .getHasBeenVisited();
    }

    public boolean isProgramTerminated() {
        return programCounter >= program.size();
    }

    public boolean toggleInstructionAt(int index) {
        boolean changedInstruction = false;
        Instruction instruction = getInstructionAt(index);
        String operation = instruction.getOperation();

        if (operation.equals("nop")) {
            instruction.setOperation("jmp");
            changedInstruction = true;
        } else if (operation.equals("jmp")) {
            instruction.setOperation("nop");
            changedInstruction = true;
        }

        return changedInstruction;
    }

    public void step() throws Exception{
        Instruction instruction = getInstructionAt(programCounter);
        instruction.setHasBeenVisited(true);
        switch(instruction.getOperation()) {
            case "nop":
                programCounter++;
                break;
            case "acc":
                programCounter++;
                accumulator += instruction.getArgument();
                break;
            case "jmp":
                programCounter += instruction.getArgument();
                break;
            default:
                throw new Exception("Unknown operation " + instruction.getOperation());
        }
    }
}
