package game;

import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;
import ship.Fleet;

import static utils.DisplayUtils.*;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Fleet fleetPlayer1;
    private final Fleet fleetPlayer2;
    private final Grid gridPlayer1;
    private final Grid gridPlayer2;

    public Game() {
        player1 = new HumanPlayer();
        player2 = new ComputerPlayer();

        fleetPlayer1 = new Fleet();
        fleetPlayer2 = new Fleet();

        gridPlayer1 = new Grid(player1, player2, fleetPlayer1);
        gridPlayer2 = new Grid(player2, player1, fleetPlayer2);
    }

    public void start() {
        //display initial empty grids
        displayTargetGrid(gridPlayer1);
        displayOceanGrid(gridPlayer1);

        //player and computer player set their ships
        gridPlayer1.setInitialShips();
        gridPlayer2.setInitialShips();

        //display grids of human player
        displayTargetGrid(gridPlayer1);
        displayOceanGrid(gridPlayer1);

        //start the game
        play();
    }

    public void play() {
        while (!hasWinner()) {
            gridPlayer2.getOpponentsShot(player1.shoot());
            //ends the game if there is a winner
            if (hasWinner()){break;}
            gridPlayer1.getOpponentsShot(player2.shoot());

            displayTargetGrid(gridPlayer2);
            displayOceanGrid(gridPlayer1);
        }
    }

    public Boolean hasWinner() {
        if (fleetPlayer1.isFullySunken() || fleetPlayer2.isFullySunken()) {
            if (fleetPlayer1.isFullySunken()) {
                System.out.println("Computer has won!");
                System.out.println("Remaining ships that haven't been destroyed:");
                displayEnemyOceanGrid(gridPlayer2);
            }
            if (fleetPlayer2.isFullySunken()) {
                System.out.println("Congratulations, you won!");
            }
            return true;
        }
        return false;
    }
}
