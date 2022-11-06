package player;

import ship.ShipType;

public interface PlaceBehaviour {
    int[] placeShip(ShipType shiptype);

    void printErrorMessage(String errormessage);
}
