package low_level_design.parking_spot_1;

public class Main {

    public static void main(String[] args) {

        // 1.   The vehiicle arrives at thhe parking lot.
        Vehicle  vehicle  = new Vehicle();
        vehicle.setVehicleId("RJ27CD7976");
        vehicle.setVehicleType(VehicleType.TWO_WHEELER);

        // 2. The parking  manager assigns  a  parking  spot   to the vehicle owner   annd a ticket.
        ParkingManager parkingManager =  new ParkingSpotManager();
        ParkingSpot parkingSpot = parkingManager.findParkingSpot(vehicle);
        Ticket ticket = parkingManager.bookSpotAndGenerateTicket(parkingSpot, vehicle);

        // 3. After some time the vehhicle exxits  the gate. Calculate the payment.
        Payment payment = parkingManager.calculatePayment(ticket);
        parkingManager.acknowledgePaymentAndFreeParkinngSpot(payment);

    }


}
