package de.dj_steam.bot.moving;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.engine.RobotEngine;

/**
 * @author steam
 */
public class DirectionCalculatorTest {

    private DirectionCalculator directionCalculator;

    @Before
    public void setup() {
        directionCalculator = new DirectionCalculator();
    }

    @Test
    public void testCalculateOnTurnLeft() {
        ToyBot toyBot = new ToyBot(Direction.NORTH, new Position());
        assertEquals(Direction.WEST, directionCalculator.calculateNewDirection(toyBot, RobotEngine.TURN_LEFT));
    }

    @Test
    public void testCalculateOnTurnRight() {
        ToyBot toyBot = new ToyBot(Direction.NORTH, new Position());
        assertEquals(Direction.EAST, directionCalculator.calculateNewDirection(toyBot, RobotEngine.TURN_RIGHT));
    }

}