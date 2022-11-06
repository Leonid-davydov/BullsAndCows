public class Test {
    public static int locks = 0;

    public static void main(String[] args) {
        int[] turns = new int[100];
        Player player;
        Leading leading;
        int answer;
        int turn;
        int guess;

        for (int i = 0; i < 1000; i++) {
            turn = 0;
            answer = 0;
            player = new Player();
            leading = new Leading();

            while (answer != 40) {
                turn++;
                guess = player.guess();
                answer = leading.answer(guess);
                player.setLastAnswer(answer);
                player.think();
            }

            turns[turn]++;
        }

        System.out.println("Locks: " + locks);

        for (int i = 0; i < 100; i++) {
            System.out.println(i + "turns: " + turns[i] + " games");
        }
    }
}
