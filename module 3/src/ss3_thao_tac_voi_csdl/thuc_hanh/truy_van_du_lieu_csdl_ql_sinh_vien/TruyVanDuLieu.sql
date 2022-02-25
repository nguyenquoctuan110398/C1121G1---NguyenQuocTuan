use ss2_quan_li_sinh_vien;

-- Hiển thị tất cả dữ liệu từ bảng student
select * from student;

-- Hiển thị tất cả dữ liệu của bảng student kèm điều kiện status = true
select * from student where(`status` = true);

-- Hiển thị tất cả dữ liệu của bảng subject kèm điều kiện credit < 10
select * from subject where(credit<10);

-- Sử dụng câu lệnh join và where để hiện thị danh sách học viên lớp A1
select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id = c.class_id
where c.class_name = 'A1';

-- Hiển thị điểm môn cf của các học viên
select s.student_id, s.student_name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id join `subject` sub on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';