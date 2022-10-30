import java.lang.reflect.Array;

public class Grid {

    private final static int GRID_SIZE = 10;
    private Player player;
    private Player otherPlayer;
    Field[][] grid;

    public Grid(Player player, Player otherPlayer) {
        grid = createEmptyGrid();
        this.player = player;
        this.otherPlayer =otherPlayer;
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
            if (shiptype != ShipType.NONE) { //ignore ShipType NONE
                int counter = 0;
                //iterates as long as the counter value hits the number of appearances of the specific ship
                while (counter < shiptype.getNumber()) {
                    boolean isValid = false;
                    while (!isValid) {
                        // get user input
                        int[] coords = player.placeShip(shiptype);

                        int xCoordStart = coords[0];
                        int yCoordStart = coords[1];
                        int xCoordEnd = coords[2];
                        int yCoordEnd = coords[3];


                        //ship is on the same column (vertical placement)
                        if (xCoordStart == xCoordEnd && (yCoordEnd == yCoordStart + shiptype.getLength() - 1
                                || yCoordEnd == yCoordStart - shiptype.getLength() + 1)) {

                            //check first if all relevant Fields are free before starting placing ships
                            int start = Math.min(yCoordStart, yCoordEnd);
                            int end = Math.max(yCoordStart, yCoordEnd);

                            if (columnIsEmpty(xCoordStart, start, end)) {
                                //place ship on the grid
                                Ship ship = new Ship(shiptype); //new ship with current ship type
                                for (int i = start; i <= end; i++) {
                                    placeShipOnGrid(ship, xCoordStart, i);
                                }
                                isValid = true;
                            } else {
                                player.printErrorMessage("There is already a ship.");
                            }
                            //ship is on the same row (horizontal placement)
                        } else if (yCoordStart == yCoordEnd && (xCoordEnd == xCoordStart + shiptype.getLength() - 1
                                || xCoordEnd == xCoordStart - shiptype.getLength() + 1)) {

                            //check first if all relevant Fields are free before starting placing ships
                            int start = Math.min(xCoordStart, xCoordEnd);
                            int end = Math.max(xCoordStart, xCoordEnd);

                            if (rowIsEmpty(yCoordStart, start, end)) {
                                //place ship on the grid
                                Ship ship = new Ship(shiptype); //new ship with current ship type
                                for (int i = start; i <= end; i++) {
                                    placeShipOnGrid(ship, i, yCoordStart);
                                }
                                isValid = true;
                            } else {
                                player.printErrorMessage("There is already a ship.");
                            }
                        } else {
                            player.printErrorMessage("Sorry, your ship cannot be placed.");
                        }
                    }
                    counter++;
                    //TODO temporarily display
                    Display d = new Display();
                    d.displayOceanGrid(this);
                }
            }
        }
    }

    private boolean columnIsEmpty(int col, int start, int end) {
        for (int i = start; i <= end; i++) {
            Field actual = grid[i][col];
            if (actual.getFieldState() == FieldState.SHIP) {
                return false;
            }
        }
        return true;
    }

    private boolean rowIsEmpty(int row, int start, int end) {
        for (int i = start; i <= end; i++) {
            Field actual = grid[row][i];
            if (actual.getFieldState() == FieldState.SHIP) {
                return false;
            }
        }
        return true;
    }

    //needed at the beginning to set the ship-fields on the grid
    public void placeShipOnGrid(Ship ship, int coordX, int coordY) {
        grid[coordY][coordX].setFieldState(FieldState.SHIP);
        grid[coordY][coordX].setShip(ship);
    }

    public void updateFieldState(int[] coordsXY) {
        // maybe i could try otherPlayer.shoot() here.
        //int[] coordsXY = player.shoot();
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
                updateFieldState(otherPlayer.shoot());
            }
        }
    }

    public Field[][] getGrid() {
        return grid;
    }
}

