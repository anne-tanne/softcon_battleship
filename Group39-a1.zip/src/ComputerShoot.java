public class ComputerShoot implements ShootBehaviour{

    @Override
    public int[] shoot() {
        int randXCoord = (int)(Math.random() * 10);
        int randYCoord = (int)(Math.random() * 10);

        return new int[] {randXCoord, randYCoord};
    }

    @Override
    public void printShootMessage(String message) {
        //do nothing, computer doesn't have feelings
    }
}
