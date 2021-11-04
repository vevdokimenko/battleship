package characters;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int x;
    private int y;
    private int deck;
    private int[][] coords = new int[deck][deck];
    private int wound = 0;

    public Ship(int deck) {
        this.deck = deck;
    }

    public int getDeck() {
        return deck;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static List<Ship> getShips() {
        List<Ship> ships = new ArrayList<>();

        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= 5 - i; j++) {
                ships.add(new Ship(i));
            }
        }

        return ships;
    }
}
