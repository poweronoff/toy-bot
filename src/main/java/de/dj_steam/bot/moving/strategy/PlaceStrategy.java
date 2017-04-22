package de.dj_steam.bot.moving.strategy;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;

/**
 * @author steam
 */
public class PlaceStrategy implements ChangingStrategy {

    @Override
    public void change(ToyBot toyBot, ToyBotField toyBotField, Command command) {
        if (command.getCommand().equals(Command.PLACE) &&
                isPlaceCommandValid(command) &&
                canBePlaced(toyBotField, command)) {
            String[] arguments = command.getArguments().get().split(",");

            toyBot.setPosition(new Position(Integer.parseInt(arguments[0].trim()), Integer.parseInt(arguments[1].trim())));
            toyBot.setDirection(Direction.valueOf(arguments[2].trim()));
        }
    }

    boolean isPlaceCommandValid(Command command) {
        if (command.getArguments().isPresent()) {
            String[] arguments = command.getArguments().get().split(",");
            return arguments.length == 3 &&
                    StringUtils.isNumeric(arguments[0].trim()) &&
                    StringUtils.isNumeric(arguments[1].trim()) &&
                    EnumUtils.isValidEnum(Direction.class, arguments[2].trim());
        }
        return false;
    }

    boolean canBePlaced(final ToyBotField toyBotField, final Command command) {
        String[] arguments = command.getArguments().get().split(",");
        return toyBotField.isInsideTheField(new Position(Integer.parseInt(arguments[0].trim()),Integer.parseInt(arguments[1].trim())));
    }
}
