public class Fleet {

    Ship[] ships;

    public Fleet() {

    }

    public boolean isFullySunken() {
        for (Ship ship : ships) {
            if (!ship.isSunken()) {
                return false;
            }
        }
        return true;
    }
}
