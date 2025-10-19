<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Order</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 10px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }
        .btn-submit {
            background-color: #4CAF50;
            color: white;
        }
        .btn-cancel {
            background-color: #999;
            color: white;
        }
        .btn:hover {
            opacity: 0.8;
        }
        .info {
            background-color: #e7f3fe;
            border-left: 4px solid #2196F3;
            padding: 10px;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Create New Order</h1>

    <form action="${pageContext.request.contextPath}/orders" method="post">
        <div class="form-group">
            <label for="clientId">Select Client:</label>
            <select id="clientId" name="clientId" required>
                <option value="">-- Select a Client --</option>
                <c:forEach var="client" items="${clients}">
                    <option value="${client.id}">${client.name} (${client.email})</option>
                </c:forEach>
            </select>
        </div>

        <div class="info">
            <strong>Note:</strong> After creating the order, you'll be able to add products to it from the order details page.
        </div>

        <div style="margin-top: 20px;">
            <button type="submit" class="btn btn-submit">Create Order</button>
            <a href="${pageContext.request.contextPath}/orders" class="btn btn-cancel">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>