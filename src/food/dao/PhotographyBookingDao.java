/*package food.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import event.dbconnection.DbConnection;
import event.model.Photography;

public class PhotographyDao {

	// Photography
	private static final String INSERT_Photography_SQL = "INSERT INTO photography"
			+ " ( studioName,availableServices,location,workingDays,filename,path) VALUES " + " (?, ?, ?,?,?,?);";
	private static final String SELECT_Photography_BY_ID = "select id,studioName,availableServices,location,workingDays from photography where id =?";
	private static final String SELECT_ALL_Photography= "select * from photography";
	private static final String DELETE_Photgraphy_SQL = "delete from photography where id = ?;";
	private static final String UPDATE_Photography_SQL = "update photography set studioName = ?, availableServices = ?,location = ?,workingDays = ?  where id = ?;";

	public PhotographyDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Photography
	public void insertPhotography(Photography photography) throws SQLException {
		System.out.println(INSERT_Photography_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Photography_SQL)) {
			preparedStatement.setString(1, photography.getStudioName());
			preparedStatement.setString(2, photography.getAvailableServices());
			preparedStatement.setString(3, photography.getLocation());
			preparedStatement.setString(4, photography.getWorkingdays());
			preparedStatement.setString(5, photography.getFilename());
			preparedStatement.setString(6, photography.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Photography
	public Photography selectPhotography(int id) {
		Photography photography = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Photography_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String StudioName = rs.getString("studioName");
				String AvailableServices = rs.getString("availableServices");
				String Location = rs.getString("location");
				String Workingdays = rs.getString("workingDays");
				

				photography = new Photography(id, StudioName, AvailableServices, Location, Workingdays);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photography;
	}

	// select All Photography
	public List<Photography> selectAllPhotography() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Photography> photography = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Photography);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String StudioName = rs.getString("studioName");
				String AvailableServices = rs.getString("availableServices");
				String Location = rs.getString("location");
				String Workingdays = rs.getString("workingDays");
				String Filename = rs.getString("filename");
				String Path = rs.getString("path");
				photography.add(new Photography(id, StudioName, AvailableServices, Location, Workingdays, Filename, Path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photography;
	}

	// Delete Photography
	public boolean deletePhotography(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Photgraphy_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Photography
	public boolean updatePhotography(Photography photography) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Photography_SQL);) {
			statement.setString(1, photography.getStudioName());
			statement.setString(2, photography.getAvailableServices());
			statement.setString(3, photography.getLocation());
			statement.setString(4, photography.getWorkingdays());
			statement.setInt(5, photography.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
*/