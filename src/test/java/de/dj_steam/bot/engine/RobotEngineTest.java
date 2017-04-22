package de.dj_steam.bot.engine;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;

/**
 * @author steam
 */
public class RobotEngineTest {

    private RobotEngine robotEngine;
    private ToyBot toyBot;

    private Command turnLeftCommand;
    private Command turnRightCommand;
    private Command moveCommand;
    private Command placeCommand;

    private ToyBotField toyBotField = new ToyBotField();

    @Before
    public void setup() {
        toyBot = new ToyBot(Direction.NORTH, new Position());
        robotEngine = new RobotEngine(toyBotField, toyBot);
        turnLeftCommand = new Command(Command.TURN_LEFT, Optional.empty());
        turnRightCommand = new Command(Command.TURN_RIGHT, Optional.empty());
        moveCommand = new Command(Command.MOVE, Optional.empty());
        placeCommand = new Command(Command.PLACE, Optional.empty());

    }

    @Test
    public void testTurnLeftCommand() {
        assertEquals(Direction.NORTH, toyBot.getDirection());

        robotEngine.commandBot(turnLeftCommand);
        assertEquals(Direction.WEST, toyBot.getDirection());

        robotEngine.commandBot(turnLeftCommand);
        assertEquals(Direction.SOUTH, toyBot.getDirection());

        robotEngine.commandBot(turnLeftCommand);
        assertEquals(Direction.EAST, toyBot.getDirection());

        robotEngine.commandBot(turnLeftCommand);
        assertEquals(Direction.NORTH, toyBot.getDirection());
    }

    @Test
    public void testTurnRightCommand() {
        assertEquals(Direction.NORTH, toyBot.getDirection());

        robotEngine.commandBot(turnRightCommand);
        assertEquals(Direction.EAST, toyBot.getDirection());

        robotEngine.commandBot(turnRightCommand);
        assertEquals(Direction.SOUTH, toyBot.getDirection());

        robotEngine.commandBot(turnRightCommand);
        assertEquals(Direction.WEST, toyBot.getDirection());

        robotEngine.commandBot(turnRightCommand);
        assertEquals(Direction.NORTH, toyBot.getDirection());
    }

    @Test
    public void testPlaceCommand() {
        assertEquals(new Position(0, 0), toyBot.getPosition());

        robotEngine.commandBot(placeCommand);
        assertEquals(new Position(0, 0), toyBot.getPosition());

        placeCommand = new Command(Command.PLACE, Optional.of("0,2,NORTH"));
        robotEngine.commandBot(placeCommand);
        assertEquals(new Position(0, 2), toyBot.getPosition());

        placeCommand = new Command(Command.PLACE, Optional.of("5,1,NORTH"));
        robotEngine.commandBot(placeCommand);
        assertEquals(new Position(0, 2), toyBot.getPosition());

        placeCommand = new Command(Command.PLACE, Optional.of("0,3,WEST"));
        robotEngine.commandBot(placeCommand);
        assertEquals(new Position(0, 3), toyBot.getPosition());
        assertEquals(Direction.WEST, toyBot.getDirection());
    }

    @Test
    public void testMoveCommand() {
        assertEquals(new Position(0, 0), toyBot.getPosition());
        assertEquals(Direction.NORTH, toyBot.getDirection());

        for (int i = 1; i <= 4; i++) {
            robotEngine.commandBot(moveCommand);
            assertEquals(new Position(0, i), toyBot.getPosition());
        }

        robotEngine.commandBot(moveCommand);
        assertEquals(new Position(0, 4), toyBot.getPosition());
    }

    @Test
    public void testRunningRobotUiiiiii() {
        assertEquals(new Position(0, 0), toyBot.getPosition());
        assertEquals(Direction.NORTH, toyBot.getDirection());

        robotEngine.commandBot(moveCommand);
        assertEquals(new Position(0, 1), toyBot.getPosition());
        assertEquals(Direction.NORTH, toyBot.getDirection());

        robotEngine.commandBot(turnRightCommand);
        assertEquals(Direction.EAST, toyBot.getDirection());

        for (int i = 0; i <= 3; i++) {
            robotEngine.commandBot(moveCommand);
        }

        assertEquals(new Position(4, 1), toyBot.getPosition());

        robotEngine.commandBot(moveCommand); // border
        assertEquals(new Position(4, 1), toyBot.getPosition());

        robotEngine.commandBot(turnLeftCommand);
        for (int i = 0; i <= 3; i++) {
            robotEngine.commandBot(moveCommand);
        }

        assertEquals(new Position(4, 4), toyBot.getPosition());
    }
}