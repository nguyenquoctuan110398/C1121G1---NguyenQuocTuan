use case_study;

-- Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với 
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ

create view update_khach_hang as
(select khach_hang.ma_khach_hang, khach_hang.ho_ten, khach_hang.ma_loai_khach, 
ifnull(dich_vu.chi_phi_thue, 0) + sum(ifnull(hop_dong_chi_tiet.so_luong, 0) * ifnull(dich_vu_di_kem.gia, 0)) as tong_tien
from loai_khach
join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where loai_khach.ten_loai_khach = 'Platinium'
group by hop_dong.ma_hop_dong
having tong_tien > 10000000);

select * from update_khach_hang;

update khach_hang set ma_loai_khach = 1
where ma_loai_khach in (select update_khach_hang.ma_loai_khach from update_khach_hang);