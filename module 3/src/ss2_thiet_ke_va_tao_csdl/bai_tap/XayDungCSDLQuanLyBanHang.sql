create database ss2_quan_li_ban_hang;

use ss2_quan_li_ban_hang;

create table customer(
c_id int not null auto_increment,
c_name varchar(50) not null,
c_age int not null,
primary key(c_id)
);

create table product(
p_id int not null auto_increment,
p_name varchar(50) not null,
p_price double not null,
primary key(p_id)
);

create table `order`(
o_id int not null auto_increment,
c_id int,
o_date datetime not null,
primary key(o_id),
foreign key(c_id) references customer(c_id)
);

create table order_detail(
o_id int,
p_id int,
od_QTY int,
primary key(o_id, p_id),
foreign key(o_id) references `order`(o_id),
foreign key(p_id) references product(p_id)
);
