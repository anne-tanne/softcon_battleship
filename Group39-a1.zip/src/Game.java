public class Game {

    private Grid gridPlayerOne;
    private Grid gridPlayerTwo;
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

        gridPlayerOne = new Grid(player1, player2);
        gridPlayerTwo = new Grid(player2, player1);

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        //TEMPORARILY COMMENTED OUT
        gridPlayerTwo.setInitialShips();
        gridPlayerOne.setInitialShips();


        //------STUFF FOR TESTING-----//
        //TODO needs x and y coordinates as input
        //gridPlayerOne.updateFieldState();

        //display.displayTargetGrid(gridPlayerOne);
        //display.displayOceanGrid(gridPlayerOne);

        //display.displayTargetGrid(gridPlayerOne);
        //display.displayOceanGrid(gridPlayerOne);

        //ShipType testtype = ShipType.CARRIER;
        //int testlength = testtype.getLength();

        display.displayTargetGrid(gridPlayerOne);
        display.displayOceanGrid(gridPlayerOne);

        //Start the game loop
        gameLoop();
    }

    public void gameLoop(){
        while (!hasWinner()){
            gridPlayerTwo.updateFieldState(player1.shoot());
            gridPlayerOne.updateFieldState(player2.shoot());

            display.displayTargetGrid(gridPlayerTwo);
            display.displayOceanGrid(gridPlayerOne);
        }
    }

    public Boolean hasWinner(){
        //TODO check on each players Fleet
        if (fleetPlayer1.isFullySunken() || fleetPlayer2.isFullySunken()){
            if (fleetPlayer1.isFullySunken()){
                System.out.println("Computer has won!");
            }
            if (fleetPlayer2.isFullySunken()){
                System.out.println("Congratulations, you won!");
            }
            return true;
        }
        return false;
    }
}
