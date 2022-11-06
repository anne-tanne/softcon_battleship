package player;

import ship.ShipType;

public class Player {

    public ShootBehaviour shootBehaviour;
    public PlaceBehaviour placeBehaviour;

    public int[] shoot(){
        return shootBehaviour.shoot();
    }
    public int[] placeShip(ShipType shiptype){
        return placeBehaviour.placeShip(shiptype);
    }

    public void printErrorMessage(String errormessage){
        placeBehaviour.printErrorMessage(errormessage);
    }

    public void printShootMessage(String message){
        shootBehaviour.printShootMessage(message);
    }
}
