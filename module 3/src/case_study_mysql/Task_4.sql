-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select k_h.ma_khach_hang, k_h.ho_ten, l_k.ten_loai_khach, count(h_d.ma_hop_dong) as so_lan_dat_phong 
from loai_khach l_k
join khach_hang k_h on l_k.ma_loai_khach = k_h.ma_loai_khach
join hop_dong h_d on h_d.ma_khach_hang = k_h.ma_khach_hang
group by h_d.ma_khach_hang
having l_k.ten_loai_khach like '%Diamond'
order by so_lan_dat_phong;