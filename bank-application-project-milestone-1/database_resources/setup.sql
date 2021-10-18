drop table if exists users;
drop table if exists employees;
drop table if exists accounts;
drop table if exists bank;

create table if not exists users(
	userID int primary key,
	firstName varchar(100),
	lastName varchar(100),
	social int,
	address varchar(100),
	username varchar(10),
	password varchar(10),
	accountID int
);

create table if not exists employees(
	employeeID int primary key,
	firstName varchar(100),
	lastName varchar(100),
	social int,
	address varchar(100),
	username varchar(10),
	password varchar(10)
);

create table if not exists accounts(
	accountID int primary key, 
	userID int,
	accountType varchar(10),
	amount decimal
);

create table if not exists bank(
	id serial primary key,
	name_of varchar(100),
	address varchar(100)
);
