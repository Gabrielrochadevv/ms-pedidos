CREATE TABLE tbl_orders
(
    order_number  BIGINT(20) NOT NULL AUTO_INCREMENT,
    client_name   VARCHAR(100)  NOT NULL,
    order_date    DATE NULL,
    value          DECIMAL(9, 3) NOT NULL,
    delivery_status VARCHAR(20)   NOT NULL,
    PRIMARY KEY (order_number)
);