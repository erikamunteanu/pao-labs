package VanzareBilete.repository;

import VanzareBilete.Band;
import VanzareBilete.config.DatabaseConfiguration;

import java.sql.*;

public class BandRepository {
    public Band getBandByID(int id) {
        String selectSql = "SELECT * FROM bands WHERE genre=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToBand(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBandByID(int id) {
        String deleteBandSql = "DELETE FROM bands WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteBandSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Band mapToBand(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Band(resultSet.getString(2), resultSet.getString(3));
        }
        return null;
    }
}
