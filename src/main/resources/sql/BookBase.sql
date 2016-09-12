CREATE DATABASE BookBase;
CREATE TABLE books (
	BookID bigint(20) NOT NULL AUTO_INCREMENT,
    Title varchar(100) NOT NULL,
    Authors varchar(100) NOT NULL,
    Categories varchar(100),
    Publisher varchar(100) NOT NULL,
    Description longtext,
    ISBN bigint(20),
    PRIMARY KEY (BookID),
    KEY IndexTitle (Title) USING BTREE,
    KEY IndexISBN (ISBN) USING BTREE);