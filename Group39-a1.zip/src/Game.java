public class Game {

    private Grid gridPlayerOne;
    private Grid gridPlayerTwo;
    private Display display;

    public Game() {

    }

    public void initGame() {
        display = new Display();
        gridPlayerOne = new Grid();
        gridPlayerTwo = new Grid();

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        gridPlayerOne.updateFieldState();

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        Ship testShip = new Ship(ShipType.BATTLESHIP);
        gridPlayerOne.placeShipOnGrid(testShip, 1, 1);

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);
    }

    public Boolean hasWinner(){
        //TODO check on each players Fleet
        return false;
    }
}
