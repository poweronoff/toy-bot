package de.dj_steam.bot.moving.strategy;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
public class PlaceStrategyTest {

    private PlaceStrategy placeStrategy;
    private ToyBot toyBot;

    @Before
    public void setup() {
        placeStrategy = new PlaceStrategy();
        toyBot = new ToyBot(Direction.NORTH, new Position(0, 0));
    }

    @Test
    public void testPlaceCommandValid() {
        assertTrue(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("1,2,EAST"))));
        assertTrue(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("1 ,2 ,EAST"))));
        assertTrue(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("1 ,2,EAST"))));
        assertTrue(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("1 ,2,   EAST   "))));
    }

    @Test
    public void testPlaceCommandInvalid() {
        assertFalse(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.empty())));
        assertFalse(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("a,2,EAST"))));
        assertFalse(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("1,2,NOTHING"))));
        assertFalse(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("1,2"))));
        assertFalse(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("a"))));
        assertFalse(placeStrategy.isPlaceCommandValid(new Command(Command.PLACE, Optional.of("a,"))));

    }

    @Test
    public void testNotCanBePlaced() {
        assertFalse(placeStrategy.canBePlaced(new ToyBotField(), new Command(Command.PLACE, Optional.of("5,5,EAST"))));
        assertFalse(placeStrategy.canBePlaced(new ToyBotField(), new Command(Command.PLACE, Optional.of("4,5,EAST"))));
        assertFalse(placeStrategy.canBePlaced(new ToyBotField(), new Command(Command.PLACE, Optional.of("5,4,EAST"))));
    }

    @Test
    public void testCanBePlaced() {
        assertTrue(placeStrategy.canBePlaced(new ToyBotField(), new Command(Command.PLACE, Optional.of("0,0,EAST"))));
        assertTrue(placeStrategy.canBePlaced(new ToyBotField(), new Command(Command.PLACE, Optional.of("4,4,EAST"))));
        assertTrue(placeStrategy.canBePlaced(new ToyBotField(), new Command(Command.PLACE, Optional.of("4 ,   4   ,EAST"))));
    }

    @Test
    public void testPlaceStrategyPositiveTest() {
        placeStrategy.change(toyBot, new ToyBotField(), new Command(Command.PLACE, Optional.of("0,2,NORTH")));
        assertEquals(new Position(0, 2), toyBot.getPosition());
    }

    @Test
    public void testPlaceStrategyNegativeTest() {
        placeStrategy.change(toyBot, new ToyBotField(), new Command(Command.PLACE, Optional.of("5,2,NORTH")));
        assertEquals(new Position(0, 0), toyBot.getPosition());
    }

    @Test
    public void testPlaceStrategyDirection() {
        placeStrategy.change(toyBot, new ToyBotField(), new Command(Command.PLACE, Optional.of("0,2,WEST")));
        assertEquals(Direction.WEST, toyBot.getDirection());
    }
}