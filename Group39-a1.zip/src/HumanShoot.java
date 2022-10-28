import java.util.ArrayList;
import java.util.Scanner;

public class HumanShoot implements ShootBehaviour{

    //TODO figure out how to handle null (since shootInput can return null or possibly another "incorrect" value
    @Override
    public int[] shoot(){
        Input.shootInput();
        String attackedField = Input.validShootInput;
        String attackedXAsString = String.valueOf(attackedField.charAt(0));

        int attackedXCoord = convertXCoordToInt(attackedXAsString);
        int attackedYCoord = Integer.parseInt(String.valueOf(attackedField.charAt(1)));

        return new int[]{attackedXCoord, attackedYCoord};

        /*if (validInputList.contains(attackedField.toUpperCase())){
            System.out.println("You attacked " + attackedField.toUpperCase() + "!");
            alreadyShotAtList.add(attackedField.toUpperCase());
            validInputList.remove(attackedField.toUpperCase());
        } else if (alreadyShotAtList.contains(attackedField.toUpperCase())){
            System.out.println("You already attacked " + attackedField.toUpperCase() + ". Attack a new field.");
            shoot();
        } else {
            System.out.println("Please enter a valid Input");
            shoot();
        } */

    }
    private int convertXCoordToInt(String attackedXCoord){
        return switch(attackedXCoord){
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
