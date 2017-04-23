package de.dj_steam.bot.cli;

/**
 * @author steam
 *
 * throw this exception if user input was invalid
 */
public class InvalidUserInputException extends RuntimeException {
    public InvalidUserInputException(String message) { super(message); }
}
