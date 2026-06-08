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
        private Integer totalGames;
        private Integer wonGames;

        public Builder setName(String name) {
            this.name = name != null ? name.trim() : null;
            return this;
        }

        public Builder setTotalGames(Integer totalGames) {
            this.totalGames = totalGames;
            return this;
        }

        public Builder setWonGames(Integer wonGames) {
            this.wonGames = wonGames;
            return this;
        }

        public TableTennisPlayer build() throws InvalidDataException {
            if (name == null || name.isEmpty()) {
                throw new InvalidDataException("Player name cannot be null or empty.");
            }

            if (totalGames == null) {
                throw new InvalidDataException("Total games count is not specified.");
            }

            if (wonGames == null) {
                throw new InvalidDataException("Won games count is not specified.");
            }

            if (totalGames < 0) {
                throw new InvalidDataException("Total games count cannot be negative.");
            }

            if (wonGames < 0) {
                throw new InvalidDataException("Won games count cannot be negative.");
            }

            if (wonGames > totalGames) {
                throw new InvalidDataException(
                        "Won games count (%d) cannot exceed total games count (%d)."
                                .formatted(wonGames, totalGames)
                );
            }

            return new TableTennisPlayer(this);
        }
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", getName(), getTotalGames(), getWonGames());
    }
}
