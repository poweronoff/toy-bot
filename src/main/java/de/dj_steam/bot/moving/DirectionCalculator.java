package de.dj_steam.bot.moving;

import java.util.Arrays;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.ToyBot;

/**
 * @author steam
 *
 * this is a helper class to calculate direction
 */
public class DirectionCalculator {

    private final LoopedDirectionsArrayList<Direction> directions;

    public DirectionCalculator() {
        directions = new LoopedDirectionsArrayList();
        directions.addAll(Arrays.asList(Direction.values()));
    }

    public Direction calculateNewDirection(ToyBot toyBot, Command turnDirection) {

        Direction actualDirection = toyBot.getDirection();

        if (turnDirection.getCommand().equals(Command.TURN_LEFT)) {
            return directions.get(directions.indexOf(actualDirection) - 1);
        } else if (turnDirection.getCommand().equals(Command.TURN_RIGHT)) {
            return directions.get(directions.indexOf(actualDirection) + 1);
        }
        return toyBot.getDirection();
    }
}
