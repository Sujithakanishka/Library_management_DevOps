CREATE TABLE Admin (
    adminid INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50)
);
INSERT INTO Admin(username,password)
VALUES('admin','admin123');

CREATE TABLE Books(
    bookid INT AUTO_INCREMENT PRIMARY KEY,
    bookname VARCHAR(50),
    author VARCHAR(50),
    category VARCHAR(50),
    quantity INT,
    bookstatus VARCHAR(20) DEFAULT 'Available'
);


CREATE TABLE Students(
     studentid int PRIMARY KEY, 
     username varchar(20),
     email varchar(50),
     password varchar(20));

CREATE TABLE Borrow(
    borrowid INT AUTO_INCREMENT PRIMARY KEY,
    bookid INT,
    studentid INT,
    borrowdate DATE,
    returndate DATE,
    bookstatus VARCHAR(20),

    FOREIGN KEY (bookid) REFERENCES Books(bookid),
    FOREIGN KEY (studentid) REFERENCES Students(studentid)
);

