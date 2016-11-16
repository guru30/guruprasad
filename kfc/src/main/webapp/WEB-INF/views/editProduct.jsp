<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Product</h2>

<form:form action="../edit" method="post">
	<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
		<tr>
			<td>Product ID:</td>
			<td><input class="form-control" type="text" name="id" value="${Product.id}"></td>
		</tr>
		<tr>
			<td>Product Name:</td>
			<td><input class="form-control" type="text" name="name" value="${Product.name}"></td>
		</tr>
		<tr>
			<td>Product Description:</td>
			<td><input class="form-control" type="text" name="description" value="${Product.description}"></td>
		</tr>
		<tr>
			<td>Product Category:</td>
			<td><input class="form-control" type="text" name="category_name" value="${Product.category_name}"></td>
		</tr>
		<tr>
			<td>Product Supplier:</td>
			<td><input class="form-control" type="text" name="supplier_name" value="${Product.supplier_name}"></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input class="form-control" type="text" name="price" value="${Product.price}"></td>
		</tr>
		<tr>
			<td>Stock:</td>
			<td><input class="form-control" type="text" name="product_Stock" value="${Product.product_Stock}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input class="btn btn-success" type="submit" value="Add">
			<input class="btn btn-danger" type="reset" value="Reset"></td>
		</tr>

	</table>

</form:form>