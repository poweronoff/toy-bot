package de.dj_steam.bot.moving.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;
import de.dj_steam.bot.engine.RobotEngine;

/**
 * @author stanislav.nowogrudski
 */
public class TurnStrategyTest {

    private TurnStrategy turnStrategy;
    private ToyBot toyBot;

    @Before
    public void setup() {
        turnStrategy = new TurnStrategy();
        toyBot = new ToyBot(Direction.NORTH, new Position());
    }

    @Test
    public void testTurnLeft() {
        assertEquals(Direction.NORTH, toyBot.getDirection());
        turnStrategy.change(toyBot, new ToyBotField(), RobotEngine.TURN_LEFT);
        assertEquals(Direction.WEST, toyBot.getDirection());
    }

    @Test
    public void testTurnRight() {
        assertEquals(Direction.NORTH, toyBot.getDirection());
        turnStrategy.change(toyBot, new ToyBotField(), RobotEngine.TURN_RIGHT);
        assertEquals(Direction.EAST, toyBot.getDirection());
    }

}