use ss2_quan_li_sinh_vien;

-- Hiển thị số lượng sinh viên ở từng nơi
select student.address, count(student.student_id)
from student
group by student.address;

-- Tính điểm trung bình các môn học của mỗi học viên
select student.student_id, student.student_name, avg(mark)
from student join mark on student.student_id = mark.student_id
group by student.student_id, student.student_name;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select student.student_id, student.student_name, avg(mark.mark)
from student join mark on student.student_id = mark.student_id
group by student.student_id, student.student_name
having avg(mark.mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất
select student.student_id, student.student_name, avg(mark.mark)
from student join mark on student.student_id = mark.student_id
group by student.student_id, student.student_name
having avg(mark.mark) > 15;