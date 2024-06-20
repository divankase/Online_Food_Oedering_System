/*package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.VenueBooking;

public class VenuesBookingDao {


	// VenuesBooking
	private static final String INSERT_venbooking_SQL = "INSERT INTO venuesbooking"
			+ " (User,nic,mobile,email,bookingdate,additionalservices,noofguests,advancedpayment) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from venuesbooking where User=? ";
	private static final String SELECT_venbooking_BY_ID = "select 	id,User,nic,mobile,email,bookingdate,additionalservices,noofguests,advancedpayment from cateringsbooking where id =?";
	private static final String SELECT_ALL_venbooking = "select * from venuesbooking";
	
	public VenuesBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert VenuesBooking
	public void insertVenuesBook(VenueBooking venbook) throws SQLException {
		System.out.println(INSERT_venbooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_venbooking_SQL)) {
			preparedStatement.setString(1, venbook.getUser());
			preparedStatement.setString(2, venbook.getNic());
			preparedStatement.setInt(3, venbook.getMobile());
			preparedStatement.setString(4, venbook.getEmail());
			preparedStatement.setString(5, venbook.getBookingdate());
			preparedStatement.setString(6, venbook.getAdditionalservices());
			preparedStatement.setInt(7, venbook.getNoofguests());
			preparedStatement.setInt(8, venbook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select VenueBooking
	public VenueBooking selectVenueBooking(int id) {
		VenueBooking venbook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_venbooking_BY_ID);) {
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
				String additionalservices = rs.getString("additionalservices");
				int noofguests = rs.getInt("noofguests");
				int advancedpayment = rs.getInt("advancedpayment");

				venbook = new VenueBooking(id,user, nic, mobile, email, bookingdate, additionalservices, noofguests,
						advancedpayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venbook;
	}
	// select All VenueBookings
	public List<VenueBooking> selectAllVenueBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<VenueBooking> venbook = new ArrayList<>();
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
				String additionalservices = rs.getString("additionalservices");
				int noofguests = rs.getInt("noofguests");
				int advancedpayment = rs.getInt("advancedpayment");
				venbook.add(new VenueBooking(id, user, nic, mobile, email, bookingdate, additionalservices, noofguests,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venbook;
	}
	// select All VenueBookings
	public List<VenueBooking> selectAllVenueBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<VenueBooking> venbook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_venbooking);) {
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
				String additionalservices = rs.getString("additionalservices");
				int noofguests = rs.getInt("noofguests");
				int advancedpayment = rs.getInt("advancedpayment");
				venbook.add(new VenueBooking(id, user, nic, mobile, email, bookingdate, additionalservices, noofguests,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venbook;
	}
	

}
*/