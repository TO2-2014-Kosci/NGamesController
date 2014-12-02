package to2.dice.NGamesController;

import java.util.concurrent.locks.Lock;

public class Timer extends Thread {
    /* TODO: Timer in general :P */
    long moveTime;
    Lock timerLock;

    public Timer(long moveTime, Lock timerLock){
        this.moveTime = moveTime * 1000;
    }

    @Override
    public void run(){
        try {
            sleep(moveTime);
        } catch (InterruptedException e) {}

        if(!isInterrupted()) {
            if(timerLock.tryLock()){
                /* TODO: messaging && locking with player action */
            }
        }
    }
}
