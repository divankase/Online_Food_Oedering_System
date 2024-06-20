/*package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.CateringBooking;

public class CateringsBookingDao {


	// CateringsBooking
	private static final String INSERT_catbooking_SQL = "INSERT INTO cateringsbooking"
			+ " (User,nic,mobile,email,bookingdate,additionalneeds,noofplates,advancedpayment) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from cateringsbooking where User=? ";
	private static final String SELECT_catbooking_BY_ID = "select 	id,User,nic,mobile,email,bookingdate,additionalneeds,noofplates,advancedpayment from cateringsbooking where id =?";
	private static final String SELECT_ALL_catbooking = "select * from cateringsbooking";
	
	public CateringsBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert CateringsBooking
	public void insertCateringsBook(CateringBooking catbook) throws SQLException {
		System.out.println(INSERT_catbooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_catbooking_SQL)) {
			preparedStatement.setString(1, catbook.getUser());
			preparedStatement.setString(2, catbook.getNic());
			preparedStatement.setInt(3, catbook.getMobile());
			preparedStatement.setString(4, catbook.getEmail());
			preparedStatement.setString(5, catbook.getBookingdate());
			preparedStatement.setString(6, catbook.getAdditionalneeds());
			preparedStatement.setInt(7, catbook.getNoofplates());
			preparedStatement.setInt(8, catbook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select CateringBooking
	public CateringBooking selectCateringBooking(int id) {
		CateringBooking catbook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_catbooking_BY_ID);) {
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
				int noofplates = rs.getInt("noofplates");
				int advancedpayment = rs.getInt("advancedpayment");

				catbook = new CateringBooking(id,user, nic, mobile, email, bookingdate, additionalneeds, noofplates,
						advancedpayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return catbook;
	}
	// select All CateringBokings
	public List<CateringBooking> selectAllCateringBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<CateringBooking> catbook = new ArrayList<>();
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
				int noofplates = rs.getInt("noofplates");
				int advancedpayment = rs.getInt("advancedpayment");
				catbook.add(new CateringBooking(id, user, nic, mobile, email, bookingdate, additionalneeds, noofplates,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return catbook;
	}
	// select All CateringBokings
	public List<CateringBooking> selectAllCateringBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<CateringBooking> catbook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_catbooking);) {
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
				int noofplates = rs.getInt("noofplates");
				int advancedpayment = rs.getInt("advancedpayment");
				catbook.add(new CateringBooking(id, user, nic, mobile, email, bookingdate, additionalneeds, noofplates,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return catbook;
	}
	

}*/