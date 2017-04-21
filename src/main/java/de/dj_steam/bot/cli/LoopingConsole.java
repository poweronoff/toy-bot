package de.dj_steam.bot.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.dj_steam.bot.engine.RobotEngine;

/**
 * @author steam
 */

public class LoopingConsole {

    private static final String EXIT_COMMAND = "exit";

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printUsageBanner();

        RobotEngine robotEngine = new RobotEngine();

        while (true) {
            System.out.print("> ");
            String input = br.readLine();
            robotEngine.commandBot(input);

            if (input.trim().toLowerCase().equals(EXIT_COMMAND)) {
                System.out.println("exiting");
                return;
            }
        }
    }

    private static void printUsageBanner() {
        System.out.println("####################################################");
        System.out.println("Commands:");
        System.out.println("PLACE X,Y,F - place robot on position X,Y - coordinates, and direction (NORTH|SOUTH|WEST|EAST)");
        System.out.println("MOVE - change the robot to the next field in facing direction");
        System.out.println("LEFT - turn the robot to the left");
        System.out.println("RIGHT - turn the robot to the right");
        System.out.println("REPORT - show robots position and facing direction");
        System.out.println("exit - exit the application");
        System.out.println("####################################################");
        System.out.println("Enter a command  or '" + EXIT_COMMAND + "' to quit");
    }
}
