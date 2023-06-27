package fr.bnp.rover.utils;

import fr.bnp.rover.enums.Direction;
import fr.bnp.rover.enums.Step;

public class RoverUtility {

    public static Direction findByValue(char value) {
        Direction result = null;
        for (Direction direction : Direction.values()) {
            if (direction.getValue() == value) {
                result = direction;
                break;
            }
        }
        return result;
    }

    public static Step findByStepValue(char value) {
        Step result = null;
        for (Step direction : Step.values()) {
            if (direction.getValue() == value) {
                result = direction;
                break;
            }
        }
        return result;
    }

}
