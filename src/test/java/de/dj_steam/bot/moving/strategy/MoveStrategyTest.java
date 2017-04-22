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
public class MoveStrategyTest {

    private ToyBotField toyBotField;
    private MoveStrategy moveStrategy;
    private Command moveCommand;



    @Before
    public void setup() {
        toyBotField = new ToyBotField();
        moveStrategy = new MoveStrategy();
        moveCommand = new Command(Command.MOVE, Optional.empty());
    }

    @Test
    public void testMoveToNorthAllowed() {
        Position startPosition = new Position(0,0);
        ToyBot toyBot = new ToyBot(Direction.NORTH, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(new Position(0,1), toyBot.getPosition());
    }

    @Test
    public void testMoveToWestAllowed() {
        Position startPosition = new Position(1,0);
        ToyBot toyBot = new ToyBot(Direction.WEST, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(new Position(0,0), toyBot.getPosition());
    }

    @Test
    public void testMoveToEastAllowed() {
        Position startPosition = new Position(0,0);
        ToyBot toyBot = new ToyBot(Direction.EAST, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(new Position(1,0), toyBot.getPosition());
    }

    @Test
    public void testMoveToSouthAllowed() {
        Position startPosition = new Position(0,1);
        ToyBot toyBot = new ToyBot(Direction.EAST, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(new Position(1,1), toyBot.getPosition());
    }

    @Test
    public void testMoveToEastDisallowed() {
        Position startPosition = new Position(4,1);
        ToyBot toyBot = new ToyBot(Direction.EAST, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(startPosition, toyBot.getPosition());
    }

    @Test
    public void testMoveToSouthDisallowed() {
        Position startPosition = new Position(3,0);
        ToyBot toyBot = new ToyBot(Direction.SOUTH, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(startPosition, toyBot.getPosition());
    }

    @Test
    public void testMoveToWestDisallowed() {
        Position startPosition = new Position(0,1);
        ToyBot toyBot = new ToyBot(Direction.WEST, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(startPosition, toyBot.getPosition());
    }

    @Test
    public void testMoveToNorthDisallowed() {
        Position startPosition = new Position(0,4);
        ToyBot toyBot = new ToyBot(Direction.WEST, startPosition);
        assertEquals(startPosition, toyBot.getPosition());
        moveStrategy.change(toyBot, toyBotField, moveCommand);
        assertEquals(startPosition, toyBot.getPosition());
    }

}