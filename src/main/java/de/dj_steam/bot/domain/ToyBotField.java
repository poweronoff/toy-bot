package de.dj_steam.bot.domain;

import lombok.Getter;

/**
 * @author steam
 *
 * the field to move robot over. It incapsulate the logic for calculate that the robot will
 * move over the border on the next step or on place it on the field
 */

@Getter
public class ToyBotField {
    private int width = 4;
    private int height = 4;

    public boolean isInsideTheField(final Position position) {
        return (position.getX() >= 0 &&
                position.getY() >= 0 &&
                position.getX() <= width &&
                position.getY() <= height);
    }

}
