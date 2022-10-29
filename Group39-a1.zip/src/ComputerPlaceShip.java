import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlaceShip implements PlaceBehaviour{
    @Override
    public int[] placeShip(int length) {
        System.out.println("Beep Boop. I am Computer. I shoot.");
        int startcoordX = (int)(Math.random() * 10);
        int startcoordY = (int)(Math.random() * 10);
        int endcoordX = 0;
        int endcoordY = 0;

        int horvert = ThreadLocalRandom.current().nextInt(0, 2);
        if (horvert==0) {
            endcoordX = startcoordX + length;
            endcoordY = startcoordY;
        } else {
            endcoordX = startcoordX;
            endcoordY = startcoordY + length;
        }

        if (endcoordX > 9) {
            endcoordX = startcoordX - length;
        }
        if (endcoordY > 9) {
            endcoordY = startcoordY - length;
        }
        return new int[] {startcoordX, startcoordY, endcoordX, endcoordY};
    }

}
