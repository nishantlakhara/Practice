package low_level_design.parking_spot_1;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Long entranceTime;

    public Ticket(String ticketId, Vehicle vehicle, VehicleType vehicleType, Long entranceTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.entranceTime = entranceTime;
    }
}
