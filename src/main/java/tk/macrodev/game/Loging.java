package tk.macrodev.game;

import java.io.*;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 05.04.2017
 */
public class Loging {
    public static void log() throws IOException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("gamelog.txt"));
            System.setOut(out);
        }catch(IOException e){
            System.out.println("Problem with write file:" + e);
        }
    }
}
