package player;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        shootBehaviour = new ComputerShoot();
        placeBehaviour = new ComputerPlaceShip();
    }
}
