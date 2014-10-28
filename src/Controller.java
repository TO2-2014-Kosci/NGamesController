import java.util.ArrayList;

public class Controller {

    private Generator generator;
    private ArrayList<Player> players;

    public Controller(Generator generator, ArrayList<Player> players){
        this.generator = generator;
        this.players = players;
    }

    public void preparePlayers(){
        for( Player player : players ){
            while( !playerHasWon(player) ){
                player.generateDices();
            }
        }
    }

    private boolean playerHasWon(Player player){
        if (generator.getSumToThrow() == player.getCurrentPlayersSum()
                || generator.getProductToThrow() == player.getCurrentPlayersProduct()){
            return false;
        }

        return true;
    }

}