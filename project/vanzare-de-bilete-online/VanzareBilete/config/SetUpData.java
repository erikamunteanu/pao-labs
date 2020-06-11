package VanzareBilete.config;

import VanzareBilete.Band;
import VanzareBilete.Date;
import VanzareBilete.Location;
import VanzareBilete.repository.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class SetUpData {

    public void setUp() {

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        String createDatesSql = "CREATE TABLE IF NOT EXISTS dates" +
                "(id int PRIMARY KEY AUTO_INCREMENT, day int," +
                "month int," +
                "year int)";
        String createBandsSql = "CREATE TABLE IF NOT EXISTS bands" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "genre varchar(30))";
        String createLocationsSql = "CREATE TABLE IF NOT EXISTS locations" +
                "(id int PRIMARY KEY AUTO_INCREMENT, country varchar(30)," +
                "city varchar(30))";
        String createClientSql = "CREATE TABLE IF NOT EXISTS client" +
                "(id int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30)," +
                "lastName varchar(30)," +
                "age int," +
                "phoneNo varchar(30))";

        try {
            repositoryHelper.executeSql(databaseConnection, createDatesSql);
            repositoryHelper.executeSql(databaseConnection, createBandsSql);
            repositoryHelper.executeSql(databaseConnection, createLocationsSql);
            repositoryHelper.executeSql(databaseConnection, createClientSql);

            SetUpData setUpData = new SetUpData();
            //adding bands to "ticketsdb" database
            setUpData.addBand("Placebo", "rock");
            setUpData.addBand("Depeche Mode", "electronic");

            //adding dates to "ticketsdb" database
            setUpData.addDate(3, 6, 2020);
            setUpData.addDate(5, 6, 2020);
            setUpData.addDate(9, 6, 2020);
            setUpData.addDate(10, 6, 2020);
            setUpData.addDate(11, 6, 2020);
            setUpData.addDate(12, 6, 2020);
            setUpData.addDate(14, 6, 2020);
            setUpData.addDate(16, 6, 2020);
            setUpData.addDate(18, 6, 2020);

            //adding locations to "ticketsdb" database
            setUpData.addLocation("France", "Paris");
            setUpData.addLocation("Belgium", "Bruxelles");
            setUpData.addLocation("Germany", "Berlin");
            setUpData.addLocation("UK", "London");
            setUpData.addLocation("UK", "Leeds");
            setUpData.addLocation("UK", "Newcastle");
            setUpData.addLocation("Sweden", "Stockholm");
            setUpData.addLocation("The Netherlands", "Amsterdam");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTables() {
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        String deleteDatesSql = "DROP TABLE IF EXISTS dates";
        String deleteBandsSql = "DROP TABLE IF EXISTS bands";
        String deleteLocationsSql = "DROP TABLE IF EXISTS locations";
        String deleteClientSql = "DROP TABLE IF EXISTS client";

        try {
            repositoryHelper.executeSql(databaseConnection, deleteDatesSql);
            repositoryHelper.executeSql(databaseConnection, deleteBandsSql);
            repositoryHelper.executeSql(databaseConnection, deleteLocationsSql);
            repositoryHelper.executeSql(databaseConnection, deleteClientSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addDate(int day, int month, int year) {
        String insertDateSql = "INSERT INTO dates(id, day, month, year) VALUES(null, " + day + ", " + month + ", " + year +")";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertDateSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayDates() {
        String selectSql = "SELECT * FROM dates";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Day: " + resultSet.getInt(2));
                System.out.println("Month: " + resultSet.getInt(3));
                System.out.println("Year: " + resultSet.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBand(String name, String genre) {
        String insertBandSql = "INSERT INTO bands(id, name, genre) VALUES(null, '" + name + "', '" + genre + "')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertBandSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayBands() {
        String selectSql = "SELECT * FROM bands";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Band: " + resultSet.getString(2));
                System.out.println("Genre: " + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLocation(String country, String city) {
        String insertLocationSql = "INSERT INTO locations(id, country, city) VALUES(null, '" + country + "', '" + city + "')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertLocationSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayLocations() {
        String selectSql = "SELECT * FROM locations";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Country: " + resultSet.getString(2));
                System.out.println("City: " + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(String firstName, String lastName, int age, String phoneNo) {
        String insertClientSql = "INSERT INTO client(id, firstName, lastName, age, phoneNo) " +
                "VALUES(null, '" + firstName + "', '" + lastName + "', " + age + ", '" + phoneNo + "')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertClientSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayClient() {
        String selectSql = "SELECT * FROM client";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("First Name: " + resultSet.getString(2));
                System.out.println("Last Name: " + resultSet.getString(3));
                System.out.println("Age: " + resultSet.getInt(4));
                System.out.println("Phone Number: " + resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
