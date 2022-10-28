import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String shootInput(){
        System.out.println("Where do you want to attack? (i.e. A2): ");
        String attackedField = scanner.nextLine().toUpperCase();
        if (validateShootInput(attackedField)){
            return attackedField;
        }
        //TODO figure out how to handle wrong input(ideally call function again to correct mistake
        return "ERROR";
    }

    private static boolean validateShootInput(@NotNull String shootInput){
        if (shootInput.length() != 2) {
            System.out.println("Input must be exactly 2 characters long.");
            return false;
        } else {
            boolean valid = true;
            char pos1 = shootInput.charAt(0);
            if (pos1 != 'A' && pos1 != 'B' && pos1 != 'C' && pos1 != 'D' && pos1 != 'E' && pos1 != 'F' && pos1 != 'G' && pos1 != 'H' && pos1 != 'I' && pos1 != 'J'){
                System.out.println("First position must be a letter from A to J");
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
}
