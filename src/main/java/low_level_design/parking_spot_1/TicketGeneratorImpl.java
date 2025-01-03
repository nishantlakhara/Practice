package low_level_design.parking_spot_1;

import java.util.UUID;

public class TicketGeneratorImpl implements TicketGenerator {
    @Override
    public Ticket generateTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, parkingSpot.getVehicleType(), System.currentTimeMillis());
        return ticket;
    }
}
