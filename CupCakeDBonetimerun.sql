DROP SCHEMA IF EXISTS CupCake;
CREATE SCHEMA CupCake;
Use CupCake;
;
DROP SCHEMA IF EXISTS CupCake;
CREATE SCHEMA CupCake;
Use CupCake;
;



DROP TABLE IF EXISTS users;
CREATE TABLE users
(
	userID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email varchar(255) NOT NULL,
    pass varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    balance double(10,2) NOT NULL

    );

DROP TABLE IF EXISTS cupcaketop;
CREATE TABLE cupcaketop
(
    caketopID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cakename varchar(100) NOT NULL,
    price double(10,2) NOT NULL


);

DROP TABLE IF EXISTS cupcakebot;
CREATE TABLE cupcakebot
(
    cakebotID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cakename varchar(100) NOT NULL,
    price double(10,2) NOT NULL


);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
    orderID        INT PRIMARY KEY,
    userID INT NOT NULL,
    subtotal double(10,2) NOT NULL,
    quantity INT NOT NULL,
    isordered boolean NOT NULL,
    ispaid boolean NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(userid)
);


DROP TABLE IF EXISTS orderscupcakes;
CREATE TABLE orderscupcakes
(
	orderedcakeID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderID INT NOT NULL,
    caketopID INT NOT NULL,
    cakebotID INT NOT NULL,
    price INT NOT NULL,
    FOREIGN KEY (orderID) REFERENCES orders(orderid),
    FOREIGN KEY (caketopid) REFERENCES cupcaketop(caketopid),
    FOREIGN KEY (cakebotid) REFERENCES cupcakebot(cakebotid)
);

INSERT INTO cupcaketop (cakename, price)
VALUES  ("Chocolate",    5.00),
		("Blueberry",    5.00),
		("Raspberry",    5.00),
		("Crispy",    6.00),
		("Strawberry",    6.00),
		("Rum/Raisin",    7.00),
		("Orange",    8.00),
		("Lemon",    8.00),
		("Blue cheese",    9.00);
INSERT INTO cupcakebot (cakename, price)
VALUES  ("Chocolate",    5.00),
		("Vanilla",    5.00),
		("Nutmeg",    5.00),
		("Pistacio",    6.00),
		("Almond",    7.00);

INSERT INTO users (email, pass, role, balance)
VALUES	("Memelord@pepe.io","42069", "admin",0),
		("Shrek@pepe.io","42069", "admin",0),
		("Lars@pepe.io","42069", "user",0),
        ("Lui@pepe.io","42069", "user",0),
        ("Balou@pepe.io","42069", "user",0),
        ("Robin@psomewhere.com","batman", "user",0),
        ("ThEFakeMemelord@pepe.io","42069", "user",0);


INSERT INTO orders (orderID, userID, subtotal, quantity, isordered, ispaid)
VALUES	(1, 3, 30, 3, 1, 1),
		(2, 4, 34, 3, 0, 0),
        (3, 5, 34, 3, 0, 0),
        (4, 6, 20, 4, 1, 0),
        (5, 7, 20, 5, 0, 0);

INSERT INTO orderscupcakes (orderID, caketopID, cakebotID, price)
VALUES	(1, 2, 2, 10),
		(1, 1, 3, 10),
        (1, 3, 1, 10),
        (2, 5, 3, 11),
        (2, 4, 2, 11),
        (2, 6, 2, 12),
        (3, 9, 2, 14),
        (3, 8, 4, 10),
        (3, 7, 5, 10),
        (4, 3, 2, 10),
        (4, 6, 3, 10),
        (5, 4, 1, 10),
        (5, 2, 4, 10);
