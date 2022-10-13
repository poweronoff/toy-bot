package de.dj_steam.bot.domain;

import java.util.List;
import java.util.Optional;

/**
 * @author steam
 * <p>
 * this is a general command implementation.
 * <p>
 * The arguments as {@link String} is intentionally, to be flexible
 * define some different argument formats.
 * <p>
 * Use some kind of {@link List} for arguments in futher implementations.
 */

public record Command(String command, Optional<String> arguments) {

    public static final String TURN_LEFT = "LEFT";
    public static final String TURN_RIGHT = "RIGHT";
    public static final String MOVE = "MOVE";
    public static final String PLACE = "PLACE";
    public static final String REPORT = "REPORT";

}
