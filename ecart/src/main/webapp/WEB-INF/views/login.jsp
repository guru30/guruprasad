<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file= "common-header.jsp" %>
 <!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body
{
	margin:0px;
	padding:0px;
	background-colour:pink;
        background-image:url(images/bag.jpg);
	background-repeat:no-repeat;
	background-size:100% 700px;
}

.extent
{
	width:500px;
	height:300px;
	text-align:center;
	background-color:lavender;
	border-radius:4px;
	margin:0 auto;
	margin-top:80px;
}
.container img
{
	height:120px;
	width:120px;
position:relative;
left:50px;
	
}

input[type="user"]
{       text-align: center;
	height:40px;
	width:280px;
        padding:2px;
        margin-top: 80px;
	
}
input[type="password"]
{       text-align: center;
	height:40px;
	width:280px;
        padding:0px;
        margin-bottom: 40px;
}

.btn
{
padding:18px;
background-color:#096;
border-radius:10px;
border:none;
}
</style>
</head>

<body>
<div class="extent">
<form>
<div class="input">
<input type="user" name="username" placeholder="Username"/><br><br>
<input type="password" name="password" placeholder="Password" />
</div>
<button class="btn">LOGIN</button>

</form>
</div>
</body>
</html>
<%@ include file= "common-footer.jsp" %>
