package fr.bnp.rover.services.instruction.impl;

import fr.bnp.rover.enums.Direction;
import fr.bnp.rover.models.Rover;
import fr.bnp.rover.services.instruction.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MoveInstruction implements Instruction {
    private static final  Map<Direction, Consumer<Rover>> move = new HashMap<Direction,Consumer<Rover>>();
    static {
        move.put(Direction.NORTH, Rover::incrementY);
        move.put(Direction.EAST, Rover::incrementX);
        move.put(Direction.WEST, Rover::decrementY);
        move.put(Direction.SOUTH, Rover::decrementX);
    }
    public void execute(Rover rover) {
        Direction direction= rover.getDirection();

        Consumer<Rover> moveOperation = move.get(direction);
        if (moveOperation != null) {
            moveOperation.accept(rover);
        }


    }


}
