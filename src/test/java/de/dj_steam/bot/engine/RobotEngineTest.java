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

    private ToyBotField toyBotField = new ToyBotField();

    @Before
    public void setup() {
        toyBot = new ToyBot(Direction.NORTH, new Position());
        robotEngine = new RobotEngine(toyBotField, toyBot);
    }

    @Test
    public void testTurnLeftCommand() {
        Command turnLeftCommand = new Command(Command.TURN_LEFT, Optional.empty());

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

        Command turnRightCommand = new Command(Command.TURN_RIGHT, Optional.empty());
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
}