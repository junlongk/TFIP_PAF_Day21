use hotelreservation;

/*
# create customer data

insert into customer (first_name, last_name) values ('James', 'Bond');
insert into customer (first_name, last_name) values ('Spongebob', 'Squarepants');
insert into customer (first_name, last_name) values ('Patrick', 'Star');
insert into customer (first_name, last_name) values ('Kway Teow', 'Char');
insert into customer (first_name, last_name) values ('Jim Peng', 'Hang');

# create room type with prices

insert into room (room_type, price) values ('standard', 100);
insert into room (room_type, price) values ('deluxe', 101);
insert into room (room_type, price) values ('president', 102);
insert into room (room_type, price) values ('suite', 103);
*/

create table customer2 (
	id int not null auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    primary key (id)
);

insert into customer2 (first_name, last_name) values ('James', 'Bond');
insert into customer2 (first_name, last_name) values ('Spongebob', 'Squarepants');
insert into customer2 (first_name, last_name) values ('Patrick', 'Star');
insert into customer2 (first_name, last_name) values ('Kway Teow', 'Char');
insert into customer2 (first_name, last_name) values ('Jim Peng', 'Hang');
insert into customer2 (first_name, last_name) values ('Desmond', 'Koh');
insert into customer2 (first_name, last_name) values ('Pei Ling', 'Ting');
insert into customer2 (first_name, last_name) values ('Pritam', 'Singh');
insert into customer2 (first_name, last_name) values ('Edwin', 'Tong');

create table customer2 as select * from customer;
select * from customer2;

update customer2
set first_name = 'Hsien Loong',
last_name = 'Lee'
where id = 9;

delete from customer2 where id = 6;

# retrieve customer record
select * from customer;

# retrieve room type and prices
select * from room;

/*
# create reservations data

insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (1, 1, '2023-03-01', '2023-03-02', 100);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (1, 1, '2023-03-02', '2023-03-03', 101);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (5, 2, '2023-03-03', '2023-03-04', 102);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (3, 3, '2023-03-04', '2023-03-05', 103);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (4, 4, '2023-03-05', '2023-03-06', 104);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (2, 1, '2023-03-06', '2023-03-07', 105);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (4, 2, '2023-03-07', '2023-03-08', 106);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (5, 3, '2023-03-08', '2023-03-09', 107);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (1, 4, '2023-03-09', '2023-03-10', 108);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) values (1, 1, '2023-03-10', '2023-03-11', 109);
*/

/*
insert into customer (first_name, last_name) values ('Desmond', 'Koh');
insert into customer (first_name, last_name) values ('Pei Ling', 'Ting');
insert into customer (first_name, last_name) values ('Pritam', 'Singh');
insert into customer (first_name, last_name) values ('Edwin', 'Tong');
*/

# retrieve reservation records
select * from reservation;

# retrieve reservation records with customer id and room types using joins
SELECT 
    resv.id resv_id,
    cust.id cust_id,
    cust.first_name,
    cust.last_name,
    resv.start_date,
    resv.end_date,
    resv.total_cost,
    room.price,
    room.room_type
FROM
    customer cust
        INNER JOIN
    reservation resv ON cust.id = resv.customer_id
        INNER JOIN
    room ON resv.room_id = room.id;
    
# retrieve length of first name of customer
select *, length(first_name) from customer;


select * from reservation
where start_date between '2001-02-01' and '2023-02-28';

select 'Jan 2022' as period, room_id, count(*) cnt from reservation
where start_date between '2022-01-01' and '2022-01-30'
group by room_id
order by cnt desc;

select 'March 2023' as period, room_id, count(*) cnt from reservation
where start_date between '2023-03-01' and '2023-03-31'
group by room_id
order by cnt desc;

select 'Jan 2022' as period, room_id, count(*) cnt from reservation
where start_date between '2022-01-01' and '2022-01-30'
group by room_id
union
select 'March 2023' as period, room_id, count(*) cnt from reservation
where start_date between '2023-03-01' and '2023-03-31'
group by room_id;


insert into employee(first_name, last_name, salary) values ('Desmond', 'Koh', 5000);
insert into employee(first_name, last_name, salary) values ('Eddie', 'Lim', 6000);
insert into employee(first_name, last_name, salary) values ('James', 'Pang', 7000);

select * from employee;

insert into dependant(employee_id, dependant_name, relationship, birth_date) values (1, 'Koh Jing Xing', 'father', '2015-01-01');
insert into dependant(employee_id, dependant_name, relationship, birth_date) values (1, 'Koh Jing Jing', 'father', '2016-01-01');
insert into dependant(employee_id, dependant_name, relationship, birth_date) values (2, 'Lim Esther', 'father', '2015-01-15');
insert into dependant(employee_id, dependant_name, relationship, birth_date) values (3, 'Pang Gang Lou', 'father', '2017-12-01');

select * from dependant;

select e.id emp_id, e.first_name, e.last_name, e.salary,
d.id dep_id, d.dependant_name, d.relationship, d.birth_date from employee e
inner join dependant d
on e.id = d.employee_id


