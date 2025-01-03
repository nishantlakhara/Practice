package low_level_design.parking_spot_1;

public interface ParkingManager {
    public ParkingSpot findParkingSpot(Vehicle vehicle);

    Ticket bookSpotAndGenerateTicket(ParkingSpot parkingSpot, Vehicle vehicle);

    Payment calculatePayment(Ticket ticket);

    void acknowledgePaymentAndFreeParkinngSpot(Payment payment);
}
