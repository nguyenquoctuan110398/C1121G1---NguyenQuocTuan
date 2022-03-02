use case_study;

-- Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng),
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select hop_dong.ma_hop_dong, nhan_vien.ho_ten as ho_ten_nhan_vien, khach_hang.ho_ten as ho_ten_khach_hang,
khach_hang.so_dien_thoai, dich_vu.ma_dich_vu, dich_vu.ten_dich_vu,
sum(ifnull(hop_dong_chi_tiet.so_luong, 0)) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
right join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
where hop_dong.ma_hop_dong in 
(select hop_dong.ma_hop_dong from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2020' and month(hop_dong.ngay_lam_hop_dong) between 10 and 12)
and hop_dong.ma_hop_dong not in 
(select hop_dong.ma_hop_dong from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2021' and month(hop_dong.ngay_lam_hop_dong) between 1 and 6)
group by hop_dong.ma_hop_dong;