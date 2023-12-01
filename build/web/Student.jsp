<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="utils.DBUtil"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="student.css">
    <title>Student</title>
</head>
<body>
    <%
        
        String regNo="1";
        String name="1";
        String email="1";
        int mobile=1;
        String dob="1";
        double totalHostelfees=1;
        double fees_paid=1.00;
        double messfee=1.00;
        String course="1";
        int courseDuration=1;
        char hostelBlock='1';
        String password="1";
                    
        List<Object[]> Studentdata =new ArrayList<>();
         
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
        
        try{
           connection=DBUtil.getConnection();
           statement=connection.createStatement();
           
           String query="SELECT * from student";
           
           resultset=statement.executeQuery(query);
           while(resultset.next())
            {
                name =resultset.getString("name");
                regNo=resultset.getString("regno");
                hostelBlock=resultset.getString("hostel_block").charAt(0);
                    
                Studentdata.add(new Object[]{name,regNo,hostelBlock});
            }
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            try { if (resultset != null) resultset.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (statement != null) statement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }

        }
        
        
    %>
    
    <div class="container">
        
        <div class="row">
           <button id="update">Update Student</button>
           <br>
           <br>
           <button id="add">Add Student</button>           
        </div>

        <div class="student-list">
            <h1>Student List</h1>
            <table>
                <thead>
                    <tr>
                        <th>Student Name</th>
                        <th>Student ID</th>
                        <th>Hostel Name</th>
                    </tr>
                </thead>
                <tbody>
                <% for (Object[] student: Studentdata) { %>
                    <tr>
                    <% for (Object attribute : student) { %>
                        <td><%= attribute %></td>
                    <% } %>
                    </tr>
                 <% } %>    
                </tbody>
            </table>
        </div>
    </div>
    <script>
        let addButton = document.getElementById("add");
        addButton.addEventListener('click', () => {
            window.location.href = "StudentForm.jsp";
        });
        
        let updateButton = document.getElementById("update");
        updateButton.addEventListener('click', () => {
            window.location.href = "StudentUpdateForm.jsp";
        });
    </script>
</body>
</html>