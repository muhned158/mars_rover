package fr.bnp.rover.services.instruction.impl;

import fr.bnp.rover.enums.Direction;
import fr.bnp.rover.models.Rover;
import fr.bnp.rover.services.instruction.Instruction;

import java.util.HashMap;
import java.util.Map;

public class TurnRightInstruction implements Instruction {
    private final static Map<Direction, Direction> turnRight = new HashMap<Direction, Direction>();

    static {
        turnRight.put(Direction.NORTH,Direction.EAST);
        turnRight.put(Direction.EAST,Direction.SOUTH);
        turnRight.put(Direction.SOUTH,Direction.WEST);
        turnRight.put(Direction.WEST,Direction.NORTH);
}
    public void execute(Rover rover) {
        Direction direction= rover.getDirection();
        rover.setDirection(turnRight.get(direction));
    }
}
