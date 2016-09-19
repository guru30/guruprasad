<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file= "common-header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SignUP Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body
{
	margin:0px;
	padding:0px;
	background-image:url(images/mag.jpg);

}

.extent
{
	width:450px;
	height:450px;
	text-align:center;
	background-color:rgba(0, 0, 153,0.7);
	border-radius:4px;
	margin:0 auto;
	margin-top:150px;
}	
.extent img
{
	height:120px;
	width:120px;
	margin-top:-60px;
	margin-bottom:30px;
}
input[type="fname"]
{
       text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}
input[type="lname"]
{
    text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}
input[type="email"]
{
	text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
        }
input[type="password"]
{
	text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}


.btnd
{
	padding:18px;
	background-color:#0C3;
	border-radius:10px;
	border:none;
}
</style>
</head>
<body>
<div class="extent">
<img src=<c:url value="/images/generic_face.jpg" />>
<form>
<div class="input">
<input type="fname" name="fname" placeholder="FirstName" /><br>
<input type="lname" name="lname" placeholder="LastName" /><br>
<input type="email" name="email" placeholder="Email" /><br>
<input type="password" name="password" placeholder="password" /><br>
</div>
<br>
<button class="btnd">SIGNUP</button>
</form>
</div>
</body>
</html>
<%@ include file= "common-footer.jsp" %>