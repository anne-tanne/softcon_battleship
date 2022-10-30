public class Game {

    private Grid gridPlayer1;
    private Grid gridPlayer2;
    private Player player1;
    private Player player2;
    private Fleet fleetPlayer1;
    private Fleet fleetPlayer2;
    private Display display;

    public Game() {
        player1 = new HumanPlayer();
        player2 = new ComputerPlayer();

        fleetPlayer1 = new Fleet();
        fleetPlayer2 = new Fleet();
    }

    public void initGame() {
        display = new Display();

        gridPlayer1 = new Grid(player1, player2, fleetPlayer1);
        gridPlayer2 = new Grid(player2, player1, fleetPlayer2);

        display.displayTargetGrid(gridPlayer1);
        display.displayOceanGrid(gridPlayer1);

        //TEMPORARILY COMMENTED OUT
        gridPlayer2.setInitialShips();
        gridPlayer1.setInitialShips();


        //------STUFF FOR TESTING-----//
        //TODO needs x and y coordinates as input
        //gridPlayerOne.updateFieldState();

        //display.displayTargetGrid(gridPlayerOne);
        //display.displayOceanGrid(gridPlayerOne);

        //display.displayTargetGrid(gridPlayerOne);
        //display.displayOceanGrid(gridPlayerOne);

        //ShipType testtype = ShipType.CARRIER;
        //int testlength = testtype.getLength();

        display.displayTargetGrid(gridPlayer1);
        display.displayOceanGrid(gridPlayer1);

        //Start the game loop
        gameLoop();
    }

    public void gameLoop() {
        while (!hasWinner()) {
            gridPlayer2.updateFieldState(player1.shoot());
            gridPlayer1.updateFieldState(player2.shoot());

            display.displayTargetGrid(gridPlayer2);
            display.displayOceanGrid(gridPlayer1);
        }
    }

    public Boolean hasWinner() {
        //TODO check on each players Fleet
        if (fleetPlayer1.isFullySunken() || fleetPlayer2.isFullySunken()) {
            if (fleetPlayer1.isFullySunken()) {
                System.out.println("Computer has won!");
            }
            if (fleetPlayer2.isFullySunken()) {
                System.out.println("Congratulations, you won!");
            }
            return true;
        }
        return false;
    }
}
