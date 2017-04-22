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
    public void createCommandExpectedUserInputExceptionOnEmptyInput() throws Exception {
        LoopingConsole.createCommand("");
    }

    @Test(expected = InvalidUserInputException.class)
    public void createCommandExpectedUserInputExceptionOnMoreThenTwoParams() throws Exception {
        LoopingConsole.createCommand("INPUT X,Y,F WRONG_PARAM");
    }

    @Test
    public void createCommandWithoutParam() {
        Command command = LoopingConsole.createCommand("INPUT");
        assertEquals("INPUT", command.getCommand());
        assertFalse(command.getArguments().isPresent());
    }

    @Test
    public void createCommandWithParam() {
        Command command = LoopingConsole.createCommand("INPUT X,Y,F");
        assertEquals("INPUT", command.getCommand());
        assertTrue(command.getArguments().isPresent());
        assertEquals("X,Y,F", command.getArguments().get());
    }

}