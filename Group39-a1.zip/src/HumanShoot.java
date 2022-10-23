import java.util.ArrayList;
import java.util.Scanner;

public class HumanShoot implements ShootBehaviour{

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> validInputList;
    private final ArrayList<String> alreadyShotAtList;


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

    /*private HashMap<String, Integer> mapInputStrToInt(){
        HashMap<String, Integer> inputAsInt = new HashMap<>();
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (j == 0){inputAsInt.put("A" + i, Integer.parseInt("0" + i));}
                else if (j == 1){inputAsInt.put("B" + i, Integer.parseInt("1" + i));}
                else if (j == 2){inputAsInt.put("C" + i, Integer.parseInt("2" + i));}
                else if (j == 3){inputAsInt.put("D" + i, Integer.parseInt("3" + i));}
                else if (j == 4){inputAsInt.put("E" + i, Integer.parseInt("4" + i));}
                else if (j == 5){inputAsInt.put("F" + i, Integer.parseInt("5" + i));}
                else if (j == 6){inputAsInt.put("G" + i, Integer.parseInt("6" + i));}
                else if (j == 7){inputAsInt.put("H" + i, Integer.parseInt("7" + i));}
                else if (j == 8){inputAsInt.put("I" + i, Integer.parseInt("8" + i));}
                else {inputAsInt.put("J" + i, Integer.parseInt("9" + i));}
            }
        }
        //System.out.println(inputAsInt);
        return inputAsInt;
    }*/

    public HumanShoot(){
        this.validInputList = createValidInputList();
        this.alreadyShotAtList = new ArrayList<>();
    }

    @Override
    public void shoot(){
        /* implement Shootable interface with 2 shoot behaviours (1 for human, 1 for ai)*/
        System.out.println("Where do you want to attack? (i.e. A2): ");
        String attackedField = scanner.nextLine();
        /*checks if the Player input is contained in the validInputs ArrayList and makes it
        uppercase so it doesn't matter if the player entered it in lower or upper case*/
        if (validInputList.contains(attackedField.toUpperCase())){
            System.out.println("You attacked " + attackedField.toUpperCase() + "!");
            alreadyShotAtList.add(attackedField.toUpperCase());
            validInputList.remove(attackedField.toUpperCase());
        } else if (alreadyShotAtList.contains(attackedField.toUpperCase())){
            System.out.println("You already attacked " + attackedField.toUpperCase() + ". Attack a new field.");
            shoot();
        } else {
            System.out.println("Please enter a valid Input");
            shoot();
        }

    }
}
