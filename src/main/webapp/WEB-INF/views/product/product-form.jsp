<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>${product != null ? 'Edit Product' : 'Add Product'}</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .container {
            max-width: 700px;
            width: 100%;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.3);
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
            padding-bottom: 15px;
            border-bottom: 3px solid #667eea;
            text-align: center;
        }
        .form-group {
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #555;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 12px;
            border: 2px solid #e0e0e0;
            border-radius: 6px;
            font-size: 16px;
            transition: border-color 0.3s;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        textarea {
            resize: vertical;
            min-height: 100px;
        }
        input:focus,
        textarea:focus {
            outline: none;
            border-color: #667eea;
        }
        .btn {
            padding: 14px 30px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            font-weight: 600;
            transition: all 0.3s;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        .btn-submit {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        .btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        .btn-cancel {
            background-color: #999;
            color: white;
            margin-left: 10px;
        }
        .btn-cancel:hover {
            background-color: #777;
        }
        .button-group {
            margin-top: 30px;
            text-align: center;
        }
        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${product != null ? '✏️ Edit Product' : '➕ Add New Product'}</h1>

    <form action="${pageContext.request.contextPath}/products" method="post">
        <c:if test="${product != null}">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="${product.id}"/>
        </c:if>

        <div class="form-group">
            <label for="productName">📦 Product Name *</label>
            <input type="text" id="productName" name="productName" value="${product != null ? product.productName : ''}" required placeholder="Enter product name"/>
        </div>

        <div class="form-group">
            <label for="description">📝 Description *</label>
            <textarea id="description" name="description" required placeholder="Enter product description">${product != null ? product.description : ''}</textarea>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="price">💰 Price ($) *</label>
                <input type="number" id="price" name="price" step="0.01" min="0" value="${product != null ? product.price : ''}" required placeholder="0.00"/>
            </div>

            <div class="form-group">
                <label for="stock">📊 Stock Quantity *</label>
                <input type="number" id="stock" name="stock" min="0" value="${product != null ? product.stock : ''}" required placeholder="0"/>
            </div>
        </div>

        <div class="form-group">
            <label for="category">🏷️ Category *</label>
            <input type="text" id="category" name="category" value="${product != null ? product.category : ''}" required placeholder="e.g., Electronics, Furniture, Accessories"/>
        </div>

        <div class="button-group">
            <button type="submit" class="btn btn-submit">💾 Save Product</button>
            <a href="${pageContext.request.contextPath}/products" class="btn btn-cancel">❌ Cancel</a>
        </div>
    </form>
</div>
</body>
</html>