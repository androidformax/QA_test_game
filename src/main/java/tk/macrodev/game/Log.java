package tk.macrodev.game;

import java.io.*;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 05.04.2017
 */
public class Log {

    private static final String FILE = "game_log.txt"; //File path

    public static void writeFile(String log){
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(FILE));
            printStream.println(log);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


