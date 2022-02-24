create database ss2;

use ss2;

-- Tạo bảng học sinh
create table hoc_sinh(
ma_hs varchar(20),
ten_hs varchar(50),
ngay_sinh datetime,
lop varchar(20),
gioi_tinh varchar(10),
primary key(ma_hs)
);

-- Tạo bảng môn học
create table mon_hoc(
ma_mh varchar(20) primary key,
ten_mh varchar(50)
);

-- Tạo bảng bảng điểm
create table bangdiem(
ma_hs varchar(20),
ma_mh varchar(20),
diem_thi int,
ngay_kt date,
primary key(ma_hs, ma_mh),
foreign key(ma_hs) references hoc_sinh(ma_hs),
foreign key(ma_mh) references mon_hoc(ma_mh)
);

-- Tạo bảng giáo viên
create table giao_vien(
ma_gv varchar(20) primary key,
ten_gv varchar(20),
sdt varchar(10)
);

-- Chỉnh sửa thông tin bảng
alter table mon_hoc add ma_gv varchar(20);
alter table mon_hoc add constraint fk_ma_gv foreign key(ma_gv) references giao_vien(ma_gv);