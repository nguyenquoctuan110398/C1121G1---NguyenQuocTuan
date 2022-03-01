-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where ((select datediff(now(), ngay_sinh)) between (18*365 + 5) and (50*365+13)) 
and dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị';