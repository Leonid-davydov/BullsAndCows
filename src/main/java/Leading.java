public class Leading {
    private static int game = 0;
    private final int num;

    public Leading() {
        num = Utils.variants.get(game);
        game++;
    }

    public int answer(int guess) {
        return Utils.compare(num, guess);
    }

    public int getNum() {
        return num;
    }
}
