import java.util.ArrayList;

public class Player {

    private Generator generator;
    private ArrayList<Integer> dices;
    private int currentSum;
    private int currentProduct;

    public Player(Generator generator){
        dices = new ArrayList<Integer>();
        this.generator = generator;
    }

    public void generateDices(){

        currentProduct = 1;
        currentSum = 0;

        for (int i = 0 ; i < 5; i++ ){

            int diceValueToAdd = generator.diceThrow();
            currentProduct *= diceValueToAdd;
            currentSum += diceValueToAdd;

            dices.add(diceValueToAdd);
        }

        return;
    }

    public int getCurrentPlayersProduct(){
        return currentProduct;
    }

    public int getCurrentPlayersSum(){
        return currentSum;
    }


}