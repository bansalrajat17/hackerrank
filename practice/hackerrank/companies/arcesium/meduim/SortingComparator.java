import java.util.Comparator;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        // If 2 Players have the same score
        if (a.score == b.score) {
            // Order alphabetically by name
            return a.name.compareTo(b.name);
        }

        // Otherwise, order higher score first
        return ((Integer) b.score).compareTo(a.score);

    }
}
