package fr.bnp.rover;

import fr.bnp.rover.enums.Direction;
import fr.bnp.rover.enums.Step;
import fr.bnp.rover.exceptions.PlateauOutOfBoundsException;
import fr.bnp.rover.models.Plateau;
import fr.bnp.rover.models.Rover;
import fr.bnp.rover.services.RoverService;
import fr.bnp.rover.services.instruction.Instruction;
import fr.bnp.rover.utils.RoverUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class RoverApplication {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please provide the input file name.");
            return;
        }

        String inputFileName = args[0];

        try {
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);

            String plateauCoordinates = scanner.nextLine();
            int maxX = Integer.parseInt(plateauCoordinates.split(" ")[0]);
            int maxY = Integer.parseInt(plateauCoordinates.split(" ")[1]);

            Plateau plateau = new Plateau(maxX, maxY);
            RoverService roverService = new RoverService();
            while (scanner.hasNextLine()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char directionChar = scanner.next().charAt(0);
                scanner.nextLine();
                Direction direction= (Direction) RoverUtility.findByValue(directionChar);
                Rover rover = new Rover(x, y, direction);
                String instructions = scanner.nextLine();

                for (char instructionChar : instructions.toCharArray()) {
                    Step instruction= (Step) RoverUtility.findByStepValue(instructionChar);

                    try {
                        roverService.moveRover(rover, instruction, plateau);
                    } catch (PlateauOutOfBoundsException ex) {
                        System.out.print(ex.getMessage() + " ");
                        break;
                    }
                }
                System.out.println(rover.getPosition());


            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFileName);
        }
    }
}

