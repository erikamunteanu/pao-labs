package VanzareBilete;

public class Ticket {
    protected float price;
    protected Event event;

    public Ticket(float price, Event event) {
        this.price = price;
        this.event = event;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
