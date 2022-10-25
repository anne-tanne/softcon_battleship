import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Grid {
    int size = 10;
    Field[][] mygrid;
    public Grid() {
        mygrid = gridoffields();
    }

    private Field[][] gridoffields() {
        Field[][] TempList = new Field[10][10];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Field field = new Field(x, y, FieldState.EMPTY);
                TempList[y][x] = field;
            }
        }
        return TempList;
    }

    /*
    public void getShot(Player) {

        // Mep to translate the letter to an integer
        final Map<Character, Integer> map;
        map = new HashMap<>();
        // or map = new HashMap<Character, Integer> if you are using something before Java 7.
        map.put('A', 1); map.put('B', 2); map.put('C', 3); map.put('D', 4); map.put('E', 5);
        map.put('F', 6); map.put('G', 7); map.put('H', 8); map.put('I', 9); map.put('J', 10);

        // call the shoot function which returns the coordinates
        char x_char, int y = Player.shoot();

        // translate the coordinates
        int x = map.get(x_char);
        // select the Field which was shot at
        Field hitField = mygrid[y][x];

        // Print the result of the shot and change the FieldState of the shot Field
        switch (hitField.getFieldState()) {
            case EMPTY :
                hitField.setFieldState(FieldState.MISS);
                System.out.println("Bummer, that was a miss :(");
                break;
            case SHIP:
                hitField.setFieldState(FieldState.HIT);
                System.out.println("That was a hit, Nice !!!");
                break;
            case HIT:
            case MISS:
            case DESTROYED:
                System.out.println("You have already shot at this location!");
                getShot();
                break;
        }

    }

    public void getPlacement() {
        int[] a, int[] b = Player.setShips;

    }
    public void printOceanGrid() {
        System.out.println("===== OCEAN GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < size; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < size; col++) {
                // methode für field wie geprintet werden soll
                switch (mygrid[row][col].getFieldState()) {
                    case EMPTY :
                        System.out.print(" |");
                        break;
                    case HIT:
                        System.out.print("X|");
                        break;
                    case MISS:
                        System.out.print("o|");
                    case SHIP:
                        // get type von shiff mit id des feldes
                        System.out.print("S|");
                        break;
                    case DESTROYED:
                        System.out.print("X|");
                        break;
                }


            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
    }

    public void printTargetGrid() {
        System.out.println("===== Target GRID =====");
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        for (int row = 0; row < size; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < size; col++) {
                // methode für field wie geprintet werden soll
                switch (mygrid[row][col].getFieldState()) {
                    case EMPTY :
                        System.out.print(" |");
                        break;
                    case HIT:
                        System.out.print("X|");
                        break;
                    case MISS:
                        System.out.print("o|");
                    case SHIP:
                        System.out.print("X|");
                        break;
                    case DESTROYED:
                        // get type von shiff mit id des feldes
                        System.out.print("S|");
                        break;
                }


            }
            System.out.print(row + "\n");
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("  A B C D E F G H I J ");
    }

     */

}

