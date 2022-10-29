public class HumanPlayer extends Player {

    public HumanPlayer() {
        shootBehaviour = new HumanShoot();
        placeBehaviour = new HumanPlaceShip();
    }
}
