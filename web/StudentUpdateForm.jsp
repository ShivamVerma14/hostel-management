<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="StudentForm.css">
    <title>Student Form</title>
</head>
<body>
    <div class="container">
        <h2>Student Information Form</h2>
        <form action="UpdateStudentServlet" method="post" id="studentForm">
           
            <label for="Rno">Registration number:</label>
            <input type="text" id="name" name="regno" required>
       
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        
            <label for="mobile">Mobile Number:</label>
            <input type="tel" id="mobile" name="mobile" required >

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
                
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>
             
            <label for="hostel">Hostel:</label>
            <select id="hostel" name="hostel" required>
                <option value="" disabled selected>Select Hostel</option>
                <option value="A">Hostel A</option>
                <option value="B">Hostel B</option>
                <option value="C">Hostel C</option>
                <option value="D">Hostel D</option>
                <option value="E">Hostel E</option>
                <option value="F">Hostel F</option>
                <option value="G">Hostel G</option>
                <option value="H">Hostel H</option>
                <option value="I">Hostel I</option>
                <option value="J">Hostel J</option>
            </select>
             
            <label for="Hostelfee">Hostel Fee:</label>
            <input type="number" id="Hostelfee" name="Hostelfee" required>
            
            <label for="Messfee">Mess Fee:</label>
            <input type="number" id="Messfee" name="Messfee" required>
            
            <label for="feePaid">Fee Paid:</label>
            <input type="number" id="feePaid" name="Feepaid" required>

            <label for="course">Course Name:</label>
            <input type="text" id="course" name="course" required>

            <label for="duration">Course Duration:</label>
            <select id="Cduration" name="course_duration" required>
                <option value="a" disabled selected>Course Duration</option>
                <option value="1">1 year</option>
                <option value="2">2 year</option>
                <option value="3">3 year</option>
                <option value="4">4 year</option>
                <option value="5">5 year</option>
            </select>

            <button type="submit">Update</button>
        </form>
    </div>
</body>
</html>
