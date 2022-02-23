use student_management;

create table student(
id int not null,
`name` varchar(45) null,
age int null,
country varchar(45) null,
primary key(id)
);

create table class(
id int not null auto_increment,
`name` varchar(50) not null,
primary key(id)
);

CREATE TABLE teacher (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    CHECK (age >= 20),
    country VARCHAR(50) NOT NULL
);
