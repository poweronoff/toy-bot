package de.dj_steam.bot.moving.strategy;

import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;
import de.dj_steam.bot.engine.RobotEngine;
import de.dj_steam.bot.moving.DirectionCalculator;

/**
 * @author steam
 */
public class TurnStrategy implements ChangingStrategy {

    private DirectionCalculator directionCalculator;

    public TurnStrategy() {
        directionCalculator = new DirectionCalculator();
    }

    @Override
    public void change(ToyBot toyBot, ToyBotField toyBotField, String command) {
        if (command.equals(RobotEngine.TURN_LEFT) || command.equals(RobotEngine.TURN_RIGHT)) {
            toyBot.setDirection(directionCalculator.calculateNewDirection(toyBot, command));
        }
    }
}
