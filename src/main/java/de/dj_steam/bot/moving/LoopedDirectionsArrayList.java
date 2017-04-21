package de.dj_steam.bot.moving;

import java.util.ArrayList;

/**
 * @author steam
 */
public class LoopedDirectionsArrayList<Direction> extends ArrayList<Direction> {

    @Override
    public Direction get(int index) {
        if (index < 0) {
            return super.get(size() - Math.abs(index));
        } else if (index >= size()) {
            return super.get(index - size());
        } else {
            return super.get(index);
        }
    }
}
