package VanzareBilete.repository;

import VanzareBilete.Date;
import VanzareBilete.config.DatabaseConfiguration;

import java.sql.*;

public class DateRepository {
    public Date getDateByID(int id) {
        String selectSql = "SELECT * FROM dates WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDate(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteDateByID(int id) {
        String deleteDateSql = "DELETE FROM dates WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteDateSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Date mapToDate(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Date(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4));
        }
        return null;
    }
}
