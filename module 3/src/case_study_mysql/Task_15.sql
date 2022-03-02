use case_study;

-- Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan,
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan,
nhan_vien.so_dien_thoai, nhan_vien.dia_chi from hop_dong
join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) <= 3;
