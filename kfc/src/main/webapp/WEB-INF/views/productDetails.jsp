<h2 align="center" style="margin-top: 0em; margin-bottom: -2em;">${product.name}</h2>


<div style="margin: 0px 10px 0px 300px">

<form:form>
<table>
<tr>
<td>
<img src="<c:url value="/images/products/${product.id}.jpg"/>" alt="${product.id}" width="200" height="200">
</td>
<tr><td>Product Name : ${product.name}</td><br></tr>
<tr><td>Product Description : ${product.description}</td><br></tr>
<tr><td>Product Price : ${product.price}</td><br></tr>
<tr><td>Product Available : ${product.product_Stock}</td></tr>
<tr><td><a href="../addToCart/${username}/${product.id}"><input style="color:green;" type="button" name="button" value="Add To Cart"/></a></td></tr>
<tr><td><button class="btn-btn-primary" onclick="goBack()">Go Back</button></td></tr>
</table>
</form:form>
</div>


<script>
function goBack() {
    window.history.back();
}
</script>





 </body>
</html>