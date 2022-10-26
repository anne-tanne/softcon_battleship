public class Game {

    private Grid gridPlayerOne;
    private Grid gridPlayerTwo;
    private Display display;

    public Game() {
        display = new Display();
        gridPlayerOne = new Grid(); // human player grid
        gridPlayerTwo = new Grid(); // computer player grid
    }

    public void initGame() {

        //print initial boards of player (empty)
        display.displayTargetGrid(gridPlayerTwo);
        display.displayOceanGrid(gridPlayerOne);

        //ask player to input all ships
        //TODO

        //computer places ships
        //TODO

        //loop until game is over
            //TODO
            //print grids
            //human player shoot
            //computer player shoot


        //stuff for testing
        gridPlayerOne.updateFieldState(7, 8);
        gridPlayerTwo.updateFieldState(1, 2);

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerTwo);

        Ship testShip = new Ship(ShipType.BATTLESHIP);
        gridPlayerOne.placeShipOnGrid(testShip, 1, 1);

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);
    }

    public Boolean hasWinner() {
        //TODO check on each players Fleet
        return false;
    }
}
