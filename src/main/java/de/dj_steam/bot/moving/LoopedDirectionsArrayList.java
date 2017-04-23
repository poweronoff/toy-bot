package de.dj_steam.bot.moving;

import java.util.ArrayList;

/**
 * @author steam
 *
 * this class is a simple looped ArrayList.
 *
 * it is possible to get indexed elements ot this list, which are over the size of the Array.
 *
 * the get(x) method will return the right element of list from the loop. It works with negative
 * values to.
 *
 * This class does NOT support looped iterator.
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
