public class Ship {

    private int lifeCounter;
    ShipType shipType;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.lifeCounter = this.shipType.getLength();
    }

    public void gotHit(){
        lifeCounter -= 1;
    }

    public Boolean isSunken() {
        return lifeCounter <= 0;
    }
}
