package utils;

import java.sql.*;

public class StudentDAO {
    public static void addStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String query = "INSERT INTO student (regno, name, email, mobile, dob, hostel_fees_per_year, mess_fees_per_year, fees_paid, course, course_duration, hostel_block, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getRegNo());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getMobile());
            preparedStatement.setDate(5, Date.valueOf(student.getDob()));
            preparedStatement.setDouble(6, student.getHostelFeesPerYear());
            preparedStatement.setDouble(7, student.getMessFeesPerYear());
            preparedStatement.setDouble(8, student.getFeesPaid());
            preparedStatement.setString(9, student.getCourse());
            preparedStatement.setInt(10, student.getCourseDuration());
            preparedStatement.setString(11, String.valueOf(student.getHostelBlock()));
            preparedStatement.setString(12, student.getPassword());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public static void updateStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String query = "UPDATE student SET name=?, email=?, mobile=?, dob=?, hostel_fees_per_year=?, mess_fees_per_year=?, fees_paid=?, course=?, course_duration=?, hostel_block=?, password=? WHERE regno=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getMobile());
            preparedStatement.setDate(4, Date.valueOf(student.getDob()));
            preparedStatement.setDouble(5, student.getHostelFeesPerYear());
            preparedStatement.setDouble(6, student.getMessFeesPerYear());
            preparedStatement.setDouble(7, student.getFeesPaid());
            preparedStatement.setString(8, student.getCourse());
            preparedStatement.setInt(9, student.getCourseDuration());
            preparedStatement.setString(10, String.valueOf(student.getHostelBlock()));
            preparedStatement.setString(11, student.getPassword());                
            preparedStatement.setString(12, student.getRegNo());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void deleteStudent(String regNo) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM student WHERE regno=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, regNo);
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
