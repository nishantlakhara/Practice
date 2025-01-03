package low_level_design.parking_spot_1;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager implements  ParkingManager {

    private List<ParkingSpot> parkingSpotList = new ArrayList<>();
    private ParkingStrategy parkingStrategy;
    private TicketGenerator ticketGenerator;
    private PaymentStrategy paymentStrategy;

    public ParkingSpotManager() {
    }

    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        return parkingStrategy.findSpot(vehicle);
    }

    @Override
    public Ticket bookSpotAndGenerateTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.setAvailable(false);
        removeFromParkingSpotList(parkingSpot);
        return ticketGenerator.generateTicket(parkingSpot, vehicle);
    }

    @Override
    public Payment calculatePayment(Ticket ticket) {
        Payment payment = paymentStrategy.generatePayment(ticket);


        return payment;
    }

    @Override
    public void acknowledgePaymentAndFreeParkinngSpot(Payment payment) {
        acknowwledgePayment(payment);
        addParkingSpotToAvailableList(payment.getParkingSpot());
    }

    private void addParkingSpotToAvailableList(ParkingSpot parkingSpot) {
    }

    private void acknowwledgePayment(Payment payment) {

    }

    private void removeFromParkingSpotList(ParkingSpot parkingSpot) {

    }
}
