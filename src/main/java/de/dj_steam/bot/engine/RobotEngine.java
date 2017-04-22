package de.dj_steam.bot.engine;

import java.util.ArrayList;
import java.util.List;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;
import de.dj_steam.bot.moving.strategy.ChangingStrategy;
import de.dj_steam.bot.moving.strategy.ReportStrategy;
import de.dj_steam.bot.moving.strategy.TurnStrategy;

/**
 * @author steam
 */
public class RobotEngine {

    private final ToyBotField toyBotField;
    private final ToyBot toyBot;
    private List<ChangingStrategy> changingStrategies;

    public RobotEngine() {
        this.toyBot = new ToyBot(Direction.NORTH, new Position());
        this.toyBotField = new ToyBotField();
        initChangingStrategies();
    }

    public RobotEngine(final ToyBotField toyBotField, final ToyBot toyBot) {
        this.toyBotField = toyBotField;
        this.toyBot = toyBot;
        initChangingStrategies();
    }

    public void commandBot(Command command) {
        for (ChangingStrategy strategy : changingStrategies) {
            strategy.change(toyBot, toyBotField, command);
        }
    }

    private void initChangingStrategies() {
        changingStrategies = new ArrayList<>();
        changingStrategies.add(new TurnStrategy());
        changingStrategies.add(new ReportStrategy());
    }
}
