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

        public Builder setName(String name) throws InvalidDataException {
            if (name != null && !name.isBlank()) {
                player.name = name;
                return this;
            }
            else throw new InvalidDataException("Non valid name");
        }

        public Builder setTotalGames(int totalGames) throws InvalidDataException {
            if (totalGames >= 0) {
                player.totalGames = totalGames;
                return this;
            }
            else throw new InvalidDataException("Non valid total games");
        }

        public Builder setWonGames(int wonGames) throws InvalidDataException {
            if (wonGames >= 0 && wonGames <= totalGames) {
                player.wonGames = wonGames;
                return this;
            }
            else throw new InvalidDataException("Non valid won games");
        }

        public TableTennisPlayer getPlayer() {
            return player;
        }
    }
}
