public class HumanPlaceShip implements PlaceBehaviour {


    @Override
    public int[] placeShip(int length) {
        Input.placeShipInput(length);
        String placementCoords = Input.validShipPlacementInput;
        String startcoordXString = String.valueOf(placementCoords.charAt(0));
        String endcoordXString = String.valueOf(placementCoords.charAt(3));

        int startcoordX = convertXCoordToInt(startcoordXString);
        int endcoordX = convertXCoordToInt(endcoordXString);
        int startcoordY = Integer.parseInt(String.valueOf(placementCoords.charAt(1)));
        int endcoordY = Integer.parseInt(String.valueOf(placementCoords.charAt(4)));

        return new int[]{startcoordX, startcoordY, endcoordX, endcoordY};
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
