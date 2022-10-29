import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlaceShip implements PlaceBehaviour {

    @Override
    public int[] placeShip(ShipType shiptype) {
        int startCoordX = (int) (Math.random() * 10);
        int startCoordY = (int) (Math.random() * 10);
        int endCoordX;
        int endCoordY;

        int horVert = ThreadLocalRandom.current().nextInt(0, 2);
        if (horVert == 0) {
            endCoordX = startCoordX + shiptype.getLength() - 1;
            endCoordY = startCoordY;
        } else {
            endCoordX = startCoordX;
            endCoordY = startCoordY + shiptype.getLength() - 1;
        }

        if (endCoordX > 9) {
            endCoordX = startCoordX - shiptype.getLength() + 1;
        }
        if (endCoordY > 9) {
            endCoordY = startCoordY - shiptype.getLength() + 1;
        }
        return new int[]{startCoordX, startCoordY, endCoordX, endCoordY};
    }

    @Override
    public void printErrorMessage(String errormessage) {
        //do nothing
    }
}
