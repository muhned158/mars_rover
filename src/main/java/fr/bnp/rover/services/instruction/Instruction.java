package fr.bnp.rover.services.instruction;

import fr.bnp.rover.models.Rover;

public interface Instruction {
    void execute(Rover rover);
}
