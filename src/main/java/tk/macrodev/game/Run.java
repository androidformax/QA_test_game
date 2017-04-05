package tk.macrodev.game;

import java.io.IOException;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class Run {
    public static void main(String [] args) throws IOException {
        Loging loging = new Loging();
        loging.log();
        PlayGame playGame = new PlayGame();
        playGame.load();
        playGame.run();
    }
}
