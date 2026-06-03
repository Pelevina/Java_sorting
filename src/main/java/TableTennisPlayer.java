public class TableTennisPlayer {
    private final String name;
    private final int totalGames;
    private final int wonGames;

    private TableTennisPlayer(Builder builder) {
        this.name = builder.name;
        this.totalGames = builder.totalGames;
        this.wonGames = builder.wonGames;
    }

    public String getName() {
        return name;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public static class Builder {
        private String name;
        private int totalGames;
        private int wonGames;

        public Builder setName(String name) throws InvalidDataException {
            if (name != null && !name.isBlank()) {
                this.name = name;
                return this;
            } else {
                throw new InvalidDataException("Non valid name");
            }
        }

        public Builder setTotalGames(int totalGames) throws InvalidDataException {
            if (totalGames >= 0) {
                this.totalGames = totalGames;
                return this;
            } else {
                throw new InvalidDataException("Non valid total games");
            }
        }

        public Builder setWonGames(int wonGames) throws InvalidDataException {
            if (wonGames >= 0 && wonGames <= totalGames) {
                this.wonGames = wonGames;
                return this;
            } else {
                throw new InvalidDataException("Non valid won games");
            }
        }

        public TableTennisPlayer build() {
            return new TableTennisPlayer(this);
        }
    }
    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", getName(), getTotalGames(), getWonGames());
    }
}
