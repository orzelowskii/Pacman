public class Scorer {

    String nick;
    int score;

    public Scorer(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }

    @Override
    public String toString() {
        return nick + "     score: " + score;
    }
}
