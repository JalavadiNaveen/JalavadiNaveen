<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
.addticket
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
.query
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div class="addticket"><h1>Add Ticket</h1></div>
<div class="main">
<form method="post" action="save" modelAttribute="emp">  
<input type="hidden" name="status" value="Pending"/>
<input type="hidden" name="user_id" value="1"/>
<div id="query">
<h2>Please enter Your Query</h2>
<input class="query" type="text" name="query"/> <br>
<button class="button" type="submit">Add Ticket</button>
</div>
</form>  
</div>
</body>
</html>