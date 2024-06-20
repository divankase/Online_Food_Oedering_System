package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.dbconnection.DbConnection;
import food.model.EmployeeManagement;

public class EmployeemanagementDao {

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employeemanagement (employeename, employeephone, jobrole, email, filename, path) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, employeename, employeephone, jobrole, email, filename, path FROM employeemanagement WHERE id = ?;";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employeemanagement;";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employeemanagement WHERE id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employeemanagement SET employeename = ?, employeephone = ?, jobrole = ?, email = ?, filename = ?, path = ? WHERE id = ?;";

    public EmployeemanagementDao() {
    }

    DbConnection dbconnection = new DbConnection();

    public void insertEmployee(EmployeeManagement employeeManagement) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employeeManagement.getEmployeename());
            preparedStatement.setString(2, employeeManagement.getEmployeePhone());
            preparedStatement.setString(3, employeeManagement.getJobrole());
            preparedStatement.setString(4, employeeManagement.getEmail());
            preparedStatement.setString(5, employeeManagement.getFilename());
            preparedStatement.setString(6, employeeManagement.getPath());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }
    }

    public EmployeeManagement selectEmployee(int id) {
        EmployeeManagement employeeManagement = null;
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employeeName = rs.getString("employeename");
                String employeePhone = rs.getString("employeephone");
                String jobRole = rs.getString("jobrole");
                String email = rs.getString("email");
                String filename = rs.getString("filename");
                String path = rs.getString("path");
                employeeManagement = new EmployeeManagement(id, employeeName, employeePhone, jobRole, email, filename, path);
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }
        return employeeManagement;
    }

    public List<EmployeeManagement> selectAllEmployees() {
        List<EmployeeManagement> listemployees = new ArrayList<>();
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String employeename = rs.getString("employeename");
                String employeephone = rs.getString("employeephone");
                String jobrole = rs.getString("jobrole");
                String email = rs.getString("email");
                String filename = rs.getString("filename");
                String path = rs.getString("path");
                listemployees.add(new EmployeeManagement(id, employeename, employeephone, jobrole, email, filename, path));
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }
        return listemployees;
    }

    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateEmployee(EmployeeManagement employeeManagement) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            statement.setString(1, employeeManagement.getEmployeename());
            statement.setString(2, employeeManagement.getEmployeePhone());
            statement.setString(3, employeeManagement.getJobrole());
            statement.setString(4, employeeManagement.getEmail());
            statement.setString(5, employeeManagement.getFilename());
            statement.setString(6, employeeManagement.getPath());
            statement.setInt(7, employeeManagement.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
