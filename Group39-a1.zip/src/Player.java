public class Player {

    public ShootBehaviour shootBehaviour;

    public int[] shoot(){
        return shootBehaviour.shoot();
    }

    //public void setShootBehaviour(ShootBehaviour newShootBehaviour){
    //    shootBehaviour = newShootBehaviour;
    //}


    //maybe helpful for translation:
    /*// Map to translate the letter to an integer
    final Map<Character, Integer> map;
    map = new HashMap<>();
    // or map = new HashMap<Character, Integer> if you are using something before Java 7.
        map.put('A', 1); map.put('B', 2); map.put('C', 3); map.put('D', 4); map.put('E', 5);
        map.put('F', 6); map.put('G', 7); map.put('H', 8); map.put('I', 9); map.put('J', 10);

    // call the shoot function which returns the coordinates
    char x_char, int y = Player.shoot();

    // translate the coordinates
    int x = map.get(x_char);*/
}
