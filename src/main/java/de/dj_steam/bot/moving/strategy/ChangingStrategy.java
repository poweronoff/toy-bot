package de.dj_steam.bot.moving.strategy;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;

/**
 * @author steam
 *
 * this strategy defines how the robot will be manipulated
 * implement this, if new change variant is wanted.
 * <p>
 * use {@link Command} to define new commans to implement
 */

public interface ChangingStrategy {
    void change(ToyBot toyBot, ToyBotField toyBotField, Command command);
}
