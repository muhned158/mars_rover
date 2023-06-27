package fr.bnp.rover.services;

import fr.bnp.rover.models.Plateau;
import fr.bnp.rover.models.Rover;

public class PlateauService {

    /**
     * test if the coordinates x,y is in  the plateau
     */
    public boolean isValidPosition(Plateau plateau, Rover rover) {
        return rover.getX() >= 0 && rover.getX() <= plateau.getX() &&
                rover.getY() >= 0 && rover.getY() <= plateau.getY();
    }


    public boolean isRoverOutPlateauBounds(Plateau plateau, Rover rover){
        return !isValidPosition(plateau, rover);
    }
}
