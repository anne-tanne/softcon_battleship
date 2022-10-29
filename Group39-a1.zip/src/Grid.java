import java.lang.reflect.Array;

public class Grid {

    private final static int GRID_SIZE = 10;
    private Player player;
    private Player otherPlayer;
    Field[][] grid;

    public Grid(Player player, Player otherPlayer) {
        grid = createEmptyGrid();
        this.player = player;
        this.otherPlayer = otherPlayer;
    }

    private Field[][] createEmptyGrid() {
        Ship emptyShip = new Ship(ShipType.NONE); //this is the default "empty ship" of each Field
        Field[][] fieldList = new Field[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Field field = new Field(FieldState.EMPTY, emptyShip);
                fieldList[row][col] = field;
            }
        }
        return fieldList;
    }

    public void setInitialShips() {
        for (ShipType shiptype : ShipType.values()) {
            if (shiptype != ShipType.NONE) {
                int counter = 0;
                //iterates as long as the counter value hits the number of appearances of the specific ship
                while (counter < shiptype.getNumber()) {
                    System.out.println("Please place your ship " + shiptype.getSimplename());

                    //TODO check on validity of input via Input class

                    //check if ship is "placeable" -> check if chosen fields corresponds to ship length
                    int[] coords = player.placeShip(shiptype.getLength());

                    int xCoordStart = coords[0];
                    int yCoordStart = coords[1];
                    int xCoordEnd = coords[2];
                    int yCoordEnd = coords[3];

                    //ship is on the same column (vertical placement)
                    if (xCoordStart == xCoordEnd && (yCoordEnd == yCoordStart + shiptype.getLength() - 1
                            || yCoordEnd == yCoordStart - shiptype.getLength() - 1)) {
                        System.out.println("HELL YEAH");

                        //loop through all relevant fields
                        int start = Math.min(yCoordStart, yCoordEnd);
                        int end = Math.max(yCoordStart, yCoordEnd);

                        //TODO check if there is already a ship placed

                        //TODO place the ship on the specific fields of grid
                        Ship ship = new Ship(shiptype); //new ship with current ship type
                        for (int i = start; i <= end; i++) {
                            placeShipOnGrid(ship, xCoordStart, i);
                        }

                        //ship is on the same row (horizontal placement)
                    } else if (yCoordStart == yCoordEnd && (xCoordEnd == xCoordStart + shiptype.getLength() - 1
                            || xCoordEnd == xCoordStart - shiptype.getLength() - 1)) {
                        //loop through all relevant fields
                        int start = Math.min(xCoordStart, xCoordEnd);
                        int end = Math.max(xCoordStart, xCoordEnd);

                        //TODO check if there is already a ship placed

                        //TODO place the ship on the specific fields of grid
                        Ship ship = new Ship(shiptype); //new ship with current ship type
                        for (int i = start; i <= end; i++) {
                            placeShipOnGrid(ship, i, yCoordStart);
                        }
                    } else {
                        //TODO
                        System.out.println("OHH NO");
                    }

                    counter++;

                }
            }
        }
    }

    //needed at the beginning to set the ship-fields on the grid
    public void placeShipOnGrid(Ship ship, int coordX, int coordY) {
        grid[coordY][coordX].setFieldState(FieldState.SHIP);
        grid[coordY][coordX].setShip(ship);
    }

    public void updateFieldState(int[] coordsXY) {
        int coordX = (int) Array.get(coordsXY, 0);
        int coordY = (int) Array.get(coordsXY, 1);

        // select the Field which was shot at
        Field hitField = grid[coordY][coordX];

        //get actual FieldState of the hit Field and update its state
        switch (hitField.getFieldState()) {
            case EMPTY -> {
                hitField.setFieldState(FieldState.MISS);
                System.out.println("Bummer, that was a miss :(");
            }
            case SHIP -> {
                //TODO
                //Ship.gotShot (leben Abgezogen) -> Ship.checkLife
                //if checkLife == False
                //DESTROYED
                hitField.setFieldState(FieldState.HIT);
                System.out.println("That was a hit, Nice !!!");
            }
            case HIT, MISS, SUNKEN_SHIP -> {
                //TODO shoot again
                System.out.println("You have already shot at this location!");
                // I tried it with otherPlayer but this seems to work
                // I leave "otherPlayer" in here we can delete it in the end if it's never used.
                player.shoot();
            }
        }
    }

    public Field[][] getGrid() {
        return grid;
    }
}

