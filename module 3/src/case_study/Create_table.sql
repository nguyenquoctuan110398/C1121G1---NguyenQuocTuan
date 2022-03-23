-- drop database case_study_furama;

create database case_study_furama;

use case_study_furama;

-- Tạo và thêm dữ liệu vào bảng vi_tri
create table `position`(
position_id int not null auto_increment,
position_name varchar(45),
primary key(position_id)
);

insert into `position`(position_name)
values	('Quản Lý'),
		('Nhân Viên');

-- Tạo và thêm dữ liệu vào bảng trinh_do
create table education_degree(
education_degree_id int not null auto_increment,
education_degree_name varchar(45),
primary key(education_degree_id)
);

insert into education_degree(education_degree_name)
values	('Trung Cấp'),
		('Cao Đẳng'),
        ('Đại Học'),
        ('Sau Đại Học');


-- Tạo và thêm dữ liệu vào bảng bo_phan
create table division(
division_id int not null auto_increment,
division_name varchar(45),
primary key(division_id)
);

insert into division(division_name)
values	('Sale-Marketing'),
		('Hành chính'),
        ('Phục vụ'),
        ('Quản lý');


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

insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, 
					employee_address, position_id, education_degree_id, division_id)
values	('Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121',
		'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
        ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314',
        'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
        ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315',
        'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
        ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232',
        'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
        ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231',
        'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
        ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213',
        'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
        ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553',
        'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
        ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111',
        'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
        ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444',
        'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
        ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111',
        'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);

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
customer_code varchar(45) not null,
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


insert into customer(customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, 
customer_phone, customer_email, customer_address, customer_type_id)
values	('KH-0001', 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362',
		'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
        ('KH-0002', 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333',
        'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
        ('KH-0003', 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122',
        'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
        ('KH-0004', 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241',
        'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
        ('KH-0005', 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678',
        'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
        ('KH-0006', 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844',
        'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
        ('KH-0007', 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698',
        'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
        ('KH-0008', 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345',
        'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
        ('KH-0009', 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433',
        'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
        ('KH-0010', 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321',
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


