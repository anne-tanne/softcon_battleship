public enum ShipType {
    CARRIER(6),
    BATTLESHIP(4),
    SUBMARINE(3),
    PATROL(2),
    NONE(0);

    private final int length;

    ShipType(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}

