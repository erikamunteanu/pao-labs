package VanzareBilete;

public class Event {
    protected Band band;
    protected Location location;
    protected Date date;

    public Event(Band band, Location location, Date date) {
        this.band = band;
        this.location = location;
        this.date = date;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String showEvent() {
        return this.band.getBandName() + " | " + this.date.getDate() + " | " + this.location.getLocation();
     }
}
