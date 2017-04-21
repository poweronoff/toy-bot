package de.dj_steam.bot.moving.strategy;

import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;
import de.dj_steam.bot.engine.RobotEngine;

/**
 * @author steam
 */
public class ReportStrategy implements ChangingStrategy {
    @Override
    public void change(ToyBot toyBot, ToyBotField toyBotField, String command) {
        if (command.equals(RobotEngine.REPORT)) {
            printReport(toyBot);
        }
    }

    private void printReport(final ToyBot toyBot) {
        System.out.println(toyBot);
    }
}
