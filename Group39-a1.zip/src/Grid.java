public class Grid {

    private final static int GRID_SIZE = 10;
    private final Field[][] grid;

    public Grid() {
        grid = createEmptyGrid();
    }

    private Field[][] createEmptyGrid() {
        Field[][] fieldList = new Field[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Field field = new Field(row, col, FieldState.EMPTY, ShipType.NONE);
                fieldList[col][row] = field;
            }
        }
        return fieldList;
    }

    //needed at the beginning to set the ship-fields on the grid
    public void placeShipOnGrid(Ship ship, int coordX, int coordY) {
        grid[coordX][coordY].setFieldState(FieldState.SHIP);
        grid[coordX][coordY].setShipType(ship.shipType);
    }

    public void printGrid() {
        //TODO distinguish between ocean grid and target grid (I don't know how yet)
        System.out.println("====== OCEAN GRID ======");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(evaluatePrintSymbol(grid[row][col].getFieldState(), grid[row][col].getShipType()));
            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
        System.out.println("=======================");
    }

    private String evaluatePrintSymbol(FieldState fieldState, ShipType shipType) {
        return switch (fieldState) {
            case EMPTY -> " |";
            case HIT -> "X|";
            case MISS -> "o|";
            case SHIP -> "X|";
            case SUNKEN_SHIP -> evaluatePrintSymbolShip(shipType);
        };
    }

    private String evaluatePrintSymbolShip(ShipType shipType) {
        return switch (shipType) {
            case CARRIER -> "C|";
            case BATTLESHIP -> "B|";
            case SUBMARINE -> "S|";
            case PATROL -> "P|";
            case NONE -> " |"; //shouldn't get here
        };
    }

    public void updateFieldState() {

        //TODO This is temporarily hardcoded. A method in Player or wherever should return the coordinates.
        //TODO so player has to be a property of Grid
        int coordX = 7;
        int coordY = 8;

        // select the Field which was shot at
        Field hitField = grid[coordX][coordY];

        //get actual FieldState of the hit Field and update its state
        switch (hitField.getFieldState()) {
            case EMPTY:
                hitField.setFieldState(FieldState.MISS);
                System.out.println("Bummer, that was a miss :(");
                break;
            case SHIP:
                hitField.setFieldState(FieldState.HIT);
                System.out.println("That was a hit, Nice !!!");
                break;
            case HIT:
                //TODO
                break;
            case MISS:
                //TODO
                break;
            case SUNKEN_SHIP:
                //TODO figure out if ship is sunken
                System.out.println("You have already shot at this location!");
                break;
        }
        printGrid();
    }

    /*
    public void getShot(Player) {

        // Mep to translate the letter to an integer
        final Map<Character, Integer> map;
        map = new HashMap<>();
        // or map = new HashMap<Character, Integer> if you are using something before Java 7.
        map.put('A', 1); map.put('B', 2); map.put('C', 3); map.put('D', 4); map.put('E', 5);
        map.put('F', 6); map.put('G', 7); map.put('H', 8); map.put('I', 9); map.put('J', 10);

        // call the shoot function which returns the coordinates
        char x_char, int y = Player.shoot();

        // translate the coordinates
        int x = map.get(x_char);
        // select the Field which was shot at
        Field hitField = mygrid[y][x];

        // Print the result of the shot and change the FieldState of the shot Field
        switch (hitField.getFieldState()) {
            case EMPTY :
                hitField.setFieldState(FieldState.MISS);
                System.out.println("Bummer, that was a miss :(");
                break;
            case SHIP:
                hitField.setFieldState(FieldState.HIT);
                System.out.println("That was a hit, Nice !!!");
                break;
            case HIT:
            case MISS:
            case DESTROYED:
                System.out.println("You have already shot at this location!");
                getShot();
                break;
        }

    }

    public void getPlacement() {
        int[] a, int[] b = Player.setShips;

    }
    public void printOceanGrid() {
        System.out.println("===== OCEAN GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < size; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < size; col++) {
                // methode für field wie geprintet werden soll
                switch (mygrid[row][col].getFieldState()) {
                    case EMPTY :
                        System.out.print(" |");
                        break;
                    case HIT:
                        System.out.print("X|");
                        break;
                    case MISS:
                        System.out.print("o|");
                    case SHIP:
                        // get type von shiff mit id des feldes
                        System.out.print("S|");
                        break;
                    case DESTROYED:
                        System.out.print("X|");
                        break;
                }


            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
    }

    public void printTargetGrid() {
        System.out.println("===== Target GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < size; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < size; col++) {
                // methode für field wie geprintet werden soll
                switch (mygrid[row][col].getFieldState()) {
                    case EMPTY :
                        System.out.print(" |");
                        break;
                    case HIT:
                        System.out.print("X|");
                        break;
                    case MISS:
                        System.out.print("o|");
                    case SHIP:
                        System.out.print("X|");
                        break;
                    case DESTROYED:
                        // get type von shiff mit id des feldes
                        System.out.print("S|");
                        break;
                }


            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
    }

     */

}

