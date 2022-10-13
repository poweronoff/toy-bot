package de.dj_steam.bot.domain;

import lombok.Getter;

/**
 * @author steam
 */
@Getter
public class ToyBotField {
    private final int width = 4;
    private final int height = 4;

    public boolean isInsideTheField(final Position position) {
        return (position.getX() >= 0 &&
                position.getY() >= 0 &&
                position.getX() <= width &&
                position.getY() <= height);
    }

}
