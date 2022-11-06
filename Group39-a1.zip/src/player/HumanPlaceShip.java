package player;

import ship.ShipType;

import static utils.InputUtils.*;

public class HumanPlaceShip implements PlaceBehaviour {

    @Override
    public int[] placeShip(ShipType shiptype) {
        placeShipInput(shiptype.getLength(), shiptype.getSimplename());
        String placementCoords = validShipPlacementInput;
        String startcoordXString = String.valueOf(placementCoords.charAt(0));
        String endcoordXString = String.valueOf(placementCoords.charAt(3));

        int startcoordX = convertXCoordToInt(startcoordXString);
        int endcoordX = convertXCoordToInt(endcoordXString);
        int startcoordY = Integer.parseInt(String.valueOf(placementCoords.charAt(1)));
        int endcoordY = Integer.parseInt(String.valueOf(placementCoords.charAt(4)));

        return new int[]{startcoordX, startcoordY, endcoordX, endcoordY};
    }

    @Override
    public void printErrorMessage(String errormessage) {
        System.out.println(errormessage);
    }
}
