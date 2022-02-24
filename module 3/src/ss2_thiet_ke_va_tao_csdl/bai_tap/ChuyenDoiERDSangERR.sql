create database ss2_quan_li_don_hang;

use ss2_quan_li_don_hang;

-- Tạo bảng nhà cung cấp
create table nha_cung_cap(
ma_nha_cung_cap int not null auto_increment,
ten_nha_cung_cap varchar(50) not null,
dia_chi varchar(50) not null,
primary key(ma_nha_cung_cap)
);

-- Tạo bảng số điện thoại
create table so_dien_thoai(
ma_so_dien_thoai int not null auto_increment,
so_dien_thoai varchar(20) not null,
ma_nha_cung_cap int,
primary key(ma_so_dien_thoai),
foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

-- Tạo bảng đơn đặt hàng
create table don_dat_hang(
so_dat_hang int not null auto_increment,
ngay_dat_hang datetime not null,
ma_nha_cung_cap int,
primary key(so_dat_hang),
foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

-- Tạo bảng vật tư
create table vat_tu(
ma_vat_tu int not null auto_increment,
ten_vat_tu varchar(50) not null,
primary key(ma_vat_tu)
);

-- Tạo bảng chi tiết đơn đặt hàng
create table chi_tiet_don_dat_hang(
so_dat_hang int,
ma_vat_tu int,
primary key(so_dat_hang, ma_vat_tu),
foreign key(so_dat_hang) references don_dat_hang(so_dat_hang),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

-- Tạo bảng phiếu nhập
create table phieu_nhap(
so_phieu_nhap int not null auto_increment,
ngay_nhap datetime not null,
primary key(so_phieu_nhap)
);

-- Tạo bảng chi tiết phiếu nhập
create table chi_tiet_phieu_nhap(
don_gia_nhap double not null,
so_luong_nhap int not null,
ma_vat_tu int,
so_phieu_nhap int,
primary key(ma_vat_tu, so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
);

-- Tạo bảng phiếu xuất
create table phieu_xuat(
so_phieu_xuat int not null auto_increment,
ngay_xuat datetime,
primary key(so_phieu_xuat)
);

-- Tạo bảng chi tiết phiếu xuất
create table chi_tiet_phieu_xuat(
don_gia_xuat double not null,
so_luong_xuat int not null,
so_phieu_xuat int,
ma_vat_tu int,
primary key(so_phieu_xuat, ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);
