use ss2_quan_li_sinh_vien;

-- Thêm dữ liệu vào bảng class
insert into class
values(1, "A1", "2008-12-20", 1);
insert into class
values(2, "A2", "2008-12-22", 1);
insert into class
values(3, "A3", current_date, 0);

-- Thêm dữ liệu vào bảng student
insert into student(student_name, address, phone, `status`, class_id)
values('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student(student_name, address, `status`, class_id)
values('Hoa', 'Hai Phong', 1, 1);
insert into student(student_name, address, phone, `status`, class_id)
values('Manh', 'HCM', '0123123123', 0, 2);


-- Thêm dữ liệu nhanh vào bảng subject
insert into `subject`
values (1, 'CF', 5, 1),
		(2, 'C', 6, 1),
        (3, 'HDJ', 5, 1),
        (4, 'RDBMS', 10, 1);
        
-- Thêm dữ liệu vào trong bảng mark
insert into mark(sub_id, student_id, mark, exam_times)
values	(1, 1, 8, 1),
		(1, 2, 10, 2),
        (2, 1, 12, 1);