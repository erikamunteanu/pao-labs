package VanzareBilete;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Services s = new Services();

        //Loading data
        ArrayList<Band> bands = s.loadBands();
        ArrayList<Location> locations = s.loadLocations();
        ArrayList<Date> dates = s.loadDates();
        ArrayList<Client> clients = s.loadClient();

        //Generating events
        ArrayList<Event> events = s.generateEvents(bands, locations, dates);

        //Generating tickets
        ArrayList<Ticket> tickets = s.generateTickets(events);

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
        //ev = s.getEventsByGenre(events, "rock"); //Get events by genre
        //ev = s.getEventsByCountry(events, "UK"); //Get events by country
        //ev = s.getEventsByCity(events, "London");  //Get events by city
        //s.seeTicketsForEvent(tickets, ev.get(0)); //View the prices of tickets for an event (ev)

        Client c = clients.get(0);
        s.buyTicketsForEvent(tickets, c, ev.get(0), "premium"); //Buy a ticket (standard or premium) for an event (ev)
        //s.showTickets(c); //Show all tickets bought by a client (c)
    }
}
