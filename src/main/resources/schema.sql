Create table if not  exists students(
student_id int auto_increment primary key,
name varchar(30),
marks  int,
gender varchar(10)
);

Create table if not exists lookup(
lookup_id  int auto_increment primary key,
lookup_type varchar(20),
lookup_code varchar(20),
lookup_value varchar(20)
);

create table employee(  
employee_id int auto_increment primary key,  
employee_name varchar(30),  
salary long(10)  
);

