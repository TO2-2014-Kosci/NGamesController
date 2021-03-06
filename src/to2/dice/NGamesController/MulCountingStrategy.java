package to2.dice.NGamesController;

import to2.dice.game.Dice;

public class MulCountingStrategy implements CountingStrategy {
    @Override
    public int countPoints(Dice dice) {
        int result = 1;
        for(int i: dice.getValue()){
            result *= i;
        }
        return result;
    }
}