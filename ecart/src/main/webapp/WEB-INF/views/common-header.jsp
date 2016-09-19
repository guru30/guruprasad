<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!DOCTYPE html>
<html lang="en">
<head>
<title>CARREFOUR</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
header
    {
	 background-color:#DA70D6;
	 width:1264px;
	 height:160px;
	 border:solid blue;
	 margin:10px 80px 50px 50px;
	 padding:10px;s
	 color:white;
	 position:relative;
	 right:50px;
    }
.col-100 
    {
	 width:100%;
	 height:100px;
	 clear:both;
	 display:table;
	}
.col-80
    {
	 width:95%;
	 height:20px;
	 float:left;
	 clear:both;
	 margin:0px;
	}
.col-45
    {
	 width:25%;
	 height:80px;
	 float:right;
	 clear:both;
	 padding:2px;
     margin:0px;	
     text-align: right;	 
	}
	.img{
	 padding:0px;
	 margin:0px 0px 0px 10px;
	 }
input[type="text"]
    {    position:relative;
        left:130px;
	 width:750px;
          top:21px;
	 height:37px;
       border-radius:10px;
}
.navbar{

    width: 1265px;
    position:relative;
    left:-60px;
    margin-top: -50px;
    margin-left: 60px;
    margin-right: 300px;
background-color:yellow;
}
p
{
font-color:red;
font-size:120%;
font-type:italic;
    }
.sin
{
width:40px;
height:20px;
 align:center;
position:relative;
top:-67px;
left:995px;
}
</head>
</style>
<body>
<header>
<div class="col-100">
<div class="col-80">
<img src=<c:url value="/images/timthumb.jpg" /> width="200" height="140">
<label><input type="text" value=""></label>
<div class="sin">
<button type="button" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span> Search
    </button>
</div>
</div>
<div class="col-45">
<label><img src=<c:url value="/images/fb1.png" /> class="img" width="40%" height="59px"></label><br>
<label><img src=<c:url value="/images/TWITTER.png" />  width="40%" height="59px"></label>
</div>
</div>
</header>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Carrefour</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">

          <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Mobiles & Tablets</a></li>
          <li><a href="#">Laptops & Accesories</a></li>
          <li><a href="#">Men's & Women's Wear </a></li>
<li><a href="#">Bags & Lauggages</a></li>
<li><a href="#">Mens & Womens Watches</a></li>
<li><a href="#">Sports Accessories</a></li>
        </ul>
      </li>
        <li><a href="contactus">Contact Us</a></li>
<li><a href="aboutus">About</a></li>
<li class="active"><a href="home">Home</a></li>

      </ul>
      <ul class="nav navbar-nav navbar-right">
<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Your Cart</a></li>
   <li><a href="#"><span class="glyphicon glyphicon-bell"></span> Notifications</a></li>
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
<li><a href="signup"><span class="glyphicon glyphicon-share">Sign Up</span></li>
    </ul>
    </div>
  </div>
</nav>
</body>
</html>