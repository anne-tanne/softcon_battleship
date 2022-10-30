import java.lang.reflect.Array;

public class Grid {

    private final static int GRID_SIZE = 10;
    private final Player player;
    private final Player otherPlayer;
    private final Fleet fleet;
    private final Field[][] grid;

    public Grid(Player player, Player otherPlayer, Fleet fleet) {
        grid = createEmptyGrid();
        this.player = player;
        this.otherPlayer = otherPlayer;
        this.fleet = fleet;
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
        for (Ship ship : fleet.getShips()) {
            boolean isValid = false;
            while (!isValid) {
                // get user input
                int[] coords = player.placeShip(ship.shipType);

                int xCoordStart = coords[0];
                int yCoordStart = coords[1];
                int xCoordEnd = coords[2];
                int yCoordEnd = coords[3];

                //ship is on the same column (vertical placement)
                if (xCoordStart == xCoordEnd && (yCoordEnd == yCoordStart + ship.shipType.getLength() - 1
                        || yCoordEnd == yCoordStart - ship.shipType.getLength() + 1)) {

                    //check first if all relevant Fields are free before starting placing ships
                    int start = Math.min(yCoordStart, yCoordEnd);
                    int end = Math.max(yCoordStart, yCoordEnd);

                    if (columnIsEmpty(xCoordStart, start, end)) {
                        //place ship on the grid
                        for (int i = start; i <= end; i++) {
                            placeShipOnGrid(ship, xCoordStart, i);
                        }
                        isValid = true;
                    } else {
                        player.printErrorMessage("There is already a ship.");
                    }
                    //ship is on the same row (horizontal placement)
                } else if (yCoordStart == yCoordEnd && (xCoordEnd == xCoordStart + ship.shipType.getLength() - 1
                        || xCoordEnd == xCoordStart - ship.shipType.getLength() + 1)) {

                    //check first if all relevant Fields are free before starting placing ships
                    int start = Math.min(xCoordStart, xCoordEnd);
                    int end = Math.max(xCoordStart, xCoordEnd);

                    if (rowIsEmpty(yCoordStart, start, end)) {
                        //place ship on the grid
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
            //TODO temporarily display
            Display d = new Display();
            d.displayOceanGrid(this);
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
                hitField.getShip().gotHit();
                if (hitField.getShip().isSunken()) {
                    destroyShip(hitField.getShip());
                    System.out.println("That was a hit, the ship is destroyed !!!");
                } else {
                    hitField.setFieldState(FieldState.HIT);
                    System.out.println("That was a hit, Nice !!!");
                }
            }
            case HIT, MISS, SUNKEN_SHIP -> {
                System.out.println("You have already shot at this location!");
                updateFieldState(otherPlayer.shoot());
            }
        }
    }

    private void destroyShip(Ship ship) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[col][row].getShip() == ship) {
                    grid[col][row].setFieldState(FieldState.SUNKEN_SHIP);
                }
            }
        }
    }

    public Field[][] getGrid() {
        return grid;
    }
}