public class Field {

    private FieldState fieldState;
    private Ship ship;

    public Field(FieldState fieldState, Ship ship) {
        this.fieldState = fieldState;
        this.ship = ship;
    }

    public void setFieldState(FieldState fieldState) {
        this.fieldState = fieldState;
    }

    public FieldState getFieldState() {
        return fieldState;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
