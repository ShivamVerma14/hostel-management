package utils;

import java.sql.*;

public class HostelDOA {
    public static void addHostel(Hostel hostel) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO hostel (hostel_block, total_rooms, rooms_occupied) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, String.valueOf(hostel.getHostelBlock()));
                preparedStatement.setInt(2, hostel.getTotalRooms());
                preparedStatement.setInt(3, hostel.getRoomsOccupied());
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void updateHostel(Hostel hostel) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE hostel SET total_rooms=?, rooms_occupied=? WHERE hostel_block=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, hostel.getTotalRooms());
                preparedStatement.setInt(2, hostel.getRoomsOccupied());                
                preparedStatement.setString(3, String.valueOf(hostel.getHostelBlock()));
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteHostel(char hostelBlock) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM hostel WHERE hostel_block=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, String.valueOf(hostelBlock));
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
