package de.dj_steam.bot.moving;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;

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
        assertEquals(Direction.WEST, directionCalculator.calculateNewDirection(toyBot, new Command(Command.TURN_LEFT, Optional.empty())));
    }

    @Test
    public void testCalculateOnTurnRight() {
        ToyBot toyBot = new ToyBot(Direction.NORTH, new Position());
        assertEquals(Direction.EAST, directionCalculator.calculateNewDirection(toyBot, new Command( Command.TURN_RIGHT, Optional.empty())));
    }

}