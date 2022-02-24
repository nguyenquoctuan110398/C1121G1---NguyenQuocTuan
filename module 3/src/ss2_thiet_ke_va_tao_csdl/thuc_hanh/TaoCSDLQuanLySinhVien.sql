create database ss2_quan_li_sinh_vien;

use ss2_quan_li_sinh_vien;

-- Tạo bảng class
create table class(
class_id int not null primary key auto_increment,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit
);

-- Tạo bảng student
create table student(
student_id int not null auto_increment,
student_name varchar(30) not null,
address varchar(50),
phone varchar(10),
`status` bit,
class_id int not null,
primary key(student_id),
foreign key(class_id) references class(class_id)
);

-- Tạo bảng subject
create table subject(
sub_id int not null auto_increment,
sub_name varchar(30) not null,
credit tinyint not null default 1 check (credit>=1),
`status` bit default 1,
primary key(sub_id)
);

-- Tạo bảng mark
create table mark(
mark_id int not null auto_increment,
sub_id int not null unique,
student_id int not null unique,
mark float default 0 check(0<=mark<=100),
exam_times tinyint default 1,
primary key(mark_id),
foreign key(sub_id) references `subject`(sub_id),
foreign key(student_id) references student(student_id)
);

