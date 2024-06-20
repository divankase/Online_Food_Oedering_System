package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.dbconnection.DbConnection;
import food.model.Userfeedbacks;

public class UserfeedbacksDao {

    private static final String INSERT_FEEDBACKS_SQL = "INSERT INTO userfeedbacks " +
            "(customername, email, subject, message) " +
            "VALUES (?, ?, ?, ?);";

    private static final String SELECT_FEEDBACKS_BY_ID = "SELECT id, customername, email, subject, message " +
            "FROM userfeedbacks WHERE id = ?;";

    private static final String SELECT_ALL_FEEDBACKS = "SELECT * FROM userfeedbacks;";

    private static final String DELETE_FEEDBACKS_SQL = "DELETE FROM userfeedbacks WHERE id = ?;";

    private static final String UPDATE_FEEDBACKS_SQL = "UPDATE userfeedbacks SET customername = ?, email = ?, subject = ?, message = ? " +
            "WHERE id = ?;";

    public UserfeedbacksDao() {
    }

    DbConnection dbconnection = new DbConnection();

    public void insertFeedback(Userfeedbacks userfeedbacks) throws SQLException {
        System.out.println(INSERT_FEEDBACKS_SQL);

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FEEDBACKS_SQL)) {
            preparedStatement.setString(1, userfeedbacks.getCustomerNname());
            preparedStatement.setString(2, userfeedbacks.getEmail());
            preparedStatement.setString(3, userfeedbacks.getSubject());
            preparedStatement.setString(4, userfeedbacks.getMessage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }
    }

    public Userfeedbacks selectFeedback(int id) {
        Userfeedbacks userfeedbacks = null;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FEEDBACKS_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String customername = rs.getString("customername");
                String email = rs.getString("email");
                String subject = rs.getString("subject");
                String message = rs.getString("message");

                userfeedbacks = new Userfeedbacks(id, customername, email, subject, message);
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }

        return userfeedbacks;
    }

    public List<Userfeedbacks> selectAllFeedbacks() {
        List<Userfeedbacks> userfeedbacks = new ArrayList<>();

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FEEDBACKS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String customername = rs.getString("customername");
                String email = rs.getString("email");
                String subject = rs.getString("subject");
                String message = rs.getString("message");

                userfeedbacks.add(new Userfeedbacks(id, customername, email, subject, message));
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }

        return userfeedbacks;
    }

    public boolean deleteFeedback(int id) throws SQLException {
        boolean rowDeleted;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FEEDBACKS_SQL)) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    public boolean updateFeedback(Userfeedbacks userfeedbacks) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FEEDBACKS_SQL)) {
            statement.setString(1, userfeedbacks.getCustomerNname());
            statement.setString(2, userfeedbacks.getEmail());
            statement.setString(3, userfeedbacks.getSubject());
            statement.setString(4, userfeedbacks.getMessage());
            statement.setInt(5, userfeedbacks.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }

        return rowUpdated;
    }
}
