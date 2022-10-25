public class Field {

    //TODO braucht es x und y überhaupt?

    private int x;
    private int y;
    private FieldState fieldState;
    private ShipType shipType;

    public Field(int x, int y, FieldState fieldState, ShipType shipType) {
        this.x = x;
        this.y = y;
        this.fieldState = fieldState;
        this.shipType = shipType;
    }

    public void setFieldState(FieldState fieldState) {
        this.fieldState = fieldState;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public FieldState getFieldState() {
        return fieldState;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}
