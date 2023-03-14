CREATE TABLE PRICING (
                         BRAND_ID INT,
                         START_DATE DATE,
                         END_DATE DATE,
                         PRICE_LIST VARCHAR(50),
                         PRODUCT_ID INT,
                         PRIORITY INT,
                         PRICE FLOAT,
                         CURR VARCHAR(10),
                         CONSTRAINT FK_BRAND_ID FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(ID)
);
