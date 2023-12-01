<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.DBUtil" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <title>Dashboard</title>
</head>
<body>
<%
    String loginEntity = (String) session.getAttribute("loginEntity");
    String username = (String) session.getAttribute("username");
    String regNo = "1", employeeid = "1";
    String name = "1";
    String email = "1";
    int mobile = 1; // changed from Mobile to mobile
    String dob = "1"; // changed from DOB to dob
    String joiningDate = "1";
    double totalHostelfees = 1, salary = 1; // changed from TotalHostelfees to totalHostelfees, Salary to salary
    double fees_paid = 1.00;
    double messfee = 1.00;
    String course = "1"; // changed from Course to course
    int courseDuration = 1; // changed from CourseDuration to courseDuration
    char hostelBlock = '-';
    String password = "1";

    Connection connection = null;
    Statement statement = null;

    try {
        connection = DBUtil.getConnection();
        statement = connection.createStatement();

        String query;

        if (loginEntity.equals("student")) {
            query = "SELECT * from student WHERE regno = '" + username + "'";
            regNo = username;
        } else {
            query = "SELECT * from warden WHERE employeeid = '" + username + "'";
            employeeid = username;
        }

        ResultSet resultset = statement.executeQuery(query);
        if (resultset.next()) { // changed from resultset!=null to resultset.next()
            if (loginEntity.equals("student")) {
                totalHostelfees = resultset.getDouble("hostel_fees_per_year");
                fees_paid = resultset.getDouble("fees_paid");
                messfee = resultset.getDouble("mess_fees_per_year");
                course = resultset.getString("course");
                courseDuration = resultset.getInt("course_duration");
            } else {
                joiningDate = resultset.getString("joining_date");
                salary = resultset.getDouble("salary");
            }

            name = resultset.getString("name");
            email = resultset.getString("email");
            mobile = resultset.getInt("mobile");
            dob = resultset.getString("dob");
            hostelBlock = resultset.getString("hostel_block").charAt(0);
            password = resultset.getString("password");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

%>

<div class="admin-container">
    <div class="profile-container">
        <i class="fa-regular fa-user fa-3x" style="height: 30px; padding: 20px; margin-top: 20px;"></i>
        <h2><%= loginEntity %></h2>

        <% if(loginEntity.equals("Admin")) { %>
        <div class="buttons-container">
            <button id="home" class="nav-button">Home</button>
            <button id="warden" class="nav-button">Warden</button>
            <button id="student" class="nav-button">Student</button>
        </div>
        <% } %>
        <% if(loginEntity.equals("warden")){ %>
        <div class="buttons-container">
            <button id="home" class="nav-button">Home</button>
            <button id="student" class="nav-button">Student</button>
        </div>
        <% } %>
        <% if(loginEntity.equals("student")){ %>
        <div class="buttons-container">
            <button id="home" class="nav-button">Home</button>
        </div>
        <% } %>

        <button class="logout-button">Logout <i class="fa-solid fa-right-from-bracket "
                style="padding-left: 10px;"></i></button>
    </div>
    <button class="nav-button-update">Update <i class="fa-solid fa-pen"></i></button>
    <div class="info-container">
        <% if(loginEntity.equals("Admin")) { %>
        <div class="info-item"><strong>Admin ID:</strong><%= employeeid %></div>
        <div class="info-item"><strong>Name:</strong> <%= name %></div>
        <div class="info-item"><strong>Email:</strong> <%= email %></div>
        <div class="info-item"><strong>Phone Number:</strong> <%= mobile %></div>
        <div class="info-item"><strong>Joining Date:</strong> <%= joiningDate %></div>
        <div class="info-item"><strong>Salary:</strong> <%= salary %></div>
        <div class="info-item"><strong>Hostel Block:</strong> <%= hostelBlock %></div>
        <% } %>
        <% if(loginEntity.equals("warden")){ %>
        <div class="info-item"><strong>Employee Id:</strong><%= employeeid %></div>
        <div class="info-item"><strong>Name:</strong> <%= name %></div>
        <div class="info-item"><strong>Email:</strong> <%= email %></div>
        <div class="info-item"><strong>Phone Number:</strong> <%= mobile %></div>
        <div class="info-item"><strong>Joining Date:</strong> <%= joiningDate %></div>
        <div class="info-item"><strong>Salary:</strong> <%= salary %></div>
        <div class="info-item"><strong>Hostel Block:</strong> <%= hostelBlock %></div>
        <% } %>
        <% if(loginEntity.equals("student")) { %>
        <div class="info-item"><strong>Reg no:</strong> <%= regNo %></div>
        <div class="info-item"><strong>Name:</strong> <%= name %></div>
        <div class="info-item"><strong>Email:</strong><%= email %></div>
        <div class="info-item"><strong>Phone Number:</strong> <%= mobile %></div>
        <div class="info-item"><strong>Date of birth:</strong> <%= dob %></div>
        <div class="info-item"><strong>Hostel fees per year:</strong> <%= totalHostelfees %></div>
        <div class="info-item"><strong>Fees Paid:</strong> <%= fees_paid %></div>
        <div class="info-item"><strong>Mess Fee:</strong> <%= messfee %></div>
        <div class="info-item"><strong>Course:</strong> <%= course %></div>
        <div class="info-item"><strong>Course Duration:</strong> <%= courseDuration %></div>
        <div class="info-item"><strong>Hostel Block:</strong> <%= hostelBlock %></div>
        <% } %>
    </div>
</div>
    <script>
        let studentButton = document.getElementById("student");
        studentButton.addEventListener('click', () => {
            window.location.href = "Student.jsp";
        });
        
        let wardenButton = document.getElementById("warden");
        wardenButton.addEventListener('click', () => {
            window.location.href = "Warden.jsp";
        });
        
        let homeButton = document.getElementById("home");
        homeButton.addEventListener('click', () => {
            window.location.href = 'dashboard.jsp';
        });
    </script>
</body>

</html>
