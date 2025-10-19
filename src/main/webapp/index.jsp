<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Management System</title>
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
            background-color: white;
            padding: 50px;
            border-radius: 15px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            text-align: center;
            max-width: 800px;
            width: 100%;
        }
        h1 {
            color: #333;
            margin-bottom: 10px;
            font-size: 2.5em;
        }
        .subtitle {
            color: #666;
            margin-bottom: 50px;
            font-size: 1.1em;
        }
        .menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 30px;
            margin-top: 40px;
        }
        .menu-item {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 40px 20px;
            border-radius: 12px;
            text-decoration: none;
            transition: all 0.3s ease;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        .menu-item:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.3);
        }
        .menu-item-icon {
            font-size: 60px;
            margin-bottom: 15px;
        }
        .menu-item-text {
            font-size: 20px;
            font-weight: bold;
            letter-spacing: 1px;
        }
        .menu-item-desc {
            font-size: 14px;
            margin-top: 10px;
            opacity: 0.9;
        }
        .footer {
            margin-top: 50px;
            color: #999;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>📦 Order Management System</h1>
    <p class="subtitle">Manage your business efficiently with our comprehensive system</p>

    <div class="menu">
        <a href="${pageContext.request.contextPath}/clients" class="menu-item">
            <div class="menu-item-icon">👥</div>
            <div class="menu-item-text">CLIENTS</div>
            <div class="menu-item-desc">Manage customer information</div>
        </a>

        <a href="${pageContext.request.contextPath}/products" class="menu-item">
            <div class="menu-item-icon">📦</div>
            <div class="menu-item-text">PRODUCTS</div>
            <div class="menu-item-desc">Manage product catalog</div>
        </a>

        <a href="${pageContext.request.contextPath}/orders" class="menu-item">
            <div class="menu-item-icon">🛒</div>
            <div class="menu-item-text">ORDERS</div>
            <div class="menu-item-desc">Process and track orders</div>
        </a>
    </div>

    <div class="footer">
        <p>&copy; 2024 Order Management System - JEE Project FSTT</p>
    </div>
</div>
</body>
</html>