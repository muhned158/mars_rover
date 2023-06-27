package fr.bnp.rover.services.instruction.impl;

import fr.bnp.rover.enums.Direction;
import fr.bnp.rover.models.Rover;
import fr.bnp.rover.services.instruction.Instruction;

import java.util.HashMap;
import java.util.Map;

public class TurnLeftInstruction implements Instruction {

    private final static Map<Direction, Direction> turnLeft = new HashMap<Direction, Direction>();

    static {
        turnLeft.put(Direction.NORTH, Direction.WEST);
        turnLeft.put(Direction.WEST, Direction.SOUTH);
        turnLeft.put(Direction.SOUTH, Direction.EAST);
        turnLeft.put(Direction.EAST, Direction.NORTH);
    }

    public void execute(Rover rover) {
        Direction direction= rover.getDirection();
        rover.setDirection(turnLeft.get(direction));
    }
}
