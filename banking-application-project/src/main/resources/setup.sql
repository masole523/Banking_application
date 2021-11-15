drop table if exists users;
drop table if exists employees;
drop table if exists accounts;
drop table if exists accountsPending;

create table if not exists users(
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	social int not null,
	address varchar(100) not null,
	userName varchar(100) not null,
	userpass varchar(100) not null,
	userID serial primary key not null
);

create table if not exists employees(
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	social int not null,
	address varchar(100) not null,
	userName varchar(100) not null,
	userpass varchar(100) not null,
	empID serial primary key not null
);

create table if not exists accounts(
	accountID serial primary key not null,
	accountType varchar(10) not null,
	amount decimal not null,
	userID int not null,
	check(amount > 0.0),
	foreign key (userID) references users(userID)
);

create table if not exists accountsPending(
	accountType varchar(10) not null,
	amount decimal not null,
	userID int not null,
	approved boolean not null default 'f',
	check(amount > 0.0),
	foreign key (userID) references users(userID)
	
);
	
insert into users (firstname, lastname, social, address, username, userpass, userID)
values ('Billy', 'Bob', 111111111, '1234 Campusway St', 'billy123', 'password',default);

insert into users (firstname, lastname, social, address, username, userpass, userID)
values ('Phil', 'Smith', 111221111, '2314 Campusway St', 'phil123', 'password2',default);

insert into employees (firstname, lastname, social, address, username, userpass, empID)
values ('Deena', 'Smith', 111112222, '2314 Campusway St', 'deena123', 'password1', default);

insert into accounts (accountID, accountType, amount,userID)
values (default,  'Checking', 1000.00, 1);

insert into accounts (accountID, accountType, amount,userID)
values (default,  'Savings', 10000.00, 1);

insert into accounts (accountID, accountType, amount,userID)
values (default,  'Checking', 20000.00, 2);

insert into accountspending (accountType, amount, userid, approved)
values ('Savings', 1000.00, 2, default);


