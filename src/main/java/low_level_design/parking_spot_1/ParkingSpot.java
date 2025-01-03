package low_level_design.parking_spot_1;

public class ParkingSpot {
    private  String parkingLotId;
    private int distanceFromEntranceGate;
    private VehicleType vehicleType;
    private boolean available;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getDistanceFromEntranceGate() {
        return distanceFromEntranceGate;
    }

    public void setDistanceFromEntranceGate(int distanceFromEntranceGate) {
        this.distanceFromEntranceGate = distanceFromEntranceGate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
