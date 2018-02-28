/* 
DataBase Name: DB
USERNAME=root
PASSWORD=root
*/
create database db;
use db;

create table student
(
Roll_no int auto_increment,
first_name varchar(50),
last_name varchar(50),
email varchar(50),
gender varchar(6),
date_of_birth varchar(50),
address varchar(50),
contact_no varchar(15),
CONSTRAINT STUDENT_PK PRIMARY KEY (Roll_no)
);


create table admin(user varchar(20),password varchar(20));
insert into admin(user,password) values ("admin","admin");

