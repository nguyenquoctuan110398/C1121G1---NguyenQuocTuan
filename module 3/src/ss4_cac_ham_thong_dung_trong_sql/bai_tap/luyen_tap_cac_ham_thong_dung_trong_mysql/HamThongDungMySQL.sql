use ss2_quan_li_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select `subject`.* from `subject`
where `subject`.credit >= all (select `subject`.credit from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select `subject`.*, mark.mark from `subject`
join mark on `subject`.sub_id = mark.sub_id
where mark.mark = all (select max(mark.mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark.mark) as diem_trung_binh from student
join mark on student.student_id = mark.student_id
group by student.student_id
order by diem_trung_binh desc, student.student_id;