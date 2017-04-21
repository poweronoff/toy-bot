package de.dj_steam.bot.moving;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import de.dj_steam.bot.domain.Direction;

/**
 * @author steam
 */
public class LoopedDirectionsArrayListTest {
    private LoopedDirectionsArrayList directions;

    @Before
    public void setup() {
        directions = new LoopedDirectionsArrayList();
        directions.addAll(Arrays.asList(Direction.values()));
    }

    @Test
    public void testLoopedArrayInitialisation() {
        assertEquals(Direction.NORTH, directions.get(0));
        assertEquals(Direction.EAST, directions.get(1));
        assertEquals(Direction.SOUTH, directions.get(2));
        assertEquals(Direction.WEST, directions.get(3));
    }

    @Test
    public void testBorderOverlapping() {
        assertEquals(Direction.NORTH, directions.get(4));
        assertEquals(Direction.EAST, directions.get(5));
        assertEquals(Direction.SOUTH, directions.get(6));
        assertEquals(Direction.WEST, directions.get(7));

        assertEquals(Direction.WEST, directions.get(-1));
        assertEquals(Direction.SOUTH, directions.get(-2));
        assertEquals(Direction.EAST, directions.get(-3));
        assertEquals(Direction.NORTH, directions.get(-4));
    }

}