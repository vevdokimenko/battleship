import characters.Player;

import java.util.Scanner;

public class Gameplay {

    public Gameplay() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Игрок 1, ваше имя:");
        Player player1 = new Player(sc.nextLine());
        System.out.println("Привет, " + player1);

        System.out.println("Игрок 2, ваше имя:");
        Player player2 = new Player(sc.nextLine());
        System.out.println("Привет, " + player2);

        player1.fillPlayerField();

        player2.fillPlayerField();

        while (player1.getHit() != 20 || player2.getHit() != 20) {

            while (true) {
                int oldHit = player1.getHit();
                player1.shoot(player2);
                if (oldHit == player1.getHit())
                    break;
            }

            while (true) {
                int oldHit = player2.getHit();
                player2.shoot(player1);
                if (oldHit == player2.getHit())
                    break;
            }

        }
    }
}
