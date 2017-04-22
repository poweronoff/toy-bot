package de.dj_steam.bot.moving.strategy;

import de.dj_steam.bot.domain.Command;
import de.dj_steam.bot.domain.Direction;
import de.dj_steam.bot.domain.Position;
import de.dj_steam.bot.domain.ToyBot;
import de.dj_steam.bot.domain.ToyBotField;

/**
 * @author steam
 */
public class MoveStrategy implements ChangingStrategy {
    @Override
    public void change(final ToyBot toyBot, final ToyBotField toyBotField, final Command command) {
        if (command.getCommand().equals(Command.MOVE)) {
            Position newPosition = toyBot.getPosition();

            // TODO - refactor this ugly code
            if (toyBot.getDirection().equals(Direction.NORTH)) {
                newPosition = new Position(toyBot.getPosition().getX(), toyBot.getPosition().getY() + 1);
            } else if (toyBot.getDirection().equals(Direction.EAST)) {
                newPosition = new Position(toyBot.getPosition().getX() + 1, toyBot.getPosition().getY());
            } else if (toyBot.getDirection().equals(Direction.SOUTH)) {
                newPosition = new Position(toyBot.getPosition().getX(), toyBot.getPosition().getY() - 1);
            } else if (toyBot.getDirection().equals(Direction.WEST)) {
                newPosition = new Position(toyBot.getPosition().getX() - 1, toyBot.getPosition().getY());
            }
            setNewPosition(toyBot, toyBotField, newPosition);
        }
    }

    private void setNewPosition(ToyBot toyBot, final ToyBotField toyBotField, Position position) {
        if (toyBotField.isInsideTheField(position)) {
            toyBot.setPosition(position);
        }
    }
}
