create table flora(
id serial primary key,
name varchar(100),
area text,
height integer	
);
insert into flora(name, area, height) values ('Ива', 'Россия', 10);
select * from flora;
update flora set name = 'Iva';
select * from flora;
delete from flora;
select * from flora;