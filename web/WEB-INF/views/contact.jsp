<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: satim
  Date: 12.05.2023
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact me</title>
  <style>

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

    body {
      font-family: Arial, sans-serif;
      margin: 0;
      background-size: cover;

    }

    h1 {
      color: #333333;
      font-size: 24px;
      margin-bottom: 30px;

    }

    label {
      color: #333333;
      font-size: 16px;
      margin-bottom: 10px;
      text-align: center;
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

    .very-main {
      display: inline;
      /*
      background-color: rgba(255, 255, 255, 0.5); !* Adjust the alpha value (0.5) for transparency *!
      background-blend-mode: multiply;*/
    }
    .very-main h1 {
      margin: 45px;
      display: flex;
      align-content: center;
      justify-content: center;
      font-size: 100px;
    }
    .very-main p {
      display: flex;
      align-content: center;
      justify-content: center;
      font-size: 40px;
    }
  </style>
</head>
<body>
<div class="head">
  <div class="bilol1">
    <form action="${pageContext.request.contextPath}/home" method="post">
      <input type="hidden" name="user_id" value="${user.id}">
      <button class="bilol-button">Bilol incorporation</button>
    </form>
  </div>
  <nav class="navigation1">
    <ul>
      <li><form action="${pageContext.request.contextPath}/furniture/all" method="post">
        <input type="hidden" name="user_id" value="${user.id}">
        <button class="bilol-button">Home</button>
      </form> </li>
      <li><form action="${pageContext.request.contextPath}/card/myCard/${user.id}" method="post">
        <button class="bilol-button">Balance</button>
      </form> </li>
      <li><form action="${pageContext.request.contextPath}/contact" method="post">
        <input type="hidden" name="user_id" value="${user.id}">
        <button class="bilol-button">Contact</button>
      </form> </li>
      <c:if test="${user.role == 'ADMIN'}">
        <li>
          <form action="${pageContext.request.contextPath}/admin-side" method="post">
            <input type="hidden" name="user_id" value="${user.id}">
            <button class="bilol-button">Admin side</button>
          </form>
        </li>
        <li>
          <form action="${pageContext.request.contextPath}/furniture/posts" method="post">
            <input type="hidden" name="user_id" value="${user.id}">
            <button class="bilol-button">My posts</button>
          </form>
        </li>
      </c:if>
      <c:if test="${user.role == 'SELLER_COMPANY' || user.role == 'SELLER'}">
        <li>
          <form action="${pageContext.request.contextPath}/furniture/posts" method="post">
            <input type="hidden" name="user_id" value="${user.id}">
            <button class="bilol-button">My posts</button>
          </form>
        </li>
      </c:if>
      <li>
        <form action="${pageContext.request.contextPath}/login" method="get">
          <button class="bilol-button">Login</button>
        </form>
      </li>
    </ul>
  </nav>
</div>
<div style="margin: 100px">
  <H4>My contacts</H4>
  <p>Qzumi?</p>
</div>
</body>
</html>
