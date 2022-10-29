import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlaceShip implements PlaceBehaviour {

    @Override
    public int[] placeShip(int length) {
        int startCoordX = (int) (Math.random() * 10);
        int startCoordY = (int) (Math.random() * 10);
        int endCoordX;
        int endCoordY;

        int horVert = ThreadLocalRandom.current().nextInt(0, 2);
        if (horVert == 0) {
            endCoordX = startCoordX + length;
            endCoordY = startCoordY;
        } else {
            endCoordX = startCoordX;
            endCoordY = startCoordY + length;
        }

        if (endCoordX > 9) {
            endCoordX = startCoordX - length;
        }
        if (endCoordY > 9) {
            endCoordY = startCoordY - length;
        }
        return new int[]{startCoordX, startCoordY, endCoordX, endCoordY};
    }
}
