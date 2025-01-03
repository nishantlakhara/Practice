package low_level_design.parking_spot_1;

public interface TicketGenerator {

    Ticket generateTicket(ParkingSpot parkingSpot, Vehicle vehicle);
}
