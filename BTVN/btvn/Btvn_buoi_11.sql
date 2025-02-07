create database btvn_mysql;

use btvn_mysql;
-- Tạo bảng Students
CREATE TABLE Students (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(50),
                          last_name VARCHAR(50),
                          birth_date DATE,
                          email VARCHAR(100)
);

-- Tạo bảng Courses
CREATE TABLE Courses (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         course_name VARCHAR(100),
                         course_description TEXT
);

-- Tạo bảng Enrollments
CREATE TABLE Enrollments (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             student_id INT,
                             course_id INT,
                             enrollment_date DATE,
                             FOREIGN KEY (student_id) REFERENCES Students(id),
                             FOREIGN KEY (course_id) REFERENCES Courses(id)
);

-- Chèn dữ liệu vào bảng Students
INSERT INTO Students (first_name, last_name, birth_date, email) VALUES
                                                                    ('Nguyen', 'Anh', '1998-05-14', 'nguyen.anh@example.com'),
                                                                    ('Tran', 'Bich', '2002-03-22', 'tran.bich@example.com'),
                                                                    ('Le', 'Minh', '2000-07-10', 'le.minh@example.com'),
                                                                    ('Pham', 'Hoa', '2001-09-30', 'pham.hoa@example.com'),
                                                                    ('Hoang', 'Lan', '1999-12-02', 'hoang.lan@example.com');

-- Chèn dữ liệu vào bảng Courses
INSERT INTO Courses (course_name, course_description) VALUES
                                                          ('Lập Trình Cơ Bản', 'Khóa học lập trình cơ bản cho sinh viên mới bắt đầu.'),
                                                          ('Toán Học', 'Khóa học Toán học cơ bản cho sinh viên đại học.'),
                                                          ('Cơ Sở Dữ Liệu', 'Khóa học về cơ sở dữ liệu, SQL và quản lý dữ liệu.');

-- Chèn dữ liệu vào bảng Enrollments
INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES
                                                                     (1, 1, '2024-01-01'),
                                                                     (2, 2, '2024-02-01'),
                                                                     (3, 1, '2024-03-01'),
                                                                     (4, 3, '2024-04-01'),
                                                                     (5, 2, '2024-05-01');

-- Truy vấn tất cả thông tin sinh viên
SELECT first_name, last_name, email FROM Students;

-- Truy vấn tất cả khóa học
SELECT course_name, course_description FROM Courses;

-- Truy vấn danh sách sinh viên cùng khóa học họ đăng ký
SELECT s.first_name, s.last_name, c.course_name
FROM Students s
JOIN Enrollments e ON s.id = e.student_id
JOIN Courses c ON e.course_id = c.id;

-- Truy vấn danh sách sinh viên đã đăng ký khóa học "Lập Trình Cơ Bản"
SELECT s.first_name, s.last_name
FROM Students s
JOIN Enrollments e ON s.id = e.student_id
JOIN Courses c ON e.course_id = c.id
WHERE c.course_name = 'Lập Trình Cơ Bản';

-- Truy vấn các sinh viên có ngày sinh sau ngày 2000-01-01 và có email chứa từ "example"
SELECT * FROM Students
WHERE birth_date > '2000-01-01' AND email LIKE '%example%';

-- Cập nhật email của sinh viên có student_id = 1
UPDATE Students
SET email = 'nguyen.anh.new@example.com'
WHERE id = 1;

-- Cập nhật mô tả của khóa học "Lập Trình Cơ Bản"
UPDATE Courses
SET course_description = 'Khóa học lập trình cơ bản dành cho tất cả sinh viên yêu thích lập trình.'
WHERE course_name = 'Lập Trình Cơ Bản';

-- Xóa một sinh viên cụ thể khỏi bảng Students (chỉ xóa nếu sinh viên không có bất kỳ khóa học nào đã đăng ký)
DELETE FROM Students
WHERE id = 5 AND NOT EXISTS (
    SELECT 1 FROM Enrollments WHERE student_id = 5
);

-- Xóa một khóa học khỏi bảng Courses (chỉ xóa nếu khóa học đó không có sinh viên nào đã đăng ký)
DELETE FROM Courses
WHERE id = 2 AND NOT EXISTS (
    SELECT 1 FROM Enrollments WHERE course_id = 2
);

-- Truy vấn các sinh viên có ngày sinh lớn hơn 2000-01-01
SELECT * FROM Students
WHERE birth_date > '2000-01-01';

-- Truy vấn tất cả các sinh viên có tên bắt đầu bằng "Nguyen"
SELECT * FROM Students
WHERE first_name LIKE 'Nguyen%';

-- Truy vấn tất cả các sinh viên có ngày sinh sau 2000-01-01 và đã đăng ký khóa học "Toán Học"
SELECT s.first_name, s.last_name
FROM Students s
         JOIN Enrollments e ON s.id = e.student_id
         JOIN Courses c ON e.course_id = c.id
WHERE s.birth_date > '2000-01-01' AND c.course_name = 'Toán Học';

-- Truy vấn các sinh viên đã đăng ký các khóa học có course_id trong danh sách 101, 102
SELECT s.first_name, s.last_name
FROM Students s
         JOIN Enrollments e ON s.id = e.student_id
WHERE e.course_id IN (101, 102);

-- Truy vấn các khóa học có course_id nằm trong khoảng từ 101 đến 103
SELECT * FROM Courses
WHERE id BETWEEN 101 AND 103;