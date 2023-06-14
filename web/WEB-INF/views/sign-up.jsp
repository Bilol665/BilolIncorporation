<%--
  Created by IntelliJ IDEA.
  User: satim
  Date: 08.05.2023
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <style>
        .button {
            border: 1px solid gray;
            border-radius: 5px;
            background: darkcyan;
            font-size: 16px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            font-weight: bold;
            width: 100px;
            height: 30px;
            margin: 0;
            position: relative;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        .admin-side {
            margin-top: 50px;
            margin-left: 50px;
            width: 100%;
            height: 100%;
            display: inline-block;
        }
        .addition{
            width: 700px;
            display: inline-block;
            vertical-align: top;
        }

        #header{
            margin-left: -10px;
            margin-top: -10px;
            background-color: darkcyan;
            width: 100%;
            font-family: sans-serif;
            padding: 15px 30px;
        }
        .Bilol{
            background-color: darkcyan;
            border: 0;
            width: auto;
            height: 50px;
            text-size-adjust: inherit;
        }
        .Bilol:hover {
            background-color: aqua;
            border: 5px  darkcyan;
            border-radius: 5px;
        }
        .holder {
            background-color: darkcyan;
            width: 11.3%;
            padding: 5px 30px;
            display: inline-block;
            float: left;
        }
        div {
            align-items: center;
            justify-content: center;
        }
        .table thead{
            background-color: darkgrey;
        }

        .table tbody tr td{
            border: 1px solid gray;
        }
        .table {
            border: 1px solid gray;
            width: 90%;
        }

        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            margin: 0;
        }

        .login {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            margin: 10px auto;
            max-width: 200px;
            padding: 10px;
            align-content: center;
            text-align: center;
        }
        .center {
            margin: auto;
            width: 20%;
            border: 3px solid #333333;
            padding: 10px;
            position: relative;
            background-color: white;
        }
        h1 {
            color: #333333;
            font-size: 24px;
            margin-bottom: 30px;

        }

        form.registration {
            display: flex;
            flex-direction: column;
        }

        label {
            color: #333333;
            font-size: 16px;
            margin-bottom: 10px;
            text-align: center;
        }

        input[type="text"],
        input[type="number"],
        input[type="password"],
        #product_description,
        .options{
            background-color: #f2f2f2;
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            font-size: 16px;
            padding: 10px;
            margin-bottom: 20px;
        }

        .submit {
            background-color: #333333;
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            color: #ffffff;
            font-size: 16px;
            padding: 10px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #666666;
        }
        .head {
            background-color: darkcyan;
            width: 100%;
            height: 80px;
        }

        .bilol1{
            margin-left: 80px;
        }
        .head::after {
            content: '';
            display: table;
            clear: both;
            width: 100%;
            height: 80px;
        }
        .bilol-button {
            float: left;
            background-color: darkcyan;
            color: aqua;
            text-decoration: none;
            text-transform: uppercase;
            border: 0;
            padding-top: 30px;
            font-size: 18px;
            cursor: pointer;
            position: relative;
        }
        .bilol-button:hover {
            color: black;
            border-radius: 10%;
        }
        .navigation1 {
            float: right;
            margin-right: 100px;
        }
        .navigation1 ul{
            margin: 0;
            padding: 0;
            list-style: none;
        }
        .navigation1 li{
            display: inline-block;
            margin: 0 70px;
            position: relative;
        }
        .navigation1 ul li a{
            color: aqua;
            text-decoration: none;
            text-transform: uppercase;
        }
        .navigation1 ul li a:hover {
            color: black;

        }
        .bilol-button::before{
            content: '';
            display: block;
            height: 5px;
            background-color: black;
            position: absolute;
            top: 0;
            width: 0;
            border-radius: 25%;
            transition: all ease-in-out 250ms;
        }
        .bilol-button:hover::before {
            width: 100%;
        }
        .navigation1 a::before {
            content: '';
            display: block;
            height: 5px;
            background-color: black;
            position: absolute;
            top: 0;
            width: 0;
            border-radius: 25%;
            transition: all ease-in-out 250ms;
        }
        .navigation1 a:hover::before {
            width: 100%;
        }
        .somethings {
            width: 90px;
        }
        .delete-button-form {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div class="center">
    <h3 class="login">Login</h3>
    <hr>
    <form action="${pageContext.request.contextPath}/sign-up" method="post">
        <input type="text" name="username" placeholder="Enter username">
        <input type="text" name="email" placeholder="Enter email">
        <input type="text" name="fullName" placeholder="Enter your full name">
        <input type="password" name="password" placeholder="enter password">
        <select name="role" id="product_description">
            <option class="options" value="ADMIN">Select activity</option>
            <option class="options" value="CUSTOMER">Customer</option>
            <option class="options" value="SELLER">Seller</option>
            <option class="options" value="SELLER_COMPANY">Dealer</option>
        </select>
        <button class="button">Submit</button>
    </form>
</div>
</body>
</html>
