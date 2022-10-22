import java.util.*;
public class Player {
    //Set that contains all the valid attack inputs

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> createValidInputList(){
        ArrayList<String> validInputs = new ArrayList<String>();
        for (int row=0; row<10; row++){
            for (int col=0; col<10; col++){
                if (col == 0){validInputs.add("A" + row);}
                else if (col == 1){validInputs.add("B" + row);}
                else if (col == 2){validInputs.add("C" + row);}
                else if (col == 3){validInputs.add("D" + row);}
                else if (col == 4){validInputs.add("E" + row);}
                else if (col == 5){validInputs.add("F" + row);}
                else if (col == 6){validInputs.add("G" + row);}
                else if (col == 7){validInputs.add("H" + row);}
                else if (col == 8){validInputs.add("I" + row);}
                else {validInputs.add("J" + row);}
            }
        }
        //System.out.println(validInputs);
        return validInputs;
    }
    public void shoot(){
        /* implement Shootable interface with 2 shoot behaviours (1 for human, 1 for ai)*/
        System.out.println("Where do you want to attack? (i.e. A2): ");
        String attackedField = scanner.nextLine();
        /*checks if the Player input is contained in the validInputs ArrayList and makes it
        uppercase so it doesn't matter if the player entered it in lower or upper case*/
        if (createValidInputList().contains(attackedField.toUpperCase())){
            System.out.println("You attacked " + attackedField.toUpperCase() + "!");
        } else {
            System.out.println("Please enter a valid Input");
            shoot();
        }

    }
}
