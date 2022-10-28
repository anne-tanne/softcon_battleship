public enum ShipTypeExperimental {
    CARRIER(6),
    BATTLESHIP(4),
    SUBMARINE(3),
    PATROL(2),
    NONE(0);

    private final int length;

    ShipTypeExperimental(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}

