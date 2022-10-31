public class Ship {

    private final ShipType shipType;
    private int lifeCounter;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.lifeCounter = this.shipType.getLength();
    }

    public void gotHit() {
        lifeCounter -= 1;
    }

    public Boolean isSunken() {
        return lifeCounter <= 0;
    }

    public ShipType getShipType() {
        return shipType;
    }
}
