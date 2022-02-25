use ss2_quan_li_ban_hang;

-- Thêm dữ liệu customer
insert into customer(c_name, c_age)
values	('Minh Quan', 10),
		('Ngoc Oanh', 20),
        ('Hong Ha', 50);
        
-- Thêm dữ liệu order
insert into `order`(c_id, o_date)
values	(1, '2006-03-21'),
		(2, '2006-03-23'),
        (1, '2006-03-16');
        
-- Thêm dữ liệu product
insert into product(p_name, p_price)
values	('May Giat', 3),
		('Tu Lanh', 5),
        ('Dieu Hoa', 7),
        ('Quat', 1),
        ('Bep Dien', 2);
        
-- Thêm dữ liệu order detail
insert into order_detail
values	(1, 1, 3),
		(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
        
-- Hiển thị các thông tin gồm oID, oDate của tất cả các hóa đơn trong bảng Order
select o_id, o_date from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select `order`.o_id, customer.c_name, product.p_name from customer
join `order` on customer.c_id = `order`.c_id
join order_detail on `order`.o_id = order_detail.o_id
join product on order_detail.p_id = product.p_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.c_name from customer
where customer.c_id not in (select `order`.c_id from `order`);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.o_id, `order`.o_date, sum(order_detail.od_QTY * product.p_price) as o_total_price from `order`
join order_detail on `order`.o_id = order_detail.o_id
join product on order_detail.p_id = product.p_id
group by `order`.o_id;