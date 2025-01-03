package low_level_design.parking_spot_1;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class ParkingNearestSpotStrategy implements ParkingStrategy
{
    private List<ParkingSpot> parkingSpotList;

    // Data  structure to  quickly identify  avaiilable parkiing spot near  entrance gate.
    private TreeSet<ParkingSpot> parkingSpotTreeSet;

    public ParkingNearestSpotStrategy(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
        populateParkingSpotTreeSet(parkingSpotList);
    }

    // Algorithm
    private void populateParkingSpotTreeSet(List<ParkingSpot> parkingSpotList) {

    }

    @Override
    public ParkingSpot findSpot(Vehicle vehicle) {
        return null;
    }
}
