package VanzareBilete;

public class PremiumTicket extends Ticket {
    final private float fee = 30;
    final private String type = "Premium";

    public PremiumTicket(float price, Event event) {
        super(price, event);
    }

    public float getFee() {
        return fee;
    }

    public String getType() {
        return type;
    }

    @Override
    public void setPrice(float price) {
        float newPrice = price + price*(fee/100.0f);
        super.setPrice(newPrice);
    }
}
