<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file= "common-header.jsp" %>
<!DOCTYPE html>
 <%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	background-size:100% 1000px;

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
input[path="fname"]
{
       text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}
input[path="lname"]
{
    text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}
input[path="email"]
{
	text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
        }
input[path="password"]
{
	text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}

input[path="mobile"]
{
	text-align: center;
	height:30px;
	width:240px;
        padding:2px;
        margin-top: 40px;
}

input[path="address"]
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
.btnd1
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
<h2> Please fill the details</h2>
 <form:form action="${pageContext.request.contextPath}/signup" method="post" commandName="user">
				    <div class="span9 margin-top">
                   <div class="span9 center margin-bottom"> 
					<h3>Registration Form</h3>
					</div>
				   
				  <div class="span3 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">Name</label><form:errors path="name" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
            				<form:input path="name" id="name" class="form-Control"/>
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Email</label>
						   <form:errors path="email" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="email" id="email" class="form-Control"/>
						</div>
					  </div>	
					  <div class="control-group">
						<label class="control-label">Password</label>
					     <form:errors path="password" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="password" id="password" class="form-Control"/>
						</div>
					  </div>	
					  <div class="control-group">
						<label class="control-label">Mobile</label>
					     <form:errors path="mobile" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="mobile" id="mobile" class="form-Control"/>
						</div>
					  </div>					  
					  				<div class="control-group">
						<label class="control-label">address</label>
					     <form:errors path="address" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="address" id="address" class="form-Control"/>
						</div>
					  </div>			  
					  					  
					  					  </div>
					  		  
					  </div>
					  <div class="span8 center">
					  			<input type="submit" value="submit" class="btn btn-primary"  />
							  <a href="<c:url value="/" />" class="btn btn-danger margin-left25">Cancel</a>
								</div>
								</form:form>
</div>
</body>
</html>
<%@ include file= "common-footer.jsp" %>