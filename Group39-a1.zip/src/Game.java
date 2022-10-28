public class Game {

    private Grid gridPlayerOne;
    private Grid gridPlayerTwo;
    private Display display;

    public Game() {

    }

    public void initGame() {
        display = new Display();

        Player player1 = new HumanPlayer();
        Player player2 = new ComputerPlayer();

        gridPlayerOne = new Grid(player1);
        gridPlayerTwo = new Grid(player2);

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        //------STUFF FOR TESTING-----//
        //TODO needs x and y coordinates as input
        //gridPlayerOne.updateFieldState();

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        Ship testShip = new Ship(ShipType.BATTLESHIP);
        gridPlayerOne.placeShipOnGrid(testShip, 1, 1);

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        ShipTypeExperimental testtype = ShipTypeExperimental.CARRIER;
        int testlength = testtype.getLength();
    }

    public Boolean hasWinner(){
        //TODO check on each players Fleet
        return false;
    }
}
