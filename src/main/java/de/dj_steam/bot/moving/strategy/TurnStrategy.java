package de.dj_steam.bot.moving.strategy;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;
import de.dj_steam.bot.moving.DirectionCalculator;

/**
 * @author steam
 */
public class TurnStrategy implements ChangingStrategy {

    private final DirectionCalculator directionCalculator;

    public TurnStrategy() {
        directionCalculator = new DirectionCalculator();
    }

    @Override
    public void change(final ToyBot toyBot, final ToyBotField toyBotField, final Command command) {
        if (command.command().equals(Command.TURN_LEFT) || command.command().equals(Command.TURN_RIGHT)) {
            toyBot.setDirection(directionCalculator.calculateNewDirection(toyBot, command));
        }
    }
}
