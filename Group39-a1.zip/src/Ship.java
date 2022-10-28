public class Ship {

    private int hitCounter = 0;
    ShipType shipType;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
    }

    public void gotHit(){
        hitCounter += 1;
    }

    public Boolean isSunken() {
        return hitCounter != shipType.getLength();
    }
}
