package de.dj_steam.bot.moving;

import java.util.Arrays;

import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.engine.RobotEngine;

/**
 * @author steam
 */
public class DirectionCalculator {

    private LoopedDirectionsArrayList<Direction> directions;

    public DirectionCalculator() {
        directions = new LoopedDirectionsArrayList();
        directions.addAll(Arrays.asList(Direction.values()));
    }

    public Direction calculateNewDirection(ToyBot toyBot, String turnDirection) {

        Direction actualDirection = toyBot.getDirection();

        if (turnDirection.equals(RobotEngine.TURN_LEFT)) {
            return directions.get(directions.indexOf(actualDirection) - 1);
        } else if (turnDirection.equals(RobotEngine.TURN_RIGHT)) {
            return directions.get(directions.indexOf(actualDirection) + 1);
        }
        return toyBot.getDirection();
    }
}
