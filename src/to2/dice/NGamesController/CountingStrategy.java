package to2.dice.NGamesController;

import to2.dice.game.Dice;

public interface CountingStrategy {
    public int countPoints(Dice dice);
}