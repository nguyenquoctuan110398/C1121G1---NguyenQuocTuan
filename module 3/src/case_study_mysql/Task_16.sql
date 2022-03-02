use case_study;

-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

create temporary table nhan_vien_can_xoa(
select nhan_vien.ma_nhan_vien from nhan_vien 
where nhan_vien.ma_nhan_vien not in
(select nhan_vien.ma_nhan_vien from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021));

delete from nhan_vien where nhan_vien.ma_nhan_vien in
(select nhan_vien_can_xoa.ma_nhan_vien from nhan_vien_can_xoa);

select nhan_vien_can_xoa.ma_nhan_vien from nhan_vien_can_xoa;

-- select nhan_vien.ma_nhan_vien from nhan_vien 
-- where nhan_vien.ma_nhan_vien not in
-- (select nhan_vien.ma_nhan_vien from nhan_vien
-- join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
-- where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021);

-- call mysqlbinlog binary_log_file > query_log.sql;