package de.dj_steam.bot.domain;

import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author steam
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
