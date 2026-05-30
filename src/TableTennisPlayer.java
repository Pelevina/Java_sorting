public class TableTennisPlayer {
    private String name;
    private int totalGames;
    private int wonGames;

    public String getName() {
        return name;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public class Builder {
        private TableTennisPlayer player;

        public Builder setName(String name) {
            player.name = name;
            return this;
        }

        public Builder setTotalGames(int totalGames) {
            player.totalGames = totalGames;
            return this;
        }

        public Builder setWonGames(int wonGames) {
            player.wonGames = wonGames;
            return this;
        }

        public TableTennisPlayer getPlayer() {
            return player;
        }
    }
}
