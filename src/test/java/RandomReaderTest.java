void main() {
    testCorrectSize();
    testValidWonGames();
    System.out.println("Все тесты RandomReaderTest пройдены!");
}

private static void testCorrectSize() {
    RandomReader reader = new RandomReader(5);
    int actual = reader.readInput().size();
    if (actual != 5) {
        throw new AssertionError("testCorrectSize провален: ожидалось 5, получилось " + actual);
    }
    System.out.println("testCorrectSize OK");
}

private static void testValidWonGames() {
    RandomReader reader = new RandomReader(20);
    for (TableTennisPlayer player : reader.readInput()) {
        if (player.getWonGames() < 0 || player.getWonGames() > player.getTotalGames()) {
            throw new AssertionError("testValidWonGames провален: wonGames = " + player.getWonGames());
        }
    }
    System.out.println("testValidWonGames OK");
}