import java.util.*;

public class Problem8_ParkingLot {

    private String[] spots = new String[500];

    private int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public int park(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {
            index = (index + 1) % spots.length;
        }

        spots[index] = plate;

        return index;
    }

    public void exit(String plate) {

        for (int i = 0; i < spots.length; i++) {
            if (plate.equals(spots[i])) {
                spots[i] = null;
                break;
            }
        }
    }

    public static void main(String[] args) {

        Problem8_ParkingLot lot = new Problem8_ParkingLot();

        int spot = lot.park("KA01AB1234");

        System.out.println("Parked at spot: " + spot);

        lot.exit("KA01AB1234");
    }
}