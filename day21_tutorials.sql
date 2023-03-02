create database leisure;

use leisure;

create table tutorials(
	id				int not null auto_increment,
    title			varchar(100) not null,
    author  		varchar(80) not null,
    submission_date date,
    constraint	 	pk_tutorial_id primary key (id)
);

/*
insert into tutorials (title, author, submission_date) values ('CS101', 'Ali', '2023-01-30');
insert into tutorials (title, author, submission_date) values ('CS102', 'Aliba', '2023-01-09');
insert into tutorials (title, author, submission_date) values ('CS103', 'Alibaba', '2023-01-28');
insert into tutorials (title, author, submission_date) values ('CS104', 'Becky', '2023-01-30');
insert into tutorials (title, author, submission_date) values ('CS105', 'Charlie', '2023-02-04');
insert into tutorials (title, author, submission_date) values ('CS106', 'Dog', '2019-01-30');
insert into tutorials (title, author, submission_date) values ('CS107', 'Zebra', '2013-01-30');
insert into tutorials (title, author, submission_date) values ('CS108', 'Giraffe', '2006-01-30');
insert into tutorials (title, author, submission_date) values ('CS109', 'Cat', '1992-01-30');
insert into tutorials (title, author, submission_date) values ('CS110', 'Mouse', '2023-11-30');
insert into tutorials (title, author, submission_date) values ('CS111', 'Rat', '2022-01-17');
insert into tutorials (title, author, submission_date) values ('CS112', 'Horse', '2023-06-30');
insert into tutorials (title, author, submission_date) values ('CS113', 'Tiger', '2000-01-30');
insert into tutorials (title, author, submission_date) values ('CS114', 'Ox', '1995-01-30');
insert into tutorials (title, author, submission_date) values ('CS115', 'Lion', '1996-01-30');
insert into tutorials (title, author, submission_date) values ('CS116', 'Tiger', '1997-01-30');
insert into tutorials (title, author, submission_date) values ('CS117', 'Cheetah', '1998-01-30');
insert into tutorials (title, author, submission_date) values ('CS118', 'Jaguar', '1999-01-30');
insert into tutorials (title, author, submission_date) values ('CS119', 'Tesla', '2017-01-28');
*/

select a.id, a.title, a.author, a.submission_date
from tutorials a
where a.author like 'B%';

select a.*
from tutorials a
where submission_date > '2000-01-31' and submission_date < '2023-01-01';