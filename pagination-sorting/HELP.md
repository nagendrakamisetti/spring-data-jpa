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
('Product A', 10.99),
('Product A', 25.49),
('Product C', 8.75),
('Product D', 15.99),
('Product E', 19.50),
('Product F', 30.00),
('Product G', 12.25),
('Product H', 22.75),
('Product I', 9.99),
('Product J', 18.49),
('Product K', 14.25),
('Product L', 11.99),
('Product M', 7.50),
('Product N', 29.99),
('Product O', 16.75),
('Product P', 20.49),
('Product Q', 13.25),
('Product R', 24.75),
('Product S', 28.99),
('Product S', 9.99);


