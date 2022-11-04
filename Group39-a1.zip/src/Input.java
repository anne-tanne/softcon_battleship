import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    static String validShootInput;
    static String validShipPlacementInput;

    public static void shootInput() {
        String attackedField = scanner.nextLine().toUpperCase();
        if (validateShootInput(attackedField)) {
            validShootInput = attackedField;
        } else {
            shootInput();
        }
    }

    public static void placeShipInput(int length, String simplename) {
        System.out.println("Where do you want to place your ship " + simplename + " with the length " + length + "? (i.e. A0,A2)");
        String placedShipPosition = scanner.nextLine().toUpperCase();
        if (validateShipPlacementInput(placedShipPosition)) {
            validShipPlacementInput = placedShipPosition;
        } else {
            placeShipInput(length, simplename);
        }
    }

    private static boolean validateShootInput(String shootInput) {
        assert shootInput != null;
        if (shootInput.length() != 2) {
            System.out.println("Input must be exactly 2 characters long.");
            return false;
        } else {
            boolean valid = true;
            char pos1 = shootInput.charAt(0);
            if (letterIsInvalid(pos1)) {
                valid = false;
            }
            if (!Character.isDigit(shootInput.charAt(1))) {
                System.out.println("Second Position must be a digit.");
                valid = false;
            }
            return valid;
        }
    }

    // todo design by contract
    private static boolean validateShipPlacementInput(String placedShipPosition) {
        if (placedShipPosition.length() != 5) {
            System.out.println("Input must be exactly 5 characters long.");
            return false;
        } else {
            boolean valid = true;

            char pos1 = placedShipPosition.charAt(0);
            char pos4 = placedShipPosition.charAt(3);

            if (letterIsInvalid(pos1)) {
                valid = false;
            }
            if (!Character.isDigit(placedShipPosition.charAt(1))) {
                System.out.println("Second position of the coordinate must be a digit.");
                valid = false;
            }
            if (placedShipPosition.charAt(2) != ',') {
                System.out.println("Values must be separated by a comma.");
                valid = false;
            }
            if (letterIsInvalid(pos4)) {
                valid = false;
            }
            if (!Character.isDigit(placedShipPosition.charAt(4))) {
                System.out.println("Second position of the coordinate must be a digit.");
                valid = false;
            }
            return valid;
        }
    }

    private static boolean letterIsInvalid(char pos) {
        if (pos != 'A' && pos != 'B' && pos != 'C' && pos != 'D' && pos != 'E' && pos != 'F' && pos != 'G' && pos != 'H' && pos != 'I' && pos != 'J') {
            System.out.println("First position of the the coordinate must be a letter from A to J");
            return true;
        }
        return false;
    }
}
