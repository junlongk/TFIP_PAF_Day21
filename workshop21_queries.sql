# WORKSHOP 21

use northwind;

# Get list of all customers
# GET /api/customers
select id customer_id, first_name, last_name, company, job_title from customers limit 5 offset 0;

# Get details of a customer with the customer's id
# GET /api/customer/<customer_id>
select id customer_id, first_name, last_name, company, job_title from customers where id = 1;

# Get all orders for a customer
# GET /api/customer/<customer_id>/orders
select customer_id, id order_id, ship_name, ship_address, paid_date, order_date, shipped_date from orders where customer_id = 1;

# REDUNDANT TO INNER JOIN (USE ABOVE QUERY INSTEAD)
select c.id customer_id, o.id order_id, o.ship_name, o.ship_address, o.paid_date, o.order_date, o.shipped_date from orders as o
inner join customers as c
on o.customer_id = c.id
where c.id = 30;