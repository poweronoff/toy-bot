package de.dj_steam.bot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author steam
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
