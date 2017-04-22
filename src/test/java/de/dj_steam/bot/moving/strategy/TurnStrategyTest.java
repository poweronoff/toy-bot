package de.dj_steam.bot.moving.strategy;

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
        turnStrategy.change(toyBot, new ToyBotField(), new Command(Command.TURN_LEFT, Optional.empty()));
        assertEquals(Direction.WEST, toyBot.getDirection());
    }

    @Test
    public void testTurnRight() {
        assertEquals(Direction.NORTH, toyBot.getDirection());
        turnStrategy.change(toyBot, new ToyBotField(), new Command(Command.TURN_RIGHT, Optional.empty()));
        assertEquals(Direction.EAST, toyBot.getDirection());
    }

}