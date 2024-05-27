<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
td {text-align: center;}
td,h1 {text-align: center;}
 td:hover {background-color: coral;}
 tr:nth-child(even){background-color:rgb(31, 31, 100);color: #ffffff;}
 tr:nth-child(odd){color: #000000;}
table{
margin-top:0px;
margin-left:35px;
margin-right:10px;
}
th{
background-color:rgba(0,0,0,0.4);
}
 body{
background-position:center;
font-family:sans-serif;
background-repeat: no-repeat;
background-attachment: fixed;
background-size: cover;}
h1
{
width=800px;
background-color:rgba(0,0,0,0.6);
margin-left:35px;
margin-right:69px;
margin-top:70px;
margin-bottom:0px;
color:#FFFFFF;
padding:10px 0px 10px 0px;
text-align:center;
border-radius:15px 15px 0px 0px;
}
.btn
{
color:red;
}</style>
</head>
<body>
<h1>View loans</h1>  
<table border=1 width="90%" >  
<tr>	<th>Loan Id</th>
		<th>Amount</th>
		<th>Date</th>
		<th>Duration</th>  
		<th>Status</th>
		<th>User Id</th>
		<th>Accept</th>
		<th>Reject</th>
		</tr>  
<c:forEach items="${list}" var="u">  
<tr>
<td>${u.getLoan_id()}</td>
<td>${u.getAmount()}</td>
<td>${u.getDate()}</td>  
<td>${u.getDuration()}</td>
<td>${u.getStatus()}</td>
<td>${u.getUser_id()}</td>
<td><a href="AcceptLoan/${u.getLoan_id()}">Accept</a></td>  
<td><a href="editLoanStatus/${u.getLoan_id()}">Reject</a></td></tr>    
</c:forEach>  
</table>  
</body>
</html>