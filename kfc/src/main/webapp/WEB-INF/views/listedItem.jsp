<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- <marquee width="140%"> -->
<c:set var="username" scope="session" value="${username}"/>
<h1>${username}</h1> 
  <c:forEach items="${productList}" var="product">

<!-- <article class="col-lg-2 col-lg-offset-1 col-sm-2 col-sm-offset-1" style="margin-top: 20px"> -->


<div class="img col-lg-3 col-lg-offset-3 col-sm-5 col-sm-offset-4" style="margin-top: 20px">
  <a href="<spring:url value="cart/${product.id }"/>">
    <img src="<c:url value="/images/products/${product.id}.jpg"/>" alt="${product.id}" width="150" height="150">
  </a>
  <div class="desc">
  <ul style="list-style-type:none">
  <li class="span2"><h5 style="color: blue" >${product.name}</h5>
  <h6>Price:${product.price}</h6></li></ul>
  </div>
</div>
<!-- 
</article> -->

</c:forEach> 

<!-- </marquee> -->