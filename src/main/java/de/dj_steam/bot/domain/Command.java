package de.dj_steam.bot.domain;

import java.util.List;
import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author steam
 *
 * this is a general command implementation.
 *
 * The arguments as {@link String} is intentionally, to be flexible
 * define some different argument formats.
 *
 * Use some kind of {@link List} for arguments in futher implementations.
 */

@Getter
@EqualsAndHashCode
public class Command {

    public static final String TURN_LEFT = "LEFT";
    public static final String TURN_RIGHT = "RIGHT";
    public static final String MOVE = "MOVE";
    public static final String PLACE = "PLACE";
    public static final String REPORT = "REPORT";

    private String command;

    private Optional<String> arguments;

    public Command(final String command, Optional<String> arguments) {
        this.command = command;
        this.arguments = arguments;
    }
}
