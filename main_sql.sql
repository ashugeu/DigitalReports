create database digitalreports;

use digitalreports;

create table users(
u_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
usertype VARCHAR(30) NOT NULL,
reg_date TIMESTAMP
);



create table userdetails(
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
u_id INT(6) UNSIGNED,
INDEX u_ind (u_id),
email VARCHAR(50) NOT NULL,
name VARCHAR(30) NOT NULL,
usertype VARCHAR(30) NOT NULL,
active_from TIMESTAMP,
FOREIGN KEY (u_id)
        REFERENCES users(u_id)
        ON DELETE CASCADE
);




INSERT INTO users (u_id,email,password,usertype) VALUES (1,"admin@iiitb.org","21232f297a57a5a743894a0e4a801fc3","admin");
INSERT INTO users (email,password,usertype) VALUES ("ashish@iiitb.org","21232f297a57a5a743894a0e4a801fc3","student");



INSERT INTO userdetails (u_id,email,name,usertype) values(1,"admin@iiitb.org","Ashish garg","Admin");



DELETE From users where u_id=1;
