-- Connect Using SYSTEM account
 sqlplus system/oracle

-- create a new user-schema 'library' with password 'library'
 create user library identified by library
 
-- Grant new user access to database storage and tables
 grant create session, create table, resource to library;
 
-- Disconnect and connect as 'library'
disc
conn library/library

-- Create all tables and sequences

create table books 
  (
  id number(5) primary key,
  title varchar(20),
  author varchar(20),
  category varchar(20),
  status char(1)
);

create sequence book_seq start with 10000 increment by 1 nocache nocycle maxvalue 19999;

create table members
(
	id number(5) primary key,
	fname varchar(25),
	lname varchar(25),
	status char(1)
);

create sequence member_seq start with 20000 increment by 1 nocache nocycle maxvalue 29999;

create table issues 
(
    id number(5) primary key,
    book_id number(5) references books(id),
    member_id number(5) references members(id),
    issue_date date,
    est_return date,
    act_return date,
    status char(1)
);

create sequence issue_seq start with 30000 increment by 1 nocache nocycle maxvalue 39999;

-- insert few records 

insert into books values (book_seq.nextval, 'Let Us C', 'Yashwant','Java','A');
insert into books values(book_seq.nextval, 'Let Us C++', 'Yashwant', 'Java' ,'A');

insert into members values (member_seq.nextval, 'robin', 'hood', 'A');
insert into members values (member_seq.nextval, 'arrora', 'princess', 'A');

-- Commit all changes
commit;




