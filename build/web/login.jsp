<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="login.css">
    <title>Hostel Management System</title>
</head>

<body>

    <div class="container" id="container">
        <div class="form-container sign-in">
            <form action="LoginServlet" method="post">
                <h1>Sign In</h1>
                <input type="text" placeholder="Username" name="username">
                <input type="password" placeholder="Password" name="password">
                <button>Sign In</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>Enter your personal details to use all of site features</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hostel Management System</h1>

                    <i class="fa-regular fa-building fa-2x" style="margin-top: 20px;"></i>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
