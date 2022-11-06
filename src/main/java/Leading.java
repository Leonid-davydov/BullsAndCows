public class Leading {
    private final int num;

    public Leading() {
        num = Utils.variants.get(Utils.getRandomIntegerBetweenRange(0, 5039));
    }

    public int answer(int guess) {
        return Utils.compare(num, guess);
    }

    public int getNum() {
        return num;
    }
}
