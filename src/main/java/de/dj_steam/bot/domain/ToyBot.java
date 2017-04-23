package de.dj_steam.bot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author steam
 *
 * pojo representing the robot, it have following properties
 *
 * {@link  Direction} - current facing of the robot
 * {@link Position} - current posiotion of the robot
 */

@Getter
@Setter
@ToString
public class ToyBot {

    private Direction direction;
    private Position position;

    public ToyBot(final Direction direction, final Position position) {
        this.direction = direction;
        this.position = position;
    }

}
