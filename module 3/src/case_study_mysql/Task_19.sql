use case_study;

-- Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
create view dich_vu_can_cap_nhat_gia as
(select dich_vu_di_kem.ma_dich_vu_di_kem, hop_dong.ma_hop_dong,
sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from hop_dong
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = '2020'
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem > 10);
-- drop view dich_vu_can_cap_nhat_gia;
select * from dich_vu_can_cap_nhat_gia;

set sql_safe_updates = 0;
update dich_vu_di_kem set gia = gia * 2 
where ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from dich_vu_can_cap_nhat_gia);
set sql_safe_updates = 1;