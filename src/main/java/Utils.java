import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static final List<Integer> variants = new ArrayList<Integer>();

    static {
        for (int i = 0; i < 10000; i++) {
            if (isCorrect(i)) {
                variants.add(i);
            }
        }
    }

    public static int compare(int answer, int guess) {
        return countBulls(answer, guess) * 10 + countCows(answer, guess);
    }

    public static int countBulls (int answer, int guess) {
        int bulls = 0;

        for (int i = 3; i >= 0; i--) {
            if ((int) (answer / Math.pow(10, i)) == (int) (guess / Math.pow(10, i))) {
                bulls++;
            }

            answer = (int) (answer % Math.pow(10, i));
            guess = (int) (guess % Math.pow(10, i));
        }

        return bulls;
    }

    public static int countCows (int answer, int guess) {
        int bulls = countBulls(answer, guess);

        List<Integer> answerDigits = new ArrayList<Integer>();
        List<Integer> guessDigits = new ArrayList<Integer>();

        for (int i = 3; i >= 0; i--) {
            answerDigits.add((int) (answer / Math.pow(10, i)));
            guessDigits.add((int) (guess / Math.pow(10, i)));

            answer = (int) (answer % Math.pow(10, i));
            guess = (int) (guess % Math.pow(10, i));
        }

        answerDigits.retainAll(guessDigits);

        return answerDigits.size() - bulls;
    }

    public static boolean isCorrect(int num) {
        Set<Integer> numDigits = new HashSet<Integer>();

        for (int i = 3; i >= 0; i--) {
            numDigits.add((int) (num / Math.pow(10, i)));
            num = (int) (num % Math.pow(10, i));
        }

        return numDigits.size() == 4;
    }

    public static void greetings() {
        System.out.println("Welcome to Bulls and Cows\n\n" +
                "Think of a four-digit number in which the numbers do not repeat\n" +
                "Each move the computer will try to guess your number, and you have to answer him how much he succeeded" +
                " (how many bulls and how many cows)\n\n" +
                "When you come up with a number, press enter to start");
    }

    public static void computerMove(int num) {
        System.out.println("The computer thinks your number is: " + num);
    }

    public static void askBulls() {
        System.out.println("Enter the number of bulls: ");
    }

    public static void askCows() {
        System.out.println("Enter the number of cows: ");
    }

    public static void gameOver(int turns) {
        System.out.println("Computer guessed your number in " + turns + " turns");
    }

    public static int getRandomIntegerBetweenRange(double min, double max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }
}
