package VanzareBilete;

import java.io.*;
import java.util.ArrayList;

public class DataFiles {

    private static DataFiles single_instance = null;

    DataFiles() { }

    public static DataFiles getInstance() {
        if(single_instance == null) {
            single_instance = new DataFiles();
        }
        return single_instance;
    }

    public ArrayList<Band> readBands() throws IOException {
        ArrayList<Band> bands = new ArrayList<Band>();
        BufferedReader br = null;
        try {
            String bandsFromCSV = "src/VanzareBilete/data/bandsToRead.csv";
            br = new BufferedReader(new FileReader(bandsFromCSV));
            String header = br.readLine();
            if (header != null) {
                String[] columns = header.split(",");
            }
            String line = br.readLine();
            while (line != null) {
                String[] l = line.split(",");
                String name = l[0];
                String genre = l[1];
                bands.add(new Band(name, genre));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return bands;
    }

    public static void writeBands(ArrayList<Band> bands) throws IOException {
        BufferedWriter bw = null;
        try {
            String bandsToCSV = "src/VanzareBilete/data/bandsToWrite.csv";
            bw = new BufferedWriter(new FileWriter(bandsToCSV));
            String header = "NAME, GENRE \n";
            bw.write(header);
            for(Band b : bands) {
                bw.write(b.getName() + "," + b.getGenre() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bw != null;
            bw.close();
        }
    }

    public ArrayList<Location> readLocations() throws IOException {
        ArrayList<Location> locations = new ArrayList<Location>();
        BufferedReader br = null;
        try {
            String locationsFromCSV = "src/VanzareBilete/data/locationsToRead.csv";
            br = new BufferedReader(new FileReader(locationsFromCSV));
            String header = br.readLine();
            if (header != null) {
                String[] columns = header.split(",");
            }
            String line = br.readLine();
            while (line != null) {
                String[] l = line.split(",");
                String country = l[0];
                String city = l[1];
                locations.add(new Location(country, city));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return locations;
    }

    public static void writeLocations(ArrayList<Location> locations) throws IOException {
        BufferedWriter bw = null;
        try {
            String locationsToCSV = "src/VanzareBilete/data/locationsToWrite.csv";
            bw = new BufferedWriter(new FileWriter(locationsToCSV));
            String header = "COUNTRY, CITY \n";
            bw.write(header);
            for(Location l : locations) {
                bw.write(l.getCountry() + "," + l.getCity() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bw != null;
            bw.close();
        }
    }

    public ArrayList<Date> readDates() throws IOException {
        ArrayList<Date> dates = new ArrayList<Date>();
        BufferedReader br = null;
        try {
            String datesFromCSV = "src/VanzareBilete/data/datesToRead.csv";
            br = new BufferedReader(new FileReader(datesFromCSV));
            String header = br.readLine();
            if (header != null) {
                String[] columns = header.split(",");
            }
            String line = br.readLine();
            while (line != null) {
                String[] l = line.split(",");
                String day = l[0];
                String month = l[1];
                String year = l[2];
                dates.add(new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return dates;
    }

    public static void writeDates(ArrayList<Date> dates) throws IOException {
        BufferedWriter bw = null;
        try {
            String datesToCSV = "src/VanzareBilete/data/datesToWrite.csv";
            bw = new BufferedWriter(new FileWriter(datesToCSV));
            String header = "DAY, MONTH, YEAR \n";
            bw.write(header);
            for(Date d : dates) {
                bw.write(d.getDay() + "," + d.getMonth() + "," + d.getYear() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bw != null;
            bw.close();
        }
    }

    public ArrayList<Client> readClient() throws IOException {
        ArrayList<Client> clients = new ArrayList<Client>();
        BufferedReader br = null;
        try {
            String clientFromCSV = "src/VanzareBilete/data/clientToRead.csv";
            br = new BufferedReader(new FileReader(clientFromCSV));
            String header = br.readLine();
            if (header != null) {
                String[] columns = header.split(",");
            }
            String line = br.readLine();
            while (line != null) {
                String[] l = line.split(",");
                String firstname = l[0];
                String lastname = l[1];
                String age = l[2];
                String phonenumber = l[3];
                clients.add(new Client(firstname, lastname, Integer.parseInt(age), phonenumber));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return clients;
    }

    public static void writeClient(ArrayList<Client> clients) throws IOException {
        BufferedWriter bw = null;
        try {
            String locationsToCSV = "src/VanzareBilete/data/clientToWrite.csv";
            bw = new BufferedWriter(new FileWriter(locationsToCSV));
            String header = "FIRST NAME, LAST NAME, AGE, PHONE NUMBER \n";
            bw.write(header);
            for(Client c : clients) {
                bw.write(c.getFirstName() + "," + c.getLastName() + "," + c.getAge() +"," + c.getPhoneNo() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bw != null;
            bw.close();
        }
    }
}