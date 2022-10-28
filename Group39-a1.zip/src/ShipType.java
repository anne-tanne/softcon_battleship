public enum ShipType {
    CARRIER(1, 6, "Carrier"),
    BATTLESHIP(2, 4, "Battleship"),
    SUBMARINE(3, 3, "Submarine"),
    PATROL(4, 2, "Patrol"),
    NONE(0, 0, "");

    private final int length;
    private final int number;
    private final String simplename;

    ShipType(int number, int length, String simplename) {
        this.number = number; //how often is this ship placed on the board
        this.length = length; //how many fields
        this.simplename = simplename; //simple name of ship type
    }

    public int getLength() {
        return length;
    }

    public int getNumber() {
        return number;
    }

    public String getSimplename() {
        return simplename;
    }
}

