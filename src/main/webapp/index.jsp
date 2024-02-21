<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form {
            background-color: #6f52da;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        .form h1 {
            margin-bottom: 20px;
            color: #dad6d6;
        }

        .input-field {
            margin-bottom: 20px;
            text-align: left;
        }

        .input-field label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }

        .input-field input {
            width: calc(100% - 22px); /* Adjusted width to consider padding and border */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .forgot {
            margin-top: 10px;
        }

        .signup {
            margin-top: 20px;
            color: #333;
        }

        form .error {
            border: 2px solid red;
        }

        form .success {
            border: 2px solid greenyellow;
        }
    </style>
<body>
<div class="container">
    <form class="form" method="post" action="login">
        <h1>Login</h1>
        <div class="input-field">
            <label for="username">Email</label>
            <input
                    type="text"
                    id="username"
                    placeholder="Enter your email"
                    required
                    id="username"
                    name="email"
            />
        </div>
        <div class="input-field">
            <label for="password">Password</label>
            <input
                    type="password"
                    id="password"
                    placeholder="Provide your password"
                    required
                    id="password"
                    name="password"
            />
        </div>
        <button class="button" type="submit" id="button">Login</button>
        <div class="forgot">
            <a href="forgot.jsp">Forgot password?</a>
        </div>
        <div class="signup">
            Don't have an account? <a href="indexr.jsp">Sign Up</a>
        </div>
    </form>
</div>
</body>
<!-- <script  defer src="validation.js"></script> -->
</html>
