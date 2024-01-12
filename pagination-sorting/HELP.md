# Getting Started

### Spring data JPA, Pagination and sorting

**NOTE: Uses My SQL database.**

CREATE SCHEMA `pagination-sorting`;

-- Create the product table
CREATE TABLE `pagination-sorting`.product (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
price DECIMAL(10, 2)
);

-- Insert 20 entries into the product table
INSERT INTO `pagination-sorting`.product (name, price) VALUES
('Product 1', 10.99),
('Product 2', 25.49),
('Product 3', 8.75),
('Product 4', 15.99),
('Product 5', 19.50),
('Product 6', 30.00),
('Product 7', 12.25),
('Product 8', 22.75),
('Product 9', 9.99),
('Product 10', 18.49),
('Product 11', 14.25),
('Product 12', 11.99),
('Product 13', 7.50),
('Product 14', 29.99),
('Product 15', 16.75),
('Product 16', 20.49),
('Product 17', 13.25),
('Product 18', 24.75),
('Product 19', 28.99),
('Product 20', 9.99);


