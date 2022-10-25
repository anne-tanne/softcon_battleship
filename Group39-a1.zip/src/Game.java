public class Game {

    private Grid gridPlayerOne;
    private Grid gridPlayerTwo;

    public Game() {

    }

    public void initGame() {
        gridPlayerOne = new Grid();
        gridPlayerTwo = new Grid();

        gridPlayerOne.printGrid();
        gridPlayerOne.updateFieldState();
    }
}
