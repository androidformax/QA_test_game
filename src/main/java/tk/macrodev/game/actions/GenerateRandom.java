package tk.macrodev.game.actions;

import java.util.Random;

/**
 * Created by androidformax on 20.03.2017.
 */
public class GenerateRandom {
    private static Random random = new Random();

    public static int generateRandom(int n) {
        return Math.abs(random.nextInt()) % n;
    }
}
