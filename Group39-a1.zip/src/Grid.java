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
                fieldList[col][row] = field;
            }
        }
        return fieldList;
    }

    //needed at the beginning to set the ship-fields on the grid
    public void placeShipOnGrid(Ship ship, int coordX, int coordY) {
        grid[coordX][coordY].setFieldState(FieldState.SHIP);
        grid[coordX][coordY].setShip(ship);
    }

    public void updateFieldState(int[] coordsXY) {
        int coordX = (int) Array.get(coordsXY, 0);
        int coordY = (int) Array.get(coordsXY, 1);

        // select the Field which was shot at
        Field hitField = grid[coordX][coordY];

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

