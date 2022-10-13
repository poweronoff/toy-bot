package de.dj_steam.bot.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.engine.RobotEngine;

/**
 * @author steam
 */

public class LoopingConsole {

    private static final String EXIT_COMMAND = "exit";
    private static final String COMMAND_DELIMITER = " ";

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printUsageBanner();

        RobotEngine robotEngine = new RobotEngine();

        while (true) {
            System.out.print("> ");
            String input = br.readLine();
            try {
                robotEngine.commandBot(createCommand(input));
            }catch (InvalidUserInputException e) {
                System.out.println("\nInput error occurred! Message: " + e.getMessage() +"\n");
                printUsageBanner();
            }

            if (input.trim().equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("exiting");
                return;
            }
        }
    }

    static Command createCommand(final String input) {
        String[] split = input.split(COMMAND_DELIMITER);

        Command command;

        if(split.length == 2) {
            command = new Command(split[0], Optional.of(split[1]));
        } else if(split.length == 1 && !StringUtils.isEmpty(split[0])){
            command = new Command(split[0], Optional.empty());
        } else {
            throw  new InvalidUserInputException("Invalid user input");
        }

        return command;
    }

    private static void printUsageBanner() {
        System.out.println("####################################################");
        System.out.println("Commands:");
        System.out.println("PLACE X,Y,F - place robot on position X,Y - coordinates, and direction (NORTH|SOUTH|WEST|EAST)");
        System.out.println("MOVE - move the robot to the next field in facing direction");
        System.out.println("LEFT - turn the robot to the left");
        System.out.println("RIGHT - turn the robot to the right");
        System.out.println("REPORT - show robots position and facing direction");
        System.out.println("exit - exit the application");
        System.out.println("####################################################");
        System.out.println("Enter a command  or '" + EXIT_COMMAND + "' to quit");
    }
}
