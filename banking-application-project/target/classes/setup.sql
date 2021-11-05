drop table if exists users;
drop table if exists employees;
drop table if exists accounts;

create table if not exists users(
	userID int primary key not null,
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	social int not null,
	address varchar(100) not null,
	username varchar(10) not null,
	password varchar(10)not null,
	accountID int 

);

create table if not exists employees(
	employeeID int primary key not null,
	firstName varchar(100) not null,
	lastName varchar(100) no null,
	social int not null,
	address varchar(100) not null,
	username varchar(10) not null,
	password varchar(10) not null
);

create table if not exists accounts(
	accountID int primary key not null, 
	userID int not null,
	accountType varchar(10) not null,
	amount decimal,
	check(amount > 0.0)
);


alter table users 
add foreign key (accountID) references accounts(accountID);

alter table accounts 
add foreign key (userID) references users(userID);
