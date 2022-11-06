import java.util.*;

public class Player {
    public List<Integer> variants = new ArrayList<>(Utils.variants);
    private int lastGuess = -1;
    private int lastAnswer;

    public int guess() {
        int guess = variants.get(0);
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
