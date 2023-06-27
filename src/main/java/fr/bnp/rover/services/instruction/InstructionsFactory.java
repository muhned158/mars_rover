package fr.bnp.rover.services.instruction;

import fr.bnp.rover.enums.Step;
import fr.bnp.rover.services.instruction.impl.MoveInstruction;
import fr.bnp.rover.services.instruction.impl.TurnLeftInstruction;
import fr.bnp.rover.services.instruction.impl.TurnRightInstruction;

import java.util.HashMap;
import java.util.Map;

public class InstructionsFactory {

    private static final Map<Step, Instruction> stepInstructionMap = new HashMap<>();


    static {
        stepInstructionMap.put(Step.LEFT, new TurnLeftInstruction());
        stepInstructionMap.put(Step.RIGHT, new TurnRightInstruction());
        stepInstructionMap.put(Step.MOVE, new MoveInstruction());
    }

    public static Instruction getMovement(Step step) {
        return stepInstructionMap.get(step);
    }
}
