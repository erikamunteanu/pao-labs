package VanzareBilete;

import VanzareBilete.config.SetUpData;
import VanzareBilete.repository.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //checkpoints I & II
        Services s = new Services();

        //loading data
        ArrayList<Band> bands = s.loadBands();
        ArrayList<Location> locations = s.loadLocations();
        ArrayList<Date> dates = s.loadDates();
        ArrayList<Client> clients = s.loadClient();

        //generating events
        ArrayList<Event> events = s.generateEvents(bands, locations, dates);

        //generating tickets
        ArrayList<Ticket> tickets = s.generateTickets(events);

        //s.listNoOfEvents(events); //view the number of events
        //s.listAllEvents(events); //view the events
        //s.listNoOfBands(bands); //view the number of bands
        //s.listAllBands(bands); //view the bands
        //s.searchEventsByDate(events, new Date(3, 6, 2020)); //view if there are any events on a date
        //s.searchEventsByBandName(events, "Placebo"); //view if there are any events by a band
        //s.searchEventsByGenre(events, "rock"); //view all events by music genre
        //s.searchEventsByCountry(events, "UK"); //view all events by country
        //s.searchEventsByCity(events, "London"); //view all events by city

        ArrayList<Event> ev;
        ev = s.getEventsByDate(events, new Date(5,6,2020)); //get events by date
        //ev = s.getEventsByBandName(events, "Depeche Mode"); //get events by band;
        //ev = s.getEventsByGenre(events, "rock"); //get events by genre
        //ev = s.getEventsByCountry(events, "UK"); //get events by country
        //ev = s.getEventsByCity(events, "London");  //get events by city
        //s.seeTicketsForEvent(tickets, ev.get(0)); //view the prices of tickets for an event (ev)

        Client c = clients.get(0);
        s.buyTicketsForEvent(tickets, c, ev.get(0), "premium"); //buy a ticket (standard or premium) for an event (ev)
        //s.showTickets(c); //show all tickets bought by a client (c)


        //checkpoint III
        s.loadDB(); //loading the database for band, date & location classes

        // s.showBandsDB(); //show bands from database
        // s.showDatesDB(); //show dates from database
        // s.showLocationsDB(); //show locations from database

        s.addClientDB("Erika", "Munteanu", 20, "123456"); //adding client to database
        s.showClientDB();
        s.updateClientDB("Erika", "Munteanu", 24, "345678", 1); //editing client's info
        s.showClientDB();
        s.deleteClientDB(1);
    }
}
