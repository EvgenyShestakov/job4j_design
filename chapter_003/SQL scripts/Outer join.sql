create table departaments(
id serial primary key,
name varchar(255)
);

create table emploees(
id serial primary key,
name varchar(255),
departments_id int references departments(id)
);

insert into departments(name) values ('Department 1');
insert into departments(name) values ('Department 2');
insert into departments(name) values ('Department 3');
insert into departments(name) values ('Department 4');

insert into emploees(name, departments_id) values ('Employee 1', 1);
insert into emploees(name, departments_id) values ('Employee 2', 2);
insert into emploees(name, departments_id) values ('Employee 3', 3);
insert into emploees(name, departments_id) values ('Employee 4', null);
insert into emploees(name, departments_id) values ('Employee 5', null);
insert into emploees(name, departments_id) values ('Employee 6', 1);

select * from departments d left join emploees e on d.id = e.departments_id;
select * from emploees e right join departments d on d.id = e.departments_id;

select * from emploees e full join departments d on e.departments_id = d.id;

select * from emploees e cross join departments d;
select * from departments d cross join emploees e;

select d.name from departments d left join emploees e on e.departments_id = d.id where e.id is null

select * from emploees e left join departments d on e.departments_id = d.id;
select * from departments d right join emploees e on e.departments_id = d.id;

create table teens(
id serial primary key,
name varchar(255),
gender varchar(255)
);

insert into teens(name, gender) values ('Марина', 'Ж');
insert into teens(name, gender) values ('Наташа', 'Ж');
insert into teens(name, gender) values ('Светлана', 'Ж');
insert into teens(name, gender) values ('Ольга', 'Ж');
insert into teens(name, gender) values ('Рената', 'Ж');
insert into teens(name, gender) values ('Евгений', 'М');
insert into teens(name, gender) values ('Николай', 'М');
insert into teens(name, gender) values ('Михаил', 'М');
insert into teens(name, gender) values ('Андрей', 'М');
insert into teens(name, gender) values ('Антон', 'М');

select t1.name, t2.name from teens t1 cross join teens t2 where t1.gender != t2.gender;