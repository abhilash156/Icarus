CREATE DATABASE IF NOT EXISTS BookBase;
USE BookBase;
CREATE TABLE IF NOT EXISTS books (
	BookID bigint(20) NOT NULL AUTO_INCREMENT,
    Title longtext NOT NULL,
    Authors longtext NOT NULL,
    Categories longtext,
    Publisher longtext NOT NULL,
    Description longtext,
    ISBN bigint(20),
    PRIMARY KEY (BookID),
    KEY IndexISBN (ISBN) USING BTREE);