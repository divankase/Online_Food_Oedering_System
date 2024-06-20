/*package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.EntertainmentBooking;

public class EntertainmentsBookingDao {


	// entertainmentsbooking
	private static final String INSERT_entbooking_SQL = "INSERT INTO entertainmentsbooking"
			+ " (User,nic,mobile,email,bookingdate,additionalneeds,noofguests,advancedpayment) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from entertainmentsbooking where User=? ";
	private static final String SELECT_entbooking_BY_ID = "select 	id,User,nic,mobile,email,bookingdate,additionalneeds,noofguests,advancedpayment from entertainmentsbooking where id =?";
	private static final String SELECT_ALL_entbooking = "select * from entertainmentsbooking";
	
	public EntertainmentsBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert entertainments booking
	
	public void insertEntertainmentsBook(EntertainmentBooking entbook) throws SQLException {
		System.out.println(INSERT_entbooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_entbooking_SQL)) {
			preparedStatement.setString(1, entbook.getUser());
			preparedStatement.setString(2, entbook.getNic());
			preparedStatement.setInt(3, entbook.getMobile());
			preparedStatement.setString(4, entbook.getEmail());
			preparedStatement.setString(5, entbook.getBookingdate());
			preparedStatement.setString(6, entbook.getAdditionalneeds());
			preparedStatement.setInt(7, entbook.getnoofguests());
			preparedStatement.setInt(8, entbook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select EntertainmentBooking
	public EntertainmentBooking selectEntertainmentBooking(int id) {
		EntertainmentBooking entbook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_entbooking_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String user = rs.getString("User");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String additionalneeds = rs.getString("additionalneeds");
				int noofguests = rs.getInt("noofguests");
				int advancedpayment = rs.getInt("advancedpayment");

				entbook = new EntertainmentBooking(id,user, nic, mobile, email, bookingdate, additionalneeds, noofguests,
						advancedpayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entbook;
	}
	// select All EntertainmentBokings
	public List<EntertainmentBooking> selectAllEntertainmentBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<EntertainmentBooking> entbook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				
				// Step 2:Create a statement using connection object
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BookingbyUser);) {
			preparedStatement.setString(1, User);
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("User");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String additionalneeds = rs.getString("additionalneeds");
				int noofguests = rs.getInt("noofguests");
				int advancedpayment = rs.getInt("advancedpayment");
				entbook.add(new EntertainmentBooking(id, user, nic, mobile, email, bookingdate, additionalneeds, noofguests,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entbook;
	}
	// select All EntertainmentBokings
	public List<EntertainmentBooking> selectAllEntertainmentBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<EntertainmentBooking> entbook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_entbooking);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("User");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String additionalneeds = rs.getString("additionalneeds");
				int noofguests = rs.getInt("noofguests");
				int advancedpayment = rs.getInt("advancedpayment");
				entbook.add(new EntertainmentBooking(id, user, nic, mobile, email, bookingdate, additionalneeds, noofguests,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entbook;
	}
	

}
*/