package to2.dice.NGamesController;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Generator {

    private SecureRandom random;
    private int sumToThrow;
    private int productToThrow;

    public Generator() throws NoSuchAlgorithmException {
        random = SecureRandom.getInstance("SHA1PRNG");
    }

    public void generateSum(){
        sumToThrow = 0;

        for(int i = 0; i < 5; i++ ){
            sumToThrow += Math.abs((new Integer(random.nextInt()) % 6)) + 1;
        }

        return;
    }

    public void generateProduct(){
        productToThrow = 1;

        for(int i = 0 ; i < 5; i++ ){
            productToThrow *= Math.abs(new Integer(random.nextInt() % 6)) + 1;
        }

        return;
    }

    public int diceThrow(){
        return Math.abs((new Integer(random.nextInt()) % 6)) + 1;
    }

    public int getSumToThrow(){
        return sumToThrow;
    }

    public int getProductToThrow(){
        return productToThrow;
    }
}