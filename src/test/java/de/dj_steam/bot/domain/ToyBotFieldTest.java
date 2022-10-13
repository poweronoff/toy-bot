package de.dj_steam.bot.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author steam
 */
public class ToyBotFieldTest {
    @Test
    public void isInsideTheField() {
        ToyBotField toyBotField = new ToyBotField();
        assertTrue(toyBotField.isInsideTheField(new Position(0,0)));
        assertTrue(toyBotField.isInsideTheField(new Position(4,4)));

        assertFalse(toyBotField.isInsideTheField(new Position( -1,-1)));
        assertFalse(toyBotField.isInsideTheField(new Position(5,5)));

        assertFalse(toyBotField.isInsideTheField( new Position(-1,4)));
        assertFalse(toyBotField.isInsideTheField( new Position(1,5)));

    }

}