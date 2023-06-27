package fr.bnp.rover.services;

import fr.bnp.rover.enums.Direction;
import fr.bnp.rover.enums.Step;
import fr.bnp.rover.exceptions.PlateauOutOfBoundsException;
import fr.bnp.rover.models.Plateau;
import fr.bnp.rover.models.Rover;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoverServiceTest {


    private final RoverService roverService = new RoverService();
    private final Plateau plateau = new Plateau(5, 5);


    @Test
    public void testInitialPosition() {
        Rover rover = new Rover(0, 0, Direction.EAST);
        assertEquals("0 0 E", rover.getPosition());
    }

    @Test
    public void testSingleMovement() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, Direction.EAST);
        roverService.moveRover(rover, Step.MOVE, plateau);
        assertEquals("1 0 E", rover.getPosition());
    }


    @Test
    public void testTurningLeft() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, Direction.EAST);

        roverService.moveRover(rover, Step.LEFT, plateau);
        assertEquals("0 0 N", rover.getPosition());
    }

    @Test
    public void testTurningRight() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, Direction.EAST);

        roverService.moveRover(rover, Step.RIGHT, plateau);
        assertEquals("0 0 S", rover.getPosition());
    }


    @Test
    public void testMultipleMovements() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, Direction.EAST);

        roverService.moveRover(rover, Step.MOVE, plateau);

        roverService.moveRover(rover, Step.RIGHT, plateau);

        roverService.moveRover(rover, Step.MOVE, plateau);

        assertEquals("0 0 S", rover.getPosition());
    }

    @Test
    public void testDifferentStartingPosition() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(2, 2, Direction.SOUTH);

        roverService.moveRover(rover, Step.LEFT, plateau);

        assertEquals("2 2 E", rover.getPosition());

        roverService.moveRover(rover, Step.RIGHT, plateau);
        assertEquals("2 2 S", rover.getPosition());

        roverService.moveRover(rover, Step.MOVE, plateau);
        roverService.moveRover(rover, Step.MOVE, plateau);
        roverService.moveRover(rover, Step.RIGHT, plateau);
        roverService.moveRover(rover, Step.MOVE, plateau);
        assertEquals("0 1 W", rover.getPosition());

    }

    @Test
    public void testExceptionWhenOutOfPlateauBounds() throws PlateauOutOfBoundsException {
        Plateau plateau = new Plateau(2, 2);
        Rover rover = new Rover(1, 1, Direction.NORTH);

        roverService.moveRover(rover, Step.MOVE, plateau);
        assertThatThrownBy(() -> roverService.moveRover(rover, Step.MOVE, plateau))
                .isInstanceOf(PlateauOutOfBoundsException.class);

    }
}