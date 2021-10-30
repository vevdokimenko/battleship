package utils;

import java.util.Scanner;

public class Checker {
    public int getIntFromConsole(int min, int max) {
        int result;
        while (true) {
            try {
                result = new Scanner(System.in).nextInt();
                if (result < min || result > max)
                    throw new Exception();
                return result;
            } catch (Exception e) {
                System.err.println("Введите корректное значение!");
            }
        }
    }

    public boolean checkBounds(int x, int y, int l, int orientation, char[][] playerShips) {
        if (orientation == 1 && x + l <= playerShips.length) {
            return playerShips[y][x] == 0 && playerShips[y][x + l - 1] == 0;
        }
        if (orientation == 2 && y + l <= playerShips.length) {
            return playerShips[y][x] == 0 && playerShips[y + l - 1][x] == 0;
        }
        return false;
    }

    public char[][] insertDotsAround(int x, int y, char[][] field) {
        try {
            field[x][y] = 'm';
            return field;
        } catch (ArrayIndexOutOfBoundsException e) {
            return field;
        }
    }
}
