<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.springcrud.beans.Ticket,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title> 
<style type="text/css">
*{
margin:0;
padding:0;
}
body{
background-image:url(https://askleo.askleomedia.com/wp-content/uploads/2009/03/online-banking2.jpg);
background-position:center;
font-family:sans-serif;
background-repeat: no-repeat;
background-attachment: fixed;
background-size: cover;
}
.updatestatus
{
width=800px;
background-color:rgba(0,0,0,0.6);
margin-left:150px;
margin-right:150px;
margin-top:100px;
color:#FFFFFF;
padding:10px 0px 10px 0px;
text-align:center;
border-radius:15px 15px 0px 0px;
}
.main
{
background-color:rgba(0,0,0,0.4);
margin-left:150px;
margin-right:150px;
}
form
{padding:10px;
}
.status
{
width:580px;
height:30px;
margin-left:80px;
text-size:20px
}
.button
{
margin-left:210px;
width:100px;
padding-top:5px;
padding-bottom:5px;
margin-top:5px;
margin-left:340px;
}
h2
{
margin-left:250px;
color:#FFFFFF;
}
</style>
</head>>
<body> 
<div class="updatestatus"><h1>Update Status</h1></div>
<div class="main"> 
<form method="post" action="../editsave" modelAttribute="emp">
<div id="status">
<h2>Please Upadate status :</h2>
<input class="status" type="text" name="status" value=${u.getStatus()}></input>   
<button class="button" type="submit">Update Status</button>
</div>
</form>   
</div>
</body>
</html>