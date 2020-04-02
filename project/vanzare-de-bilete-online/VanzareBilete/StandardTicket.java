package VanzareBilete;

public class StandardTicket extends Ticket {
    final private float fee = 5;
    final private String type = "standard";

    public StandardTicket(float price, Event event) {
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
