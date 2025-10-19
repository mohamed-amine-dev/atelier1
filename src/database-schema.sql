-- Create database
CREATE DATABASE IF NOT EXISTS atelier1;
USE atelier1;

-- Create clients table
CREATE TABLE IF NOT EXISTS clients (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    adress VARCHAR(255),
    phoneNumber VARCHAR(20)
    );

-- Create products table
CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        productName VARCHAR(100) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    category VARCHAR(50)
    );

-- Create orders table
CREATE TABLE IF NOT EXISTS orders (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      clientId BIGINT NOT NULL,
                                      dateCommand TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      totalAmount DOUBLE DEFAULT 0,
                                      FOREIGN KEY (clientId) REFERENCES clients(id) ON DELETE CASCADE
    );

-- Create orderlines table
CREATE TABLE IF NOT EXISTS orderlines (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          productId BIGINT NOT NULL,
                                          orderId BIGINT NOT NULL,
                                          unitPrice DOUBLE NOT NULL,
                                          quantity INT NOT NULL,
                                          subTotal DOUBLE NOT NULL,
                                          FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE,
    FOREIGN KEY (orderId) REFERENCES orders(id) ON DELETE CASCADE
    );

-- Insert sample data for clients
INSERT INTO clients (name, email, adress, phoneNumber) VALUES
                                                           ('John Doe', 'john.doe@email.com', '123 Main St, New York', '+1-555-0101'),
                                                           ('Jane Smith', 'jane.smith@email.com', '456 Oak Ave, Los Angeles', '+1-555-0102'),
                                                           ('Bob Johnson', 'bob.johnson@email.com', '789 Pine Rd, Chicago', '+1-555-0103'),
                                                           ('Alice Williams', 'alice.williams@email.com', '321 Elm St, Houston', '+1-555-0104'),
                                                           ('Charlie Brown', 'charlie.brown@email.com', '654 Maple Dr, Phoenix', '+1-555-0105');

-- Insert sample data for products
INSERT INTO products (productName, description, price, stock, category) VALUES
                                                                            ('Laptop HP', 'High-performance laptop with 16GB RAM', 899.99, 25, 'Electronics'),
                                                                            ('iPhone 14', 'Latest Apple smartphone', 999.99, 50, 'Electronics'),
                                                                            ('Office Chair', 'Ergonomic office chair with lumbar support', 249.99, 100, 'Furniture'),
                                                                            ('Wireless Mouse', 'Bluetooth wireless mouse', 29.99, 200, 'Accessories'),
                                                                            ('USB-C Cable', 'High-speed charging cable', 15.99, 500, 'Accessories'),
                                                                            ('Monitor 27"', '4K UHD monitor', 399.99, 30, 'Electronics'),
                                                                            ('Keyboard Mechanical', 'RGB mechanical gaming keyboard', 129.99, 75, 'Accessories'),
                                                                            ('Desk Lamp', 'LED desk lamp with adjustable brightness', 45.99, 150, 'Furniture'),
                                                                            ('Webcam HD', '1080p HD webcam', 79.99, 60, 'Electronics'),
                                                                            ('Backpack', 'Laptop backpack with multiple compartments', 59.99, 120, 'Accessories');

-- Insert sample data for orders
INSERT INTO orders (clientId, dateCommand, totalAmount) VALUES
                                                            (1, '2024-10-01 10:30:00', 1149.98),
                                                            (2, '2024-10-03 14:15:00', 249.99),
                                                            (3, '2024-10-05 09:45:00', 545.97),
                                                            (1, '2024-10-08 16:20:00', 75.98),
                                                            (4, '2024-10-10 11:00:00', 1399.98);

-- Insert sample data for orderlines
INSERT INTO orderlines (productId, orderId, unitPrice, quantity, subTotal) VALUES
-- Order 1
(1, 1, 899.99, 1, 899.99),
(4, 1, 29.99, 1, 29.99),
(5, 1, 15.99, 1, 15.99),
(7, 1, 129.99, 2, 259.98),

-- Order 2
(3, 2, 249.99, 1, 249.99),

-- Order 3
(6, 3, 399.99, 1, 399.99),
(8, 3, 45.99, 1, 45.99),
(9, 3, 79.99, 1, 79.99),
(5, 3, 15.99, 1, 15.99),
(4, 3, 29.99, 1, 29.99),

-- Order 4
(4, 4, 29.99, 1, 29.99),
(5, 4, 15.99, 1, 15.99),
(10, 4, 59.99, 1, 59.99),

-- Order 5
(2, 5, 999.99, 1, 999.99),
(6, 5, 399.99, 1, 399.99);