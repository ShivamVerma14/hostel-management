package utils;

import java.sql.*;

public class WardenDAO {
    public static void addWarden(Warden warden) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO warden (employeeid, name, email, mobile, dob, joining_date, salary, isadmin, hostel_block, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, warden.getEmployeeId());
                preparedStatement.setString(2, warden.getName());
                preparedStatement.setString(3, warden.getEmail());
                preparedStatement.setString(4, warden.getMobile());
                preparedStatement.setDate(5, Date.valueOf(warden.getDob()));
                preparedStatement.setDate(6, Date.valueOf(warden.getJoiningDate()));
                preparedStatement.setDouble(7, warden.getSalary());
                preparedStatement.setString(8, String.valueOf(warden.getIsAdmin()));
                preparedStatement.setString(9, String.valueOf(warden.getHostelBlock()));
                preparedStatement.setString(10, warden.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void updateWarden(Warden warden) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE warden SET name=?, email=?, mobile=?, dob=?, joining_date=?, salary=?, isadmin=?, hostel_block=?, password=? WHERE employeeid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, warden.getName());
                preparedStatement.setString(2, warden.getEmail());
                preparedStatement.setString(3, warden.getMobile());
                preparedStatement.setDate(4, Date.valueOf(warden.getDob()));
                preparedStatement.setDate(5, Date.valueOf(warden.getJoiningDate()));
                preparedStatement.setDouble(6, warden.getSalary());
                preparedStatement.setString(7, String.valueOf(warden.getIsAdmin()));
                preparedStatement.setString(8, String.valueOf(warden.getHostelBlock()));
                preparedStatement.setString(9, warden.getPassword());                
                preparedStatement.setString(10, warden.getEmployeeId());
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteWarden(String employeeId) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM warden WHERE employeeid=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, employeeId);
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
