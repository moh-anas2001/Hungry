CREATE DATABASE hungry;

USE hungry;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(100) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE food_items (
  item_id INT AUTO_INCREMENT,
  item_name VARCHAR(100) NOT NULL,
  item_description VARCHAR(255) NOT NULL,
  item_price DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (item_id)
);

CREATE TABLE orders (
  order_id INT AUTO_INCREMENT,
  user_id INT NOT NULL,
  order_date DATETIME NOT NULL,
  order_status ENUM('pending', 'processing', 'delivered') NOT NULL DEFAULT 'pending',
  total_amount DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_items (
  order_item_id INT AUTO_INCREMENT,
  order_id INT NOT NULL,
  item_id INT NOT NULL,
  quantity INT NOT NULL,
  item_price DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (order_item_id),
  FOREIGN KEY (order_id) REFERENCES orders(order_id),
  FOREIGN KEY (item_id) REFERENCES food_items(item_id)
);
