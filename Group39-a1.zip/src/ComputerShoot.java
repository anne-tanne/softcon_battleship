public class ComputerShoot implements ShootBehaviour{

    @Override
    public int[] shoot() {
        //System.out.println("Beep Boop. I am Computer. I shoot.");
        int randXCoord = (int)(Math.random() * 10);
        int randYCoord = (int)(Math.random() * 10);
        //System.out.println("Computer attacked field " + randXCoord+randYCoord);

        return new int[] {randXCoord, randYCoord};
    }

    @Override
    public void printShootMessage(String message) {
        //do nothing, computer doesn't have feelings
    }
}
