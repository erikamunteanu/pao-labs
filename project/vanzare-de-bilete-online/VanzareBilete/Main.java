package VanzareBilete;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Loading the data

        //Adding bands
        ArrayList<Band> bands = new ArrayList<>();
        bands.add(new Band("Placebo", "rock"));
        bands.add(new Band("Depeche Mode", "electronic"));

        //Adding locations
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("France", "Paris"));
        locations.add(new Location("Belgium", "Bruxelles"));
        locations.add(new Location("Germany", "Berlin"));
        locations.add(new Location("UK", "London"));
        locations.add(new Location("UK", "Leeds"));
        locations.add(new Location("UK", "Newcastle"));
        locations.add(new Location("Sweden", "Stockholm"));
        locations.add(new Location("The Netherlands", "Amsterdam"));

        //Adding dates
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(3, 6, 2020));
        dates.add(new Date(5, 6, 2020));
        dates.add(new Date(9, 6, 2020));
        dates.add(new Date(10, 6, 2020));
        dates.add(new Date(11, 6, 2020));
        dates.add(new Date(12, 6, 2020));
        dates.add(new Date(14, 6, 2020));
        dates.add(new Date(16, 6, 2020));
        dates.add(new Date(18, 6, 2020));

        //Generating events
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

        //Generating tickets
        ArrayList<Ticket> tickets = new ArrayList<>();
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


        //Service calls made by client

        Services s = new Services();

        //s.listNoOfEvents(events); //View the number of events
        //s.listAllEvents(events); //View the events
        //s.listNoOfBands(bands); //View the number of bands
        //s.listAllBands(bands); //View the bands
        //s.searchEventsByDate(events, new Date(3, 6, 2020)); //View if there are any events on a date
        //s.searchEventsByBandName(events, "Placebo"); //View if there are any events by a band
        //s.searchEventsByGenre(events, "rock"); //View all events by music genre
        //s.searchEventsByCountry(events, "UK"); //View all events by country
        //s.searchEventsByCity(events, "London"); //View all events by city

        ArrayList<Event> ev;
        ev = s.getEventsByDate(events, new Date(5,6,2020)); //Get events by date
        //ev = s.getEventsByBandName(events, "Depeche Mode"); //Get events by band;
        //ev = s.getEventsByGenre(events, "rock"); //Get events by genre;
        //ev = s.getEventsByCountry(events, "UK");
        //ev = s.getEventsByCity(events, "London");
        s.seeTicketsForEvent(tickets, ev.get(0)); //View the prices of tickets for an event (ev)

        Client c = new Client("Erika", "Munteanu", 20, "1234567");
        s.buyTicketsForEvent(tickets, c, ev.get(0), "premium"); //Buy a ticket (standard or premium) for an event (ev)
        //s.showTickets(c); //Show all tickets bought by a client (c)
    }
}
