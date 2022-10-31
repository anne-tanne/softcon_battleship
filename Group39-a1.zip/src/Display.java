public class Display {

    private final static int GRID_SIZE = 10;

    public Display() {
    }

    //displays the results of the player's own shots
    public void displayTargetGrid(Grid grid) {
        System.out.println("===== TARGET GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < GRID_SIZE; col++) {
                switch (grid.getGrid()[row][col].getFieldState()) {
                    case EMPTY, SHIP -> System.out.print(" |");
                    case HIT -> System.out.print("X|");
                    case MISS -> System.out.print("o|");
                    case SUNKEN_SHIP -> System.out.print(evaluatePrintSymbolShip(grid.getGrid()[row][col].getShip().shipType));
                }
            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
        System.out.println("=======================");
    }

    //displays the player's own ships and the shots called by the opponent
    public void displayOceanGrid(Grid grid) {
        System.out.println("===== OCEAN GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < GRID_SIZE; col++) {
                switch (grid.getGrid()[row][col].getFieldState()) {
                    case EMPTY -> System.out.print(" |");
                    case HIT, SUNKEN_SHIP -> System.out.print("X|");
                    case MISS -> System.out.print("o|");
                    case SHIP -> System.out.print(evaluatePrintSymbolShip(grid.getGrid()[row][col].getShip().shipType));
                }
            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
        System.out.println("=======================");
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
}
