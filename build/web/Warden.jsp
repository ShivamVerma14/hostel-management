<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="utils.DBUtil"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="student.css">
    <title>Warden</title>
</head>
<body>
    <%
        
        String employeeid="1";
        String name="1";
        char hostelBlock='-';
                    
        List<Object[]> Wardendata =new ArrayList<>();
         
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
        
        try{
           connection=DBUtil.getConnection();
           statement=connection.createStatement();
           
           String query="SELECT * from warden";
           
           resultset=statement.executeQuery(query);
           while(resultset.next())
            {
                name =resultset.getString("name");
                employeeid=resultset.getString("employeeid");
                if (resultset.getString("hostel_block") != null)
                    hostelBlock=resultset.getString("hostel_block").charAt(0);
                    
                Wardendata.add(new Object[]{name,employeeid,hostelBlock});
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
       <button type="updatewarden">Update warden</button>
       <button type="addwarden">Add Warden</button>           
    </div>

    <div class="student-list">
        <h1>Student List</h1>
        <table>
            <thead>
                <tr>
                    <th>Warden Name</th>
                    <th>Warden ID</th>
                    <th>Hostel Name</th>
                </tr>
            </thead>
            <tbody>
            <% for (Object[] student: Wardendata) { %>
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
</body>
</html>