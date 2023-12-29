import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DrunkardGame5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение карт первого игрока
        System.out.println("Введите по одной, карты первого игрока.");
        Deque<Integer> player1 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            player1.addFirst(scanner.nextInt());
        }

        // Чтение карт второго игрока
        System.out.println("Введите по одной, карты второго игрока.");
        Deque<Integer> player2 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            player2.addFirst(scanner.nextInt());
        }

        scanner.close();

        // Игра
        int moves = 0;
        while (!player1.isEmpty() && !player2.isEmpty() && moves < 106) {
            int card1 = player1.pollLast();
            int card2 = player2.pollLast();

            if (card1 == 0 && card2 == 9) {
                player1.addFirst(card1);
                player1.addFirst(card2);
            } else if (card1 == 9 && card2 == 0) {
                player2.addFirst(card1);
                player2.addFirst(card2);
            } else if (card1 > card2) {
                player1.addFirst(card1);
                player1.addFirst(card2);
            } else if (card1 < card2) {
                player2.addFirst(card1);
                player2.addFirst(card2);
            }

            moves++;
        }

        // Определение победителя
        if (player1.isEmpty() && player2.isEmpty()) {
            System.out.println("botva");
        } else if (player2.isEmpty()) {
            System.out.println("Победил первый игрок, за " + moves + " ходов");
        } else if (player1.isEmpty()) {
            System.out.println("Победил второй игрок, за " + moves + " ходов");
        } else {
            System.out.println("infinity");
        }
    }
}