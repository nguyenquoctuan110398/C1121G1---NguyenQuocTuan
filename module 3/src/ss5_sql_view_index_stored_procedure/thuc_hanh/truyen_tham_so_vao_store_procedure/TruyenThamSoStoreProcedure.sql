use classicmodels;

-- Tham số loại IN
delimiter //
create procedure getCusByID(in cusNum int(11))
begin
	select * from customers where customers.customerNumber = cusNum;
end //
delimiter ;

call getCusByID(175);

-- Tham số loại OUT
delimiter //
create procedure GetCustomersCountByCity(
in in_city varchar(50), 
out total int
)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end //
delimiter ;

call GetCustomersCountByCity('lyon', @total);
select @total;

-- Tham số loại inout
delimiter //
create procedure SetCounter(
	inout counter int,
    in inc int
)
begin
	set counter = counter + inc;
end //
delimiter ;

set @counter = 1;
call SetCounter(@counter, 1);
CALL SetCounter(@counter, 1);
CALL SetCounter(@counter, 5);
SELECT @counter;