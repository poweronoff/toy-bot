package de.dj_steam.bot.moving.strategy;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;

/**
 * @author steam
 */
public class ReportStrategy implements ChangingStrategy {
    @Override
    public void change(final ToyBot toyBot, final ToyBotField toyBotField, final Command command) {
        if (command.command().equals(Command.REPORT)) {
            printReport(toyBot);
        }
    }

    private void printReport(final ToyBot toyBot) {
        System.out.println(toyBot);
    }
}
