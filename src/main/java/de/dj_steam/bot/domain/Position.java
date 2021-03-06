package de.dj_steam.bot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author steam
 *
 * pojo class for transport robot postion
 */

@Getter
@ToString
@EqualsAndHashCode
public class Position {
    private int x;
    private int y;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}
