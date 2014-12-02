package to2.dice.NGamesController;

import to2.dice.controllers.GameController;
import to2.dice.NGamesController.CountingStrategy;
import to2.dice.game.GameInfo;
import to2.dice.game.GameSettings;
import to2.dice.game.NGameState;
import to2.dice.game.Player;
import to2.dice.messaging.GameAction;
import to2.dice.messaging.GameActionType;
import to2.dice.messaging.RerollAction;
import to2.dice.messaging.Response;
import to2.dice.server.GameServer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NGamesController extends GameController {
    private NGameState state;
    private CountingStrategy strategy;
    private Lock timerLock;
    private Thread timer;

    public NGamesController(GameServer server, GameSettings settings, String creator, CountingStrategy strategy) {
        super(server, settings, creator);
        this.state = new NGameState();
        this.strategy = strategy;
        this.timerLock = new ReentrantLock();
        this.timer = new Timer(settings.getTimeForMove(), timerLock);
    }

    @Override
    public GameInfo getGameInfo() {
        return new GameInfo(settings, state);
    }

    @Override
    public Response handleGameAction(GameAction action) {
        GameActionType type = action.getType();
        Response response;
        switch (type) {
            case SIT_DOWN:
                response = new Response(joinGame(action.getSender()));
                break;
            case STAND_UP:
                response = new Response(leaveGame(action.getSender()));
                break;
            case REROLL:
                response = new Response(reroll(action.getSender(), ((RerollAction) action).getChosenDice()));
                break;
            default:
                response = new Response(Response.Type.FAILURE, "Action doesn't exist");
                break;
        }

        return response;
    }

    private Response.Type joinGame(String sender) {
        if(state.getPlayersNumber() < settings.getMaxPlayers()) {
            state.addPlayer(new Player(sender, false, settings.getDiceNumber()));
            return Response.Type.SUCCESS;
        }
        else{
            startGame();
        }
        return Response.Type.FAILURE;
    }

    private Response.Type leaveGame(String sender){
        /* TODO: removing Players from list (somehow) */
        if(true){
            return Response.Type.SUCCESS;
        }
        else return Response.Type.FAILURE;
    }

    private Response.Type reroll(String sender, boolean[] dicesToReroll){

        return Response.Type.SUCCESS;
    }

    private void startGame(){
        /* TODO: sendToAll && start Timer for current player */
    }
}