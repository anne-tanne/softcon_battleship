public class Display {

    private final static int GRID_SIZE = 10;

    public Display() {

    }

    //TODO constructor

    //displays the results of the player's own shots
    public void displayTargetGrid(Grid grid) {
        System.out.println("===== TARGET GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(evaluatePrintSymbolTarget(
                        grid.getGrid()[row][col].getFieldState(),
                        grid.getGrid()[row][col].getShipType())
                );
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
                System.out.print(evaluatePrintSymbolOcean(
                        grid.getGrid()[row][col].getFieldState(),
                        grid.getGrid()[row][col].getShipType())
                );
            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
        System.out.println("=======================");
    }

    private String evaluatePrintSymbolTarget(FieldState fieldState, ShipType shipType) {
        return switch (fieldState) {
            case EMPTY, SHIP -> " |";
            case HIT -> "X|";
            case MISS -> "o|";
            case SUNKEN_SHIP -> evaluatePrintSymbolShip(shipType);
        };
    }

    private String evaluatePrintSymbolOcean(FieldState fieldState, ShipType shipType) {
        return switch (fieldState) {
            case EMPTY -> " |";
            case HIT, SUNKEN_SHIP -> "X|";
            case MISS -> "o|";
            case SHIP -> evaluatePrintSymbolShip(shipType);
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
}
