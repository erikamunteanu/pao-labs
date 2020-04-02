package VanzareBilete;

import java.util.ArrayList;

public class Services {
    public Services() {
    }

    public void listNoOfEvents(ArrayList<Event> e) {
        System.out.println(e.size());
    }

    public void listNoOfBands(ArrayList<Band> b) {
        System.out.println(b.size());
    }

    public void listEvent(Event e) {
        System.out.println(e.showEvent());
    }

    public void listAllEvents(ArrayList<Event> e) {
        for (Event i : e) {
            listEvent(i);
        }
    }

    public void listAllBands(ArrayList<Band> b) {
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
        if (!v) {
            System.out.println("There aren't any " + g + " events");
        }
    }

    public ArrayList<Event> getEventsByGenre(ArrayList<Event> e, String g) {
        ArrayList<Event> ev = new ArrayList<Event>();
        for (Event i : e) {
            if (i.band.getGenre().equals(g)) {
                ev.add(i);
                listEvent(i);
            }
        }
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
    }

    public void showTickets(Client c) {
        c.showMyTickets();
    }
}
