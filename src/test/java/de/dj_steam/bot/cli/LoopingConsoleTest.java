package de.dj_steam.bot.cli;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dj_steam.bot.domain.Command;

/**
 * @author steam
 */
public class LoopingConsoleTest {


    @Test(expected = InvalidUserInputException.class)
    public void createCommandExpectedUserInputExceptionOnEmptyInput() {
        LoopingConsole.createCommand("");
    }

    @Test(expected = InvalidUserInputException.class)
    public void createCommandExpectedUserInputExceptionOnMoreThenTwoParams() {
        LoopingConsole.createCommand("INPUT X,Y,F WRONG_PARAM");
    }

    @Test
    public void createCommandWithoutParam() {
        Command command = LoopingConsole.createCommand("INPUT");
        assertEquals("INPUT", command.command());
        assertFalse(command.arguments().isPresent());
    }

    @Test
    public void createCommandWithParam() {
        Command command = LoopingConsole.createCommand("INPUT X,Y,F");
        assertEquals("INPUT", command.command());
        assertTrue(command.arguments().isPresent());
        assertEquals("X,Y,F", command.arguments().get());
    }

}