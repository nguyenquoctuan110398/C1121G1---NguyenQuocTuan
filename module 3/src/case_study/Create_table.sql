-- drop database case_study_furama;

create database case_study_furama;

use case_study_furama;

-- Tạo và thêm dữ liệu vào bảng vi_tri
create table `position`(
position_id int not null auto_increment,
position_name varchar(45),
primary key(position_id)
);

-- Tạo và thêm dữ liệu vào bảng trinh_do
create table education_degree(
education_degree_id int not null auto_increment,
education_degree_name varchar(45),
primary key(education_degree_id)
);

-- Tạo và thêm dữ liệu vào bảng bo_phan
create table division(
division_id int not null auto_increment,
division_name varchar(45),
primary key(division_id)
);

-- Tạo và thêm dữ liệu bảng username
create table `user`(
username varchar(255),
`password` varchar(255),
primary key(username)
);

-- Tạo và thêm dữ liệu bảng role
create table `role`(
role_id int not null auto_increment,
role_name varchar(255),
primary key(role_id)
);

-- Tạo và thêm dữ liệu bảng user_role
create table user_role(
role_id int not null auto_increment,
username varchar(255),
primary key(role_id, username),
foreign key(role_id) references `role`(role_id),
foreign key(username) references `user`(username)
);

-- Tạo và thêm dữ liệu vào bảng nhan_vien
create table employee(
employee_id int auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int not null,
education_degree_id int not null,
division_id int not null,
username varchar(255),
primary key(employee_id),
foreign key(position_id) references `position`(position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key(division_id) references division(division_id),
foreign key(username) references `user`(username)
);

-- Tạo và thêm dữ liệu vào bảng loai_khach
create table customer_type(
customer_type_id int not null auto_increment,
customer_type_name varchar(45),
primary key(customer_type_id)
);

insert into customer_type(customer_type_name)
values	('Diamond'),
		('Platinium'),
        ('Gold'),
        ('Silver'),
        ('Member');


-- Tạo và thêm dữ liệu vào bảng khach_hang
create table customer(
customer_id int not null auto_increment,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int not null,
primary key(customer_id),
foreign key(customer_type_id) references customer_type(customer_type_id)
);

insert into customer(customer_name, customer_birthday, customer_gender, customer_id_card, 
customer_phone, customer_email, customer_address, customer_type_id)
values	('Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362',
		'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
        ('Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333',
        'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
        ('Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122',
        'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
        ('Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241',
        'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
        ('Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678',
        'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
        ('Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844',
        'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
        ('Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698',
        'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
        ('Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345',
        'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
        ('Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433',
        'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
        ('Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321',
        'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);


-- Tạo và thêm dữ liệu vào bảng loai_dich_vu
create table service_type(
service_type_id int not null auto_increment,
service_type_name varchar(45),
primary key(service_type_id)
);

insert into service_type(service_type_name)
values	('Villa'),
		('House'),
		('Room');

-- Tạo và thêm dữ liệu vào bảng kieu_thue
create table rent_type(
rent_type_id int not null auto_increment,
rent_type_name varchar(45),
rent_type_cost double,
primary key(rent_type_id)
);

insert into rent_type(rent_type_name)
values	('year'),
		('month'),
        ('day'),
        ('hour');

-- Tạo và thêm dữ liệu vào bảng dich_vu
create table service(
service_id int not null auto_increment,
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
rent_type_id int not null,
service_type_id int not null,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
primary key(service_id),
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id)
);


-- Tạo và thêm dữ liệu vào bảng dich_vu_di_kem
create table attach_service(
attach_service_id int not null auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit varchar(10) not null,
attach_service_status varchar(45),
primary key(attach_service_id)
);

-- Tạo và thêm dữ liệu vào bảng hop_dong
create table contract(
contract_id int not null auto_increment,
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
primary key(contract_id),
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id) references service(service_id)
);

-- Tạo và thêm dữ liệu vào bảng hop_dong_chi_tiet
create table contract_detail(
contract_detail_id int not null auto_increment,
contract_id int not null,
attach_service_id int not null,
quantity int not null,
primary key(contract_detail_id),
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id)
);


