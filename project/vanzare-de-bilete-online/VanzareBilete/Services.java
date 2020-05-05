package VanzareBilete;

import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;

public class Services {

    DataFiles data = DataFiles.getInstance();
    Audit audit = Audit.getInstance();

    public Services() {
    }

    public ArrayList<Band> loadBands () throws IOException {
        ArrayList<Band> bands = data.readBands();
        DataFiles.writeBands(bands);
        return bands;
    }

    public ArrayList<Location> loadLocations () throws IOException {
        ArrayList<Location> locations = data.readLocations();
        DataFiles.writeLocations(locations);
        return locations;
    }

    public ArrayList<Date> loadDates () throws IOException {
        ArrayList<Date> dates = data.readDates();
        DataFiles.writeDates(dates);
        return dates;
    }

    public ArrayList<Client> loadClient () throws IOException {
        ArrayList<Client> clients = data.readClient();
        DataFiles.writeClient(clients);
        return clients;
    }

    public ArrayList<Event> generateEvents(ArrayList<Band> bands, ArrayList<Location> locations, ArrayList<Date> dates) {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event(bands.get(0), locations.get(0), dates.get(0)));
        events.add(new Event(bands.get(1), locations.get(0), dates.get(0)));
        events.add(new Event(bands.get(0), locations.get(1), dates.get(1)));
        events.add(new Event(bands.get(1), locations.get(2), dates.get(2)));
        events.add(new Event(bands.get(0), locations.get(3), dates.get(3)));
        events.add(new Event(bands.get(0), locations.get(4), dates.get(4)));
        events.add(new Event(bands.get(0), locations.get(5), dates.get(5)));
        events.add(new Event(bands.get(1), locations.get(4), dates.get(4)));
        events.add(new Event(bands.get(0), locations.get(6), dates.get(6)));
        events.add(new Event(bands.get(0), locations.get(7), dates.get(7)));
        events.add(new Event(bands.get(1), locations.get(6), dates.get(8)));
        return events;
    }

    public ArrayList<Ticket> generateTickets(ArrayList<Event> events) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket(160, events.get(0)));
        tickets.add(new Ticket(120, events.get(1)));
        tickets.add(new Ticket(140, events.get(2)));
        tickets.add(new Ticket(110, events.get(3)));
        tickets.add(new Ticket(150, events.get(4)));
        tickets.add(new Ticket(150, events.get(5)));
        tickets.add(new Ticket(150, events.get(6)));
        tickets.add(new Ticket(130, events.get(7)));
        tickets.add(new Ticket(170, events.get(8)));
        tickets.add(new Ticket(145, events.get(9)));
        tickets.add(new Ticket(130, events.get(10)));
        return tickets;
    }

    public void listNoOfEvents(ArrayList<Event> e) {
        audit.action("Getting total number of events");
        System.out.println(e.size());

    }

    public void listNoOfBands(ArrayList<Band> b) {
        audit.action("Getting total number of bands");
        System.out.println(b.size());
    }

    private void listEvent(Event e) {
        System.out.println(e.showEvent());
    }

    public void listAllEvents(ArrayList<Event> e) {
        audit.action("Listing events");
        for (Event i : e) {
            listEvent(i);
        }
    }

    public void listAllBands(ArrayList<Band> b) {
        audit.action("Listing bands");
        for (Band i : b) {
            System.out.println(i.getName());
        }
    }

    public void searchEventsByCountry(ArrayList<Event> e, String g) {
        boolean v = false;
        for (Event i : e) {
            if (i.location.getCountry().equals(g)) {
                listEvent(i);
                v = true;
            }
        }
        audit.action("Searching events by country");
        if (!v) {
            System.out.println("There aren't any events in " + g);
        }
    }

    public ArrayList<Event> getEventsByCountry(ArrayList<Event> e, String g) {
        ArrayList<Event> ev = new ArrayList<Event>();
        for (Event i : e) {
            if (i.location.getCountry().equals(g)) {
                ev.add(i);
                listEvent(i);
            }
        }
        audit.action("Getting events by country");
        return ev;
    }

    public void searchEventsByCity(ArrayList<Event> e, String g) {
        boolean v = false;
        for (Event i : e) {
            if (i.location.getCity().equals(g)) {
                listEvent(i);
                v = true;
            }
        }
        audit.action("Searching events by city");
        if (!v) {
            System.out.println("There aren't any events in " + g);
        }
    }

    public ArrayList<Event> getEventsByCity(ArrayList<Event> e, String g) {
        ArrayList<Event> ev = new ArrayList<Event>();
        for (Event i : e) {
            if (i.location.getCity().equals(g)) {
                ev.add(i);
                listEvent(i);
            }
        }
        audit.action("Getting events by city");
        return ev;
    }

    public void searchEventsByGenre(ArrayList<Event> e, String g) {
        boolean v = false;
        for (Event i : e) {
            if (i.band.getGenre().equals(g)) {
                listEvent(i);
                v = true;
            }
        }
        audit.action("Searching events by genre");
        if (!v) {
            System.out.println("There aren't any " + g + " events");
        }
    }

    public ArrayList<Event> getEventsByGenre(ArrayList<Event> e, String g) {
        ArrayList<Event> ev = new ArrayList<>();
        for (Event i : e) {
            if (i.band.getGenre().equals(g)) {
                ev.add(i);
                listEvent(i);
            }
        }
        audit.action("Getting events by genre");
        return ev;
    }

    public void searchEventsByDate(ArrayList<Event> e, Date d) {
        boolean v = false;
        for (Event i : e) {
            if (i.date.getDay() == d.day && i.date.getMonth() == d.month && i.date.getYear() == d.year) {
                listEvent(i);
                v = true;
            }
        }
        audit.action("Searching events by date");
        if (!v) {
            System.out.println("There aren't any events on " + d);
        }
    }

    public ArrayList<Event> getEventsByDate(ArrayList<Event> e, Date d) {
        ArrayList<Event> ev = new ArrayList<Event>();
        for (Event i : e) {
            if (i.date.getDay() == d.day && i.date.getMonth() == d.month && i.date.getYear() == d.year) {
                ev.add(i);
                listEvent(i);
            }
        }
        audit.action("Getting events by date");
        return ev;
    }

    public void searchEventsByBandName(ArrayList<Event> e, String b) {
        boolean v = false;
        for (Event i : e) {
            if (i.band.getName().equals(b)) {
                listEvent(i);
                v = true;
            }
        }
        audit.action("Searching events by band's name");
        if (!v) {
            System.out.println("There aren't any events by " + b);
        }
    }

    public ArrayList<Event> getEventsByBandName(ArrayList<Event> e, String b) {
        ArrayList<Event> ev = new ArrayList<Event>();
        for (Event i : e) {
            if (i.band.getName().equals(b)) {
                ev.add(i);
                listEvent(i);
            }
        }
        audit.action("Getting events by band's name");
        return ev;
    }

    public void seeTicketsForEvent(ArrayList<Ticket> t, Event e) {
        for (Ticket i : t) {
            if (i.getEvent() == e) {
                StandardTicket x = new StandardTicket(i.getPrice(), e);
                Ticket aux = x;
                StandardTicket st = (StandardTicket) aux;
                st.setPrice(st.getPrice());
                System.out.println("Standard Ticket: " + st.getPrice() + "$");
            }
        }
        for (Ticket i : t) {
            if (i.getEvent() == e) {
                PremiumTicket x = new PremiumTicket(i.getPrice(), e);
                Ticket aux = x;
                PremiumTicket pt = (PremiumTicket) aux;
                pt.setPrice(pt.getPrice());
                System.out.println("Premium Ticket: " + pt.getPrice() + "$");
            }
        }
        audit.action("Showing tickets for event");
    }

    public void buyTicketsForEvent(ArrayList<Ticket> t, Client c, Event e, String type) {
        if (type.equals("standard")) {
            for (Ticket i : t) {
                if (i.getEvent() == e) {
                    StandardTicket x = new StandardTicket(i.getPrice(), e);
                    Ticket aux = x;
                    StandardTicket st = (StandardTicket) aux;
                    st.setPrice(st.getPrice());
                    c.buyStandardTicket(st);
                }
            }
        }
        if (type.equals("premium")) {
            for (Ticket i : t) {
                if (i.getEvent() == e) {
                    PremiumTicket x = new PremiumTicket(i.getPrice(), e);
                    Ticket aux = x;
                    PremiumTicket pt = (PremiumTicket) aux;
                    pt.setPrice(pt.getPrice());
                    c.buyPremiumTicket(pt);
                }
            }
        }
        audit.action("Buying ticket for event");
    }

    public void showTickets(Client c) {
        audit.action("Showing client's tickets");
        c.showMyTickets();
    }
}
