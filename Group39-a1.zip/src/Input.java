import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    static String validShootInput;
    static String validShipPlacementInput;

    public static void shootInput(){
        System.out.println("Where do you want to attack? (i.e. A2): ");
        String attackedField = scanner.nextLine().toUpperCase();
        if (validateShootInput(attackedField)){
            validShootInput = attackedField;
        } else {
            shootInput();
        }
    }

    public static void placeShipInput(int length){
        System.out.println("Where do you want to place your ship with the length:" + length);
        String placedShipPosition = scanner.nextLine().toUpperCase();
        if (validateShipPlacementInput(placedShipPosition)){
            validShipPlacementInput = placedShipPosition;
        } else {
            placeShipInput(length);
        }
    }

    private static boolean validateShootInput(@NotNull String shootInput){
        if (shootInput.length() != 2) {
            System.out.println("Input must be exactly 2 characters long.");
            return false;
        } else {
            boolean valid = true;
            char pos1 = shootInput.charAt(0);
            if (!letterIsValid(pos1)){
                valid = false;
            }
            //TODO and <=9 ?
            if (!Character.isDigit(shootInput.charAt(1))){
                System.out.println("Second Position must be a digit.");
                valid = false;
            }
            return valid;
        }
    }

    private static boolean validateShipPlacementInput(@NotNull String placedShipPosition) {
        if (placedShipPosition.length() != 5){
            System.out.println("Input must be exactly 5 characters long.");
            return false;
        } else {
            boolean valid = true;

            char pos1 = placedShipPosition.charAt(0);
            char pos4 = placedShipPosition.charAt(3);

            if (!letterIsValid(pos1)){
                valid = false;
            }
            if (!Character.isDigit(placedShipPosition.charAt(1))){
                System.out.println("Second position of coordinate must be a digit.");
                valid = false;
            }
            if (placedShipPosition.charAt(2) != ','){
                System.out.println("Middle position must be a comma.");
                valid = false;
            }
            if (!letterIsValid(pos4)){
                valid = false;
            }
            if (!Character.isDigit(placedShipPosition.charAt(4))){
                System.out.println("Second position of coordinate must be a digit.");
                valid = false;
            }
            return valid;
        }
    }

    private static boolean letterIsValid(char pos) {
        if (pos != 'A' && pos != 'B' && pos != 'C' && pos != 'D' && pos != 'E' && pos != 'F' && pos != 'G' && pos != 'H' && pos != 'I' && pos != 'J'){
            System.out.println("First position of the coordinate must be a letter from A to J");
            return false;
        }
        return true;
    }
}
