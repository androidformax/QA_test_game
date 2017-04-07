package tk.macrodev.game;

import java.io.IOException;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class Run {
 //   private static final Logger LOG = Logger.getLogger(Run.class.getName());

    public static void main(String [] args) throws IOException {
        /**
         * Пишем ход игры в файл
         */

/*        PrintStream st = new PrintStream(new FileOutputStream("game_log.txt"));
        System.setErr(st);
        System.setOut(st);*/


        PlayGame playGame = new PlayGame();
        playGame.load();
        playGame.run();

    }
}
