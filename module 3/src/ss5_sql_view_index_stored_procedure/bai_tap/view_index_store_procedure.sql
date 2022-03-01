create database view_index_store_procedure;

use view_index_store_procedure;

create table Products(
id int not null auto_increment,
product_code varchar(50),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(50),
primary key(id)
);
insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
values	('T1', 'coca', 10000, '4', 'chai', 'ok'),
		('T2', 'pepsi', 10000, '3', 'chai', 'nice'),
        ('T3', 'sprite', 10000, '5', 'lon', 'ok'),
        ('T4', 'nước lọc', 5000, '10', 'chai', 'ok'),
        ('T5', 'trà xanh', 10000, '4', 'chai', 'ok');

-- step 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index idx_product_code on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index idx_product_name_and_price on products(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where product_code = 4;

drop index idx_product_code on products;
drop index idx_product_name_and_price on products;
-- So sánh câu truy vấn trước và sau khi tạo index

explain select * from products where product_name = 'coca' and product_price = 10000;



-- Step 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view products_views as
select product_code, product_name, product_price, product_status 
from products;

select * from products_views;

-- Tiến hành sửa đổi view
alter view products_views as
select * from products
where product_price = 10000;

drop view products_views;


-- Step 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_info_products()
begin
	select * from products;
end //
delimiter ;

call get_info_products;

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(product_code varchar(50), product_name varchar(50),
product_price double, product_amount int, product_description varchar(50), product_status varchar(50))
begin
	insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
    values	(product_code, product_name, product_price, product_amount, product_description, product_status);
end //
delimiter ;

call add_product('T10', 'fanta', 10000, '4', 'lon', 'nice');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_product(id int, `code` varchar(50), `name` varchar(50), price double, amount int,
`description` varchar(50), `status` varchar(50))
begin
	update products
	set products.product_code = `code`,
		products.product_name = `name`,
        products.product_price = price,
        products.product_amount = amount,
        products.product_description = `description`,
        products.product_status = `status`
	where products.id = id ;
end //
delimiter ;

call edit_product('1', 'T20', 'coca', 10000, '4', 'chai', 'ok');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product(id int)
begin
	delete from products
    where products.id = id;
end //
delimiter ;

call delete_product(4);