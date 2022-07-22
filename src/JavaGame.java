import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class JavaGame {

    public static void main(String[] args) {

        Random random = new Random();

        int rndmXP = random.nextInt(40);
        int rndmXS = random.nextInt(40);
        int rndmXG = random.nextInt(40);
        int rndmXD = random.nextInt(40);
        int rndmYP = random.nextInt(10);
        int rndmYS = random.nextInt(10);
        int rndmYG = random.nextInt(10);
        int rndmYD = random.nextInt(10);

        Point playerPos = new Point(rndmXP, rndmYP);
        Point snakePos = new Point(rndmXS, rndmYS);
        Point goldPos = new Point(rndmXG, rndmYG);
        Point doorPos = new Point(rndmXD, rndmYD);
        boolean game = true;
        boolean collectGold = false;

        while (game) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(playerPos))
                        System.out.print("P");
                    else if (p.equals(snakePos))
                        System.out.print("S");
                    else if (p.equals(goldPos))
                        System.out.print("G");
                    else if (p.equals(doorPos))
                        System.out.print("D");
                    else System.out.print(".");
                }
                System.out.println();
            }

            if (snakePos.equals(playerPos)) {
                game = false;
                System.out.println("U got eaten by the snake L");
            }

            if (playerPos.equals(goldPos)) {
                collectGold = true;
                goldPos = new Point(-1, -1);
            }

            if (playerPos.equals(doorPos) && collectGold) {
                game = false;
                System.out.println("U actually won!");
            }

        playerMove(playerPos);
        snakeMove(snakePos, playerPos);

    }
}
    public static void snakeMove(Point snakePos, Point playerPos) {

        if (playerPos.x < snakePos.x) {
            snakePos.x--;
        } else if (playerPos.x > snakePos.x) {
            snakePos.x++;
        } else if (playerPos.y < snakePos.y) {
            snakePos.y--;
        } else if (playerPos.y > snakePos.y) {
            snakePos.y++;
        }
    }

    public static void playerMove(Point playerPos) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        switch (input) {
            case "w":
                if (playerPos.y > 0) {
                    playerPos.y --;
                }
                break;
            case "s":
                if (playerPos.y < 9) {
                    playerPos.y++;
                }
                break;
            case "a":
                if (playerPos.x > 0) {
                    playerPos.x--;
                }
                break;
            case "d":
                if (playerPos.x < 39) {
                    playerPos.x++;
                }
                break;
        }
    }
}