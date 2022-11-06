import java.util.*;

public class Player {
    public List<Integer> variants = new ArrayList<>(Utils.variants);
    private int lastGuess = -1;
    private int lastAnswer;

    public int guess() {
        int[][] statistic = new int[4][10];
        int guess = 0;
        Set<Integer> digits = new HashSet<>();

        if (lastGuess == -1) {
            lastGuess = 1234;
            return 1234;
        }

        for (Integer variant : variants) {
            int a = variant;

            for (int i = 0; i < 4; i++) {
                statistic[i][(int) (a / Math.pow(10, 3 - i))]++;
                a = (int) (a % Math.pow(10, 3 - i));
            }
        }

        digits.clear();

        for (int i = 0; i < 4; i++) {
            int digit = 0;
            int frequency = 1000;

            for (int j = 0; j < 10; j++) {
                if (statistic[i][j] < frequency && statistic[i][j] > 0 && !digits.contains(j)) {
                    digit = j;
                    frequency = statistic[i][j];
                }
            }

            digits.add(digit);
            guess += digit * Math.pow(10, 3 - i);
        }

        if (guess == lastGuess) {
            guess = variants.get(0);
        }

        lastGuess = guess;
        return guess;
    }

    public void think() {
        Iterator<Integer> iterator = variants.listIterator();
        Integer variant;

        while (iterator.hasNext()) {
            variant = iterator.next();

            int answer = Utils.compare(variant, lastGuess);
            if (answer != lastAnswer) {
                iterator.remove();
            }
        }
    }

    public void setLastAnswer(int lastAnswer) {
        this.lastAnswer = lastAnswer;
    }

    public void setLastGuess(int lastGuess) {
        this.lastGuess = lastGuess;
    }
}
