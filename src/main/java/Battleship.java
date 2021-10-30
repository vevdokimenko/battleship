import gameplay.Gameplay;
import utils.Splashscreen;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Battleship {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "utf-8"));

        new Splashscreen();

        new Gameplay();
    }
}


