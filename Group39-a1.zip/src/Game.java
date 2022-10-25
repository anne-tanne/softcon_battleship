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

        Ship testShip = new Ship(ShipType.BATTLESHIP);
        gridPlayerOne.placeShipOnGrid(testShip, 1, 1);
        gridPlayerOne.printGrid();
    }

    public Boolean hasWinner(){
        //TODO check on each players Fleet
        return false;
    }
}
