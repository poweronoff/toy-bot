package de.dj_steam.bot.engine;

import java.util.ArrayList;
import java.util.List;

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

    public static final String TURN_LEFT = "LEFT";
    public static final String TURN_RIGHT = "RIGHT";
    public static final String MOVE = "MOVE";
    public static final String PLACE = "PLACE";
    public static final String REPORT = "REPORT";

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

    public void commandBot(String command) {
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
