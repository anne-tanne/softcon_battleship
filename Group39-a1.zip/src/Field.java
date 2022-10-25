public class Field {
    private int x;
    private int y;
    private FieldState fieldState;
    public Field(int x, int y, FieldState fieldState) {
        this.x = x;
        this.y = y;
        this.fieldState = fieldState;
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
}
