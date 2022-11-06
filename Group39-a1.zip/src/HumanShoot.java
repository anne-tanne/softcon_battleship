public class HumanShoot implements ShootBehaviour {

    @Override
    public int[] shoot() {
        System.out.println("Where do you want to attack? (i.e. A2): ");
        Input.shootInput();
        String attackedField = Input.validShootInput;
        String attackedXAsString = String.valueOf(attackedField.charAt(0));

        int attackedXCoord = convertXCoordToInt(attackedXAsString);
        int attackedYCoord = Integer.parseInt(String.valueOf(attackedField.charAt(1)));

        return new int[]{attackedXCoord, attackedYCoord};
    }

    @Override
    public void printShootMessage(String message) {
        System.out.println(message);
    }

    private int convertXCoordToInt(String attackedXCoord) {
        return switch (attackedXCoord) {
            // needs to be here in case the input is wrong. Code doesn't run without default case.
            default -> throw new IllegalArgumentException("Unexpected Input for X coordinate.");
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            case "I" -> 8;
            case "J" -> 9;
        };
    }
}
