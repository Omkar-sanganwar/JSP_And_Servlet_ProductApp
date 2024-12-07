<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
    <h2>Update Product</h2>
    <form action="update-product" method="post">
        <input type="hidden" name="pid" value="${param.pid}">
        Product Name: <input type="text" name="name" value="${param.name}"><br><br>
        Price: <input type="text" name="price" value="${param.price}"><br><br>
        Quantity: <input type="text" name="qty" value="${param.qty}"><br><br>
        Category: <input type="text" name="category" value="${param.category}"><br><br>
        <input type="submit" value="Update Product">
    </form>
</body>
</html>
