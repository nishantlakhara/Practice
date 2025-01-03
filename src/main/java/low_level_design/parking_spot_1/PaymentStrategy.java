package low_level_design.parking_spot_1;

public interface PaymentStrategy {
    public Payment generatePayment(Ticket ticket);
}
