package VanzareBilete.repository;

import VanzareBilete.Client;
import VanzareBilete.config.DatabaseConfiguration;

import java.sql.*;

public class ClientRepository {
    public void updateClient(String firstName, String lastName, int age, String phoneNo, int id) {
        String updateClientSql = "UPDATE client SET firstName=?, lastName=?, age=?, phoneNo=? WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateClientSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, phoneNo);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClientByID(int id) {
        String selectSql = "SELECT * FROM client WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToClient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteClientByID(int id) {
        String deleteClientSql = "DELETE FROM client WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteClientSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Client mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Client(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
        }
        return null;
    }

}