<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
.addreason
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
.reason
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
</head>
<body>   
<div class="addreason"><h1>Update Reason</h1></div>
<div class="main">
<form method="post" action="../editLoanStatusUpdate" modelAttribute="emp">
<div id="reason">
<h2>Please Enter Reason :</h2>
<input class="reason" type="text" name="reason" placeholder="Please Enter Reason Here"/><br>
<button class="button" type="submit">Update Loan status</button>
</div>
</form>  
</div>
</body>
</html>