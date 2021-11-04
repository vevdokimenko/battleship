import characters.Player;
import characters.Ship;
import utils.Splashscreen;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Battleship {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "utf-8"));

        Player player = new Player("");
        player.fillPlayerField();

//        new Splashscreen();
//        new Gameplay();
    }
}


