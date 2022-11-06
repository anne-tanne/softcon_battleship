package player;

import static utils.InputUtils.*;

public class HumanShoot implements ShootBehaviour {

    @Override
    public int[] shoot() {
        System.out.println("Where do you want to attack? (i.e. A2): ");
        shootInput();
        String attackedField = validShootInput;
        String attackedXAsString = String.valueOf(attackedField.charAt(0));

        int attackedXCoord = convertXCoordToInt(attackedXAsString);
        int attackedYCoord = Integer.parseInt(String.valueOf(attackedField.charAt(1)));

        return new int[]{attackedXCoord, attackedYCoord};
    }

    @Override
    public void printShootMessage(String message) {
        System.out.println(message);
    }
}
