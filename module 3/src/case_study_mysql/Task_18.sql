use case_study;

-- Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
create temporary table temp_khach_hang(
select khach_hang.ma_khach_hang from khach_hang
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
where year(hop_dong.ngay_lam_hop_dong) < 2021);

set sql_safe_updates = 0;
delete from hop_dong_chi_tiet 
where hop_dong_chi_tiet.ma_hop_dong in 
(select hop_dong.ma_hop_dong from hop_dong 
where hop_dong.ma_khach_hang in (select ma_khach_hang from temp_khach_hang));
set sql_safe_updates = 1;

delete from hop_dong where hop_dong.ma_khach_hang in (select ma_khach_hang from temp_khach_hang);

delete from khach_hang where khach_hang.ma_khach_hang in (select ma_khach_hang from temp_khach_hang);