-- Tạo view
create view customer_views as
select customerNumber, customerName, phone
from customers;

select * from customer_views;


-- Cập nhật view
create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';

select * from customer_views;

-- Xóa view
drop view customer_views;