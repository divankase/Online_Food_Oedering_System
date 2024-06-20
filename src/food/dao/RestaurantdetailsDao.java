package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.dbconnection.DbConnection;
import food.model.Restaurantdetails;

public class RestaurantdetailsDao {

    private static final String INSERT_RESTAURANT_SQL = "INSERT INTO restaurant" +
            " (restaurantname, phone, workingdays, location, filename, path) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_RESTAURANT_BY_ID = "SELECT id, restaurantname, phone, workingdays, location, filename, path " +
            "FROM restaurant WHERE id = ?;";

    private static final String SELECT_ALL_RESTAURANT = "SELECT id, restaurantname, phone, workingdays, location, filename, path FROM restaurant;";

    private static final String DELETE_RESTAURANT_SQL = "DELETE FROM restaurant WHERE id = ?;";

    private static final String UPDATE_RESTAURANT_SQL = "UPDATE restaurant SET restaurantname = ?, phone = ?, workingdays = ?, location = ?, " +
            "filename = ?, path = ? WHERE id = ?;";

    public RestaurantdetailsDao() {
    }

    DbConnection dbconnection = new DbConnection();

    public void insertRestaurantdetails(Restaurantdetails restaurantdetails) throws SQLException {
        System.out.println(INSERT_RESTAURANT_SQL);

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESTAURANT_SQL)) {
            preparedStatement.setString(1, restaurantdetails.getRestaurantname());
            preparedStatement.setString(2, restaurantdetails.getPhone());
            preparedStatement.setString(3, restaurantdetails.getWorkingdays());
            preparedStatement.setString(4, restaurantdetails.getLocation());
            preparedStatement.setString(5, restaurantdetails.getFilename());
            preparedStatement.setString(6, restaurantdetails.getPath());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }
    }

    public Restaurantdetails selectRestaurantdetails(int id) {
        Restaurantdetails restaurantdetails = null;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTAURANT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String restaurantname = rs.getString("restaurantname");
                String phone = rs.getString("phone");
                String workingdays = rs.getString("workingdays");
                String location = rs.getString("location");
                String filename = rs.getString("filename");
                String path = rs.getString("path");

                restaurantdetails = new Restaurantdetails(id, restaurantname, phone, workingdays, location, filename, path);
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }

        return restaurantdetails;
    }

    public List<Restaurantdetails> selectAllRestaurantdetails() {
        List<Restaurantdetails> restaurant = new ArrayList<>();

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESTAURANT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String restaurantname = rs.getString("restaurantname");
                String phone = rs.getString("phone");
                String workingdays = rs.getString("workingdays");
                String location = rs.getString("location");
                String filename = rs.getString("filename");
                String path = rs.getString("path");

                restaurant.add(new Restaurantdetails(id, restaurantname, phone, workingdays, location, filename, path));
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }

        return restaurant;
    }

    public boolean deleteRestaurantdetails(int id) throws SQLException {
        boolean rowDeleted;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RESTAURANT_SQL)) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    public boolean updateRestaurantdetails(Restaurantdetails restaurantdetails) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RESTAURANT_SQL)) {
            statement.setString(1, restaurantdetails.getRestaurantname());
            statement.setString(2, restaurantdetails.getPhone());
            statement.setString(3, restaurantdetails.getWorkingdays());
            statement.setString(4, restaurantdetails.getLocation());
            statement.setString(5, restaurantdetails.getFilename());
            statement.setString(6, restaurantdetails.getPath());
            statement.setInt(7, restaurantdetails.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }

        return rowUpdated;
    
    }
    
}
