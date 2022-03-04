create database if not exists a0921i1;
use a0921i1;
create table class_type(
id int primary key auto_increment,
class_type_name varchar(50)
);
create table class(
id int primary key auto_increment,
`name` varchar(50),
class_type_id int,
foreign key(class_type_id) references class_type(id)
);
create table jame(
`account` varchar(50) primary key,
 `password` varchar(25) 
);
create table student(
id int auto_increment primary key,
name varchar(250),
birthday date,
gender boolean,
point int,
email varchar(50),
`account` varchar(50),
class_id int
);
alter table student add constraint fk_1 foreign key(`account`) references jame(`account`);
alter table student add constraint fk_2 foreign key(class_id) references class(id);

create table instructor (
id int auto_increment primary key,
name varchar(250),
birthday date,
class_type int,
salary int
);
create table class_instructor (
class_id int,
instructor_id int,
primary key(class_id,instructor_id),
foreign key(class_id) references class(id),
foreign key(instructor_id) references instructor(id)
);

insert into class_type (class_type_name) values ('full time'), ('part time'),('orther');
select * from class_type;

insert into class (name,class_type_id) values ('c1121g1',1), ('c1221g1',1),('a0821i1',2),('a0921i1',2);
select* from class;

insert into jame(`account`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');
 select* from jame;
 
 insert into instructor(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
 select* from instructor;
 
 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');
 select * from student;
 insert into class_instructor(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);
 select * from class_instructor;
 
select * from class_type;
select* from class;
select* from jame;
select* from instructor;select * from student;
select * from class_instructor;

-- bài 3: thao tác với database

 -- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.--
 -- id, name, class_name
 select s.id,s.name, c.name from 
 student as s join class as c on s.class_id = c.id;
 -- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học—
select * from 
 student as s left join class as c on s.class_id = c.id;
-- 4. Lấy thông tin của các học viên tên 'vo minh hieu' hoặc 'le xuan ky.
select * from student where name ='le xuan ky' or name ='le hai chung';
-- 4. Lấy ra học viên có điểm lớn hơn 5
select * from student where point>5;
select * from student having point>5;
-- 4. Lấy ra học viên có điểm lớn hơn hoặc bằng  4 và nhỏ hơn hoặc bằng  7
select * from student where point>=4 and point <=7;

select * from student where point between 4 and 7;
-- 5. Lấy ra học viên có họ là nguyen
select * from student where name like 'nguyen%';
-- like tiếng việt
select * from student where name like concat('%',convert('văn',binary),'%');
-- 6. thông kế số lượng học sinh theo từng loại điểm;
select point, count(id) as so_luong from student group by point;
-- 6. thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
select point, count(id) as so_luong from student where point>=5 group by point;
-- 6. thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2 
select point, count(id) as so_luong from student where point>=5 group by point having so_luong>=2;
-- 7. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên học viên theo alphabet.
select * from 
student as s join class as c on s.class_id=c.id where c.name='c1121g1' order by s.name desc;
-- 7. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp theo point giảm dần, nếu point bằng nhau
-- thì sắp xếp tên theo alphabet.
select * from 
student as s join class as c on s.class_id=c.id 
where c.name='c1121g1' order by s.point desc, s.name asc;
 -- 7. thông kế số lượng học sinh theo điểm lớn hơn 4 và chỉ hiện thị với số lượng>2 
 select point, count(id) as so_luong from student
 where point>=5 group by point having so_luong>=2 order by so_luong desc;

 -- sắp xếp theo số lượng giảm dần;
 
 -- bài 4
 
  -- 1.1	Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp 
          select * from student;
          select * from class;
          
  select c.name, sum(point) as so_luong from 
  class as c join student as s on c.id = s.class_id
  group by c.id; 
  --  1.1	Hiện thị tất cả  danh sách các lớp và số lượng học viên của mỗi lớp
    select c.name, count(*) from 
    class as c left join student as s on c.id = s.class_id where s.name is not null
  group by c.id;

-- 1.2.	 Tình điểm lớn nhất của mỗi các lớp
 select c.name, max(point) as so_luong from 
  class as c join student as s on c.id = s.class_id
  group by c.id; 

-- tính điểm trung bình của toàn trung tâm.
select avg(point) as dt from student;
-- 1.3	 Tình điểm trung bình  của từng lớp các lớp
 select c.name, avg(point) as so_luong from 
  class as c join student as s on c.id = s.class_id
  group by c.id; 
  
 -- 2 Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym.
select s.name as ho_ten , s.birthday as ngay_sinh, s.point from student as s
union  
select i.name, i.birthday,i.salary from instructor as i;
 -- 4.Lấy ra 3 học viên có điểm lớn nhất ở CodeGym
 select s.name, s.point from student as s order by point desc limit 0,3;
 -- 5. Lấy ra các học viên có điểm số là cao nhất của trung tâm.
 -- dùng subquery
  select s.name, point, max(point) from student as s where point = (select max(point) from student);
-- 6 tìm  những gv chưa từng tham gia giảng dạy;
select i.name from instructor as i join class_instructor as ci on i.id =ci.instructor_id
group by ci.instructor_id;
select i.name from instructor as i
where i.id  not in (select ci.instructor_id from class_instructor as ci);

-- bài 5
-- 1. tạo view lấy thông tin học viên (id, name, className)
select * from student;
select * from class;
create view student_view as 
select s.id,s.name as studen_name,c.name as class_name 
from student as s join class as c on s.class_id = c.id;
 drop view student_class;
 select* from student_view;
 delete  from student_view where id =18;
 update student_view set studen_name ='Kiên2',id =19 where id =18;
 insert into student_view (id,studen_name) values(20,"long nhật");
 
 -- 2.1 tạo procedure không tham số ( lấy ra danh sách học viên)
 delimiter $$
 create procedure sp_get_all_student()
 begin
 select * from student;
 end $$
 delimiter ;
 call sp_get_all_student();
  
  drop procedure sp_get_all_student;
  drop procedure find_by_id;
 
 -- 2.2 tạo procedure có tham số in
delimiter $$
 create procedure sp_find_student_by_id(in p_id int)
 begin
 select * from student where id = p_id;
 end $$
 delimiter ;
call sp_find_student_by_id(10);

 -- 2.3 tạo procedure có tham số out -- lấy ra số lượng học viện
delimiter $$
 create procedure sp_count_student(out so_luong int)
 begin
 select count(*) into so_luong from student;
 end $$
 delimiter ;
 call sp_count_student(@sl);
 select @sl;
