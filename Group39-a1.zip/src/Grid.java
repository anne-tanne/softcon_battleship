import java.lang.reflect.Array;

public class Grid {

    private final static int GRID_SIZE = 10;
    private Player player;
    Field[][] grid;

    public Grid(Player player) {
        grid = createEmptyGrid();
        this.player = player;
    }

    private Field[][] createEmptyGrid() {
        Field[][] fieldList = new Field[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Field field = new Field(FieldState.EMPTY, new Ship(ShipType.NONE));
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
            case HIT, MISS, SUNKEN_SHIP ->
                //TODO shoot again
                    System.out.println("You have already shot at this location!");
        }
    }

    public Field[][] getGrid() {
        return grid;
    }

}

