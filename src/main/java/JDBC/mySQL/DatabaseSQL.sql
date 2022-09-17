CREATE DATABASE IF NOT EXISTS web_project;
USE web_project;


CREATE TABLE IF NOT EXISTS bucket (
                                      id INT PRIMARY KEY,
                                      created_date TIMESTAMP,
                                      FOREIGN KEY(id) REFERENCES user(id)
    );
CREATE TABLE IF NOT EXISTS product (
                                       id INT PRIMARY KEY auto_increment,
                                       name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT NULL,
    price DOUBLE NOT NULL,
    image longtext
    );

CREATE TABLE IF NOT EXISTS bucket_product(
                                             bucket_id INT NOT NULL,
                                             product_id INT NOT NULL,
                                             CONSTRAINT id PRIMARY KEY (bucket_id, product_id),
    FOREIGN KEY(bucket_id) REFERENCES bucket(id),
    FOREIGN KEY(product_id) REFERENCES product(id)
    );
