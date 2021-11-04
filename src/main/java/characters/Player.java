package characters;

import utils.Checker;
import utils.Role;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Player {
    private static final byte LENGTH = 10;
    public static int number = 1;
    private final String name;
    private final char[][] enemyShips = new char[LENGTH][LENGTH];
    private final Field field = new Field();
    private char[][] playerShips = new char[LENGTH][LENGTH];
    private int hit = 0;
    private List<Ship> ships = Ship.getShips();

    public Player(String name) {
        if (name.equals("")) {
            this.name = "Player " + number;
        } else {
            this.name = name;
        }
        number++;
        shipsInit();
    }

    @Override
    public String toString() {
        return name;
    }

    public char[][] getPlayerShips() {
        return playerShips;
    }

    public int getHit() {
        return hit;
    }

    /**
     * Инициализация полей игроков пустыми значениями
     */
    private void shipsInit() {
        for (int i = 0; i < LENGTH; i++) {
            Arrays.fill(this.playerShips[i], (char) 0);
            Arrays.fill(this.enemyShips[i], (char) 0);
        }
    }

    /**
     * @param role <p>Отрисовка поля игрока
     */
    public void drawField(Role role) {
        if (role == Role.PLAYER)
            field.draw(this.playerShips);
        else
            field.draw(this.enemyShips);
    }

    /**
     * Заполнение поля игрока
     */
    public void fillPlayerField() {
        int orientation = 1;
        int x = 0;
        int y = 0;
        boolean checkBounds = false;
        Checker checker = new Checker();

        System.out.println("Игрок " + this.name + " заполняет свое поле.");

        Iterator<Ship> ship = ships.iterator();
        for (int l = 4; l >= 1; l--) {
            for (int k = 1; k <= 5 - l; k++) {
                System.out.printf("Placing %d-deck ship. (%d of %d)\n", l, k, 5 - l);
                System.out.println("Enter x coord:");
                x = checker.getIntFromConsole(1, 10) - 1;
                System.out.println("Enter y coord:");
                y = checker.getIntFromConsole(1, 10) - 1;

                if (l != 1) {
                    System.out.println("1 - horizontal, 2 - vertical?");
                    orientation = checker.getIntFromConsole(1, 2);
                }

                checkBounds = checker.checkBounds(x, y, l, orientation, playerShips);

                if (checkBounds) {
                    ship.next().setCoords(x, y);
                } else {
                    System.err.println("The ship cannot be placed here.");
                }
            }

            checkBounds = false;

            if (orientation == 1) {
                for (int q = 0; q < l; q++) {
                    playerShips[y][x + q] = 1; // заполняем 1 столько клеток по горизонтали, сколько палуб у корабля

                    playerShips = checker.insertDotsAround(y + 1, x + q, playerShips); // точки снизу
                    playerShips = checker.insertDotsAround(y - 1, x + q, playerShips); // точки сверху
                    playerShips = checker.insertDotsAround(y, x + q + 1, playerShips); // точки справа
                    playerShips = checker.insertDotsAround(y, x - 1, playerShips); // точки слева
                    playerShips = checker.insertDotsAround(y - 1, x - 1, playerShips); // точка сверху слева
                    playerShips = checker.insertDotsAround(y + 1, x - 1, playerShips); // точка снизу слева
                    playerShips = checker.insertDotsAround(y - 1, x + q + 1, playerShips); // // точка сверху справа
                    playerShips = checker.insertDotsAround(y + 1, x + q + 1, playerShips); // // точка снизу справа
                }
            }

            if (orientation == 2) {
                for (int m = 0; m < l; m++) {
                    playerShips[y + m][x] = 1; // заполняем 1 столько клеток по вертикали, сколько палуб у корабля

                    playerShips = checker.insertDotsAround(y - 1, x, playerShips); // точки вверху
                    playerShips = checker.insertDotsAround(y - 1, x - 1, playerShips); // точка вверху слева
                    playerShips = checker.insertDotsAround(y - 1, x + 1, playerShips); // точка вверху справа
                    playerShips = checker.insertDotsAround(y + m + 1, x, playerShips); // точки снизу
                    playerShips = checker.insertDotsAround(y + m + 1, x - 1, playerShips); // точка снизу слева
                    playerShips = checker.insertDotsAround(y + m + 1, x + 1, playerShips); // точка снизу справа
                    playerShips = checker.insertDotsAround(y + m, x + 1, playerShips); // точки справа
                    playerShips = checker.insertDotsAround(y + m, x - 1, playerShips); // точки слева
                }
            }

            drawField(Role.PLAYER);
        }
    }


    public void shoot(Player player) {
        int x;
        int y;

        drawField(Role.ENEMY);

        System.out.println("Ход игрока " + this.name);

        System.out.println("Координата по x:");
        x = new Checker().getIntFromConsole(1, 10) - 1;

        System.out.println("Координата по y:");
        y = new Checker().getIntFromConsole(1, 10) - 1;

        if (player.getPlayerShips()[y][x] == 0) {
            enemyShips[y][x] = 'm';
        } else {
            enemyShips[y][x] = player.getPlayerShips()[y][x];
        }

        if (enemyShips[y][x] == 1)
            hit++;

        drawField(Role.ENEMY);

        if (hit == 20) {
            System.out.println("Игрок " + player + " победил!");
            System.exit(0);
        }
    }
}
