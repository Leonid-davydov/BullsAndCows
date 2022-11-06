import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        int turn = 0;
        int answer = 0;
        int bulls;
        int cows;

        Utils.greetings();
        scanner.nextLine();

        while (answer != 40) {
            Utils.computerMove(player.guess());
            turn++;

            Utils.askBulls();
            bulls = scanner.nextInt();
            Utils.askCows();
            cows = scanner.nextInt();

            answer = bulls * 10 + cows;

            player.setLastAnswer(answer);
            player.think();
        }

        Utils.gameOver(turn);
    }
}
