INSERT INTO PRODUCT(ID, NAME, DESCRIPTION) VALUES (1, 'Stickers pack', 'A pack of rad stickers to display on your laptop or wherever you feel like. Show your love for Apache APISIX');
INSERT INTO PRODUCT(ID, NAME, DESCRIPTION) VALUES (2, 'Lapel pin', 'With this Powered by Apache APISIX lapel pin, support your favorite API Gateway and let everybody know about it.');
INSERT INTO PRODUCT(ID, NAME, DESCRIPTION) VALUES (3, 'Tee-Shirt', 'The classic geek product! At a conference, at home, at work, this tee-shirt will be your best friend.');


INSERT INTO PRICING(PRODUCT_ID, PRICE) VALUES (1, 0.49);
INSERT INTO PRICING(PRODUCT_ID, PRICE) VALUES (2, 1.49);
INSERT INTO PRICING(PRODUCT_ID, PRICE) VALUES (3, 9.99);

INSERT INTO NEWS(ID, LABEL, `TIMESTAMP`) VALUES(1, 'New promo on stickers', '2022-10-22 08:00:00');
