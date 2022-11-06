package ship;

import java.util.ArrayList;

public class Fleet {

    private final Ship[] ships;

    public Fleet() {
        ships = createFleet();
    }

    public Ship[] createFleet() {
        ArrayList<Ship> shipList = new ArrayList<>();
        for (ShipType shiptype : ShipType.values()) {
            if (shiptype != ShipType.NONE) { //ignore ShipType NONE
                int counter = 0;
                //iterates as long as the counter value hits the number of appearances of the specific ship
                while (counter < shiptype.getNumber()) {
                    Ship ship = new Ship(shiptype); //create ship with actual ShipType
                    shipList.add(ship);
                    counter++;
                }
            }
        }
        Ship[] ships = new Ship[shipList.size()];
        return shipList.toArray(ships);
    }

    public boolean isFullySunken() {
        for (Ship ship : ships) {
            if (!ship.isSunken()) {
                return false;
            }
        }
        return true;
    }

    public Ship[] getShips() {
        return ships;
    }
}
