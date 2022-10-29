public class Fleet {

    Ship[] ships = new Ship[10];

    public Fleet() {
        createFleet();
    }

    public void createFleet(){
        for (int nrOfShips = 0; nrOfShips < 10; nrOfShips++){
            if (nrOfShips == 0){ ships[nrOfShips] = new Ship(ShipType.CARRIER); }
            else if (nrOfShips > 0 && nrOfShips <= 2){
                ships[nrOfShips] = new Ship(ShipType.BATTLESHIP);
                ships[nrOfShips] = new Ship(ShipType.BATTLESHIP);}
            else if (nrOfShips > 2 && nrOfShips <= 5){
                ships[nrOfShips] = new Ship(ShipType.SUBMARINE);
                ships[nrOfShips] = new Ship(ShipType.SUBMARINE);
                ships[nrOfShips] = new Ship(ShipType.SUBMARINE);
            }
            else {
                ships[nrOfShips] = new Ship(ShipType.PATROL);
                ships[nrOfShips] = new Ship(ShipType.PATROL);
                ships[nrOfShips] = new Ship(ShipType.PATROL);
                ships[nrOfShips] = new Ship(ShipType.PATROL);
            }
        }
    }

    public boolean isFullySunken() {
        for (Ship ship : ships) {
            if (!ship.isSunken()) {
                return false;
            }
        }
        return true;
    }
}
