package de.dj_steam.bot.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
        assertEquals(Direction.NORTH, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_LEFT);
        assertEquals(Direction.WEST, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_LEFT);
        assertEquals(Direction.SOUTH, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_LEFT);
        assertEquals(Direction.EAST, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_LEFT);
        assertEquals(Direction.NORTH, toyBot.getDirection());
    }

    @Test
    public void testTurnRightCommand() {
        assertEquals(Direction.NORTH, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_RIGHT);
        assertEquals(Direction.EAST, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_RIGHT);
        assertEquals(Direction.SOUTH, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_RIGHT);
        assertEquals(Direction.WEST, toyBot.getDirection());

        robotEngine.commandBot(RobotEngine.TURN_RIGHT);
        assertEquals(Direction.NORTH, toyBot.getDirection());
    }
}