Etapa I
- Tipuri de obiecte: Band, Location, Date, Event, Ticket, PremiumTicket, StandardTicket, Client.
- Clasa Services expune operatiile sistemului.
- Clasa Main realizeaza apeluri catre servicii.

- Actiuni care se pot face in cadrul sistemului: adaugare trupe, adaugare locatii, adaugare date, generare evenimente, generare bilete, vizualizare (numar de) evenimente, vizualizare (numar de) trupe, cautare eveniment dupa trupa/ locatie/ data/ gen muzical, vizualizare pret bilete, cumparare bilete, vizualizare bilete cumparate.

Etapa II
- Clasa DataFiles (singleton) contine metode ce realizeaza citirea informatiilor din fisiere CSV pentru obiectele de tip Band, Location, Date si Client ("bandsToRead.csv", "locationsToRead.csv", "datesToRead.csv"", "clientToRead.csv"), respectiv de scriere a informatiilor in fisiere CSV pentru acestor obiecte ("bandsToWrite.csv", "locationsToWrite.csv", "datesToWrite.csv", "clientToWrite.csv").
- Clasa Audit (singleton) este utilizata pentru scrierea intr-un fisier CSV ("audit.csv") a numelui unei actiuni si a timestamp-ului acesteia.

Etapa III
- Pachetul "config" contine clasa DatabaseConfiguration, prin intermediul careia este configurata conexiunea la baza de date ticketsdb (user: "root", password: "password"). Clasa SetUpData creeaza tabelele bands, locations, dates, client si adauga informatiile corespunzatoare.
- Pachetul "repository" contine clasele BandRepository, LocationRepository, DateRepository si ClientRepository cu secvente SQL precompilate pentru clasele Band, Location, Date si Client.
