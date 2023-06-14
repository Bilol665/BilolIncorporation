<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: satim
  Date: 12.05.2023
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
      width: 50%;
      display: inline-flex;
      vertical-align: top;
    }

    div {
      align-items: center;
      justify-content: center;
    }
    .table {
      margin: 50px;
    }
    .table thead{
      background-color: darkgrey;
    }

    .table tbody tr td{
      border: 1px solid gray;
    }

    body {
      background-color: #f2f2f2;
      font-family: Arial, sans-serif;
      margin: 0;
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

    input[type="text"],
    input[type="number"],
    input[type="password"],
    input[type="file"],
    textarea{
      background-color: #f2f2f2;
      width: 400px;
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
      width: 47%;
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
    .display-post {
      border: 1px solid black;
      margin-top: 10px;
      margin-left: 10px;
      width: 70%;
    }
    .post{
      margin: 25px;
      border: 1px;
      display: inline-flex;
    }
    .table td {
      padding: 7px;
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
<h3 style="margin: 50px">
  Recommendations
</h3>
<c:if test="${furnitures.size() == 0}">
  <h3>No posts available!</h3>
</c:if>
<c:if test="${furnitures.size() != 0}">
  <table class="table">
    <thead>
    <tr>
      <td></td>
      <td>Title</td>
      <td>Height</td>
      <td>Width</td>
      <td>Length</td>
      <td>Material</td>
      <td>Structure Material</td>
      <td>Price</td>
      <td>Description</td>
      <td>Created date</td>
      <td>Colors</td>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="furnitures" scope="request" type="java.util.List"/>
    <c:forEach items="${furnitures}" var="Furniture">
      <tr>
        <td>${furnitures.indexOf(Furniture)+1}.</td>
        <td>${Furniture.title}</td>
        <td>${Furniture.height}</td>
        <td>${Furniture.width}</td>
        <td>${Furniture.length}</td>
        <td>${Furniture.material}</td>
        <td>${Furniture.baseMaterial}</td>
        <td>${Furniture.price}</td>
        <td>${Furniture.description}</td>
        <td><fmt:formatDate value="${localDateTimeFormat.parse(Furniture.created_time)}" pattern="dd-MM"/></td>
        <td>${Furniture.colors}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <form action="${pageContext.request.contextPath}/furniture/all" method="post">
    <input type="hidden" name="user_id" value="${user.id}">
    <button class="submit">Back</button>
  </form>
</c:if>
</body>
</html>
