<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/27/2023
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Forgot Password</title>
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
            background-color: #675df0;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 300px;
            text-align: center;
            color: white;
        }

        .form h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .input {
            margin-bottom: 20px;
            text-align: left;
        }

        .input label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }

        .input input {
            width: 100%;
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

        .login {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form" action="submit">
        <h2>Forgot Password</h2>
        <p>
            Please enter your email address. You will receive a link to create a
            new password via email.
        </p>
        <div class="input">
            <label for="email">Email Address</label>
            <input
                    type="email"
                    id="email"
                    placeholder="Provide your email address"
                    required
            />
        </div>
        <button type="submit" class="button">Reset Password</button>
        <div class="login">
            <a href="index.jsp">Back to Login</a>
        </div>
    </form>
</div>
</body>
</html>

