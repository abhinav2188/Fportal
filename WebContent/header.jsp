<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Farmer Portal - kisaan seva</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet" href="css/basic.css">
<style>
.header {
	display: flex;
	width: 100%;
	justify-content: center;
	box-sizing: border-box;
	padding: 1.5rem 0;
	border-bottom: 0.05rem solid #ddd;
}
.header-container {
	display: flex;
	width: 80%;
	justify-content: space-between;
	align-items: center;
}
.font-logo{
	font-family: 'Alegreya Sans SC', sans-serif;
	font-size: 1.25rem;
}
.brand-logo{
display:flex;
flex-direction:column;
align-items: center;
margin-right: 1rem;
}
.header-link{
	color: #111;
	text-decoration: none;
}
.header-link:hover{
	color:#adce74;
}
.header-link:active{
font-weight : 700;
color: #adce74;
}
.left{
display:flex;
align-items: center;
}
</style>
</head>
<body>
	<header class="header shadow">
		<div class="header-container">
			<div class="left">
			<a class="brand-logo header-link" href="home">
				<span style="width:3rem;">
					<%@ include file="assets/icon.jsp" %>
				</span>
				<span class="font-logo">Kisaan Seva</span>
			</a>
			<a class="header-link" href="contact">Contact</a>
			<a class="header-link" href="about">About</a>
			<a class="header-link" href="inventory">Inventory</a>
			</div>
			<div class="right">
			<%
			HttpSession s = request.getSession(false);
			System.out.println("header "+s.getAttribute("uid")+s.getAttribute("uname"));
			if(s.getAttribute("uid") == null){
			%>
				<a class="header-link" href="login">Login</a>
				<a class="header-link" href="register">Register</a>				
			<%
			}else{
			%>
				<a class="header-link" href="profile"><%= s.getAttribute("uname")%></a>
				<a class="header-link" href="logout">Logout</a>			
			<%}%>
			</div>
		</div>
	</header>