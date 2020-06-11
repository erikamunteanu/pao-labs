package VanzareBilete.repository;

import VanzareBilete.Location;
import VanzareBilete.config.DatabaseConfiguration;

import java.sql.*;

public class LocationRepository {
    public Location getLocationByID(int id) {
        String selectSql = "SELECT * FROM locations WHERE country=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToLocation(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteLocationByID(int id) {
        String deleteLocationSql = "DELETE FROM locations WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteLocationSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Location mapToLocation(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Location(resultSet.getString(2), resultSet.getString(3));
        }
        return null;
    }
}
