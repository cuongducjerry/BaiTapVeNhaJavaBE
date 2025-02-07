use quanlynhansu;

-- 1. Tính tổng lương của mỗi phòng ban
select SUM(emp.salary), dept.department_name from departments dept
inner join quanlynhansu.employees emp on dept.department_id = emp.department_id
group by dept.department_name;

-- 2. Lọc các phòng ban có tổng lương lớn hơn 3000
select SUM(emp.salary), dept.department_name from departments dept
inner join quanlynhansu.employees emp on dept.department_id = emp.department_id
group by dept.department_name
having SUM(emp.salary) > 3000;

-- 3. Lấy danh sách vị trí công việc duy nhất:
select distinct emp.position from employees emp;

-- 4. Lấy 3 nhân viên đầu tiên, bỏ qua 2 nhân viên đầu tiên:
SELECT * FROM employees
ORDER BY employee_id
LIMIT 3 OFFSET 2;

-- 5. Tìm nhân viên có tên chứa “Nguyễn”
select * from employees emp where emp.name LIKE 'Nguyễn%';

-- 6. Tính tổng và trung bình lương của toàn bộ nhân viên
select
    SUM(salary) AS total_salary,
    AVG(salary) AS average_salary
from employees;

-- 7. Lấy danh sách nhân viên và tên phòng ban của họ
select
    e.employee_id,
    e.name AS employee_name,
    e.position,
    e.salary,
    d.department_name
from employees e
inner join departments d ON e.department_id = d.department_id;

-- 8. Lấy danh sách tất cả phòng ban và nhân viên của phòng ban đó (nếu có)
select d.department_id, d.department_name, d.location, e.employee_id, e.name, e.position, e.salary, e.hire_date
from departments d left join employees e ON d.department_id = e.department_id;

-- 9. Lấy danh sách tất cả nhân viên và thông tin phòng ban của họ (nếu có)
select e.employee_id, e.name, e.position, e.salary, e.hire_date, d.department_id, d.department_name, d.location
from employees e right join departments d ON e.department_id = d.department_id;

-- 10. Tìm các nhân viên có cùng mức lương
select e1.employee_id AS employee1_id,
       e1.name AS employee1_name,
       e1.salary AS salary,
       e2.employee_id AS employee2_id,
       e2.name AS employee2_name
from employees e1 join employees e2 on e1.salary = e2.salary and e1.employee_id != e2.employee_id;

-- 11. Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
select d.department_name,
       COUNT(e.employee_id) as num_employees,
       SUM(e.salary) as total_salary
from departments d join employees e on d.department_id = e.department_id
group by d.department_name
order by num_employees DESC
limit 1;

-- 12. Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
SELECT e.employee_id, e.name, e.position, e.salary, e.department_id, d.department_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM employees
    WHERE department_id = e.department_id
);

-- 13. Tính mức lương trung bình của từng vị trí công việc, chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
SELECT position, AVG(salary) AS avg_salary
FROM employees
GROUP BY position
HAVING AVG(salary) > 1500;

-- 14. Lấy danh sách nhân viên và đồng nghiệp cùng phòng ban (không bao gồm chính họ)
SELECT e1.employee_id, e1.name AS employee_name, e2.name AS colleague_name, e1.department_id
FROM employees e1 JOIN employees e2 ON e1.department_id = e2.department_id
WHERE e1.employee_id != e2.employee_id;

-- 15. Tính tổng số năm kinh nghiệm của mỗi phòng ban
SELECT e.department_id, d.department_name, SUM(DATEDIFF(CURDATE(), e.hire_date) / 365) AS total_experience_years
FROM employees e JOIN departments d ON e.department_id = d.department_id
GROUP BY e.department_id, d.department_name;

-- 16. Tìm nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban, bao gồm cả tên và ngày tuyển dụng
SELECT e.employee_id, e.name, e.hire_date, e.department_id, d.department_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE e.hire_date = (
    SELECT MIN(hire_date)
    FROM employees
    WHERE department_id = e.department_id
);

-- 17. Tìm phòng ban có tổng lương lớn nhất và hiển thị tên nhân viên, lương và phòng ban đó
SELECT e.name, e.salary, d.department_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE d.department_id = (
    SELECT department_id
    FROM employees
    GROUP BY department_id
    ORDER BY SUM(salary) DESC
    LIMIT 1
);

-- 18. Phân nhóm nhân viên theo bậc lương (ví dụ: < 1500, 1500-2000, > 2000) và tính tổng số nhân viên trong từng nhóm/-strong/-heart:>:o:-((:-h Sử dụng CASE và GROUP BY:
SELECT
    CASE
        WHEN salary < 1500 THEN '< 1500'
        WHEN salary BETWEEN 1500 AND 2000 THEN '1500 - 2000'
        ELSE '> 2000'
        END AS salary_group,
    COUNT(*) AS total_employees
FROM employees
GROUP BY salary_group;

-- 19. Tìm nhân viên có tổng số lương cao nhất trong tất cả các phòng ban (bao gồm cả tên phòng ban)
SELECT e.name, SUM(e.salary) AS total_salary, d.department_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
GROUP BY e.employee_id, d.department_name
ORDER BY total_salary DESC
LIMIT 1;

-- 20. Tìm tên nhân viên có lương cao hơn mức lương trung bình của phòng ban mà họ làm việc
SELECT e.name, e.salary, d.department_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE e.salary > (
    SELECT AVG(salary)
    FROM employees
    WHERE department_id = e.department_id
);