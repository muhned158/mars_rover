package fr.bnp.rover.services;

import fr.bnp.rover.enums.Step;
import fr.bnp.rover.exceptions.PlateauOutOfBoundsException;
import fr.bnp.rover.models.Plateau;
import fr.bnp.rover.models.Rover;
import fr.bnp.rover.services.instruction.InstructionsFactory;
import fr.bnp.rover.services.instruction.Instruction;

public class RoverService {

    private final PlateauService plateauService = new PlateauService();


    public void moveRover(Rover rover, Step step, Plateau plateau) throws PlateauOutOfBoundsException {
        Instruction instruction = InstructionsFactory.getMovement(step);
        if (instruction != null) {
            instruction.execute(rover);
        }
        if(plateauService.isRoverOutPlateauBounds(plateau, rover)){
            throw new PlateauOutOfBoundsException("Rover out of bounds");
        }
    }
}
