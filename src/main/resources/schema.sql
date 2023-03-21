CREATE TABLE IF NOT EXISTS brands (
                                      ID INT AUTO_INCREMENT PRIMARY KEY,
                                      NAME VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS prices (
                                      ID INT AUTO_INCREMENT PRIMARY KEY,
                                      BRAND_ID INT NOT NULL,
                                      START_DATE DATE NOT NULL,
                                      END_DATE DATE,
                                      PRICE_LIST INT NOT NULL,
                                      PRODUCT_ID INT NOT NULL,
                                      PRIORITY INT NOT NULL,
                                      PRICE FLOAT NOT NULL,
                                      CURR VARCHAR(3) NOT NULL,
    FOREIGN KEY (BRAND_ID) REFERENCES brands(ID)
    );



INSERT INTO brands (NAME) VALUES ('ZARA');

INSERT INTO prices (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1, TIMESTAMP '2020-06-14', TIMESTAMP '2020-12-31', '1', 35455, 0, 35.50, 'EUR');
