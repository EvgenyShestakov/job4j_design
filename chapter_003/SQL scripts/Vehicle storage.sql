create table body(
id serial primary key,
name varchar(255)
);

create table engine(
id serial primary key,
name varchar(255)
);

create table transmission(
id serial primary key,
name varchar(255)
);

create table car(
id serial primary key,
name varchar(255),
body_id int references body(id),
engine_id int references engine(id),
transmission_id int references transmission(id)
);

insert into body(name) values ('Седан');
insert into body(name) values ('Универсал');
insert into body(name) values ('Хэтчбек');
insert into body(name) values ('Спорт');

insert into engine(name) values ('V6');
insert into engine(name) values ('V8');
insert into engine(name) values ('V10');
insert into engine(name) values ('V12');


insert into transmission(name) values ('Ручная');
insert into transmission(name) values ('Автомат');
insert into transmission(name) values ('Роботизированная КПП');
insert into transmission(name) values ('Вариатор');

insert into car(name, body_id, engine_id, transmission_id) values ('BMW', 1, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Audi', 2, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Volvo', 1, 2, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('Mercedez', 3, 3, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Volkswagen', 2, 3, 1);

select c.name as Название_машины, b.name as Тип_кузова, e.name as Тип_двигателя, t.name as Коробка_передач from car c left join body b on b.id = c.body_id left join engine e on e.id = c.engine_id left join transmission t on t.id = c.transmission_id;

select c.name as Название_машины, b.name as Тип_кузова from body b left join car c on b.id = c.body_id where c.body_id is null;
select c.name as Название_машины, e.name as Тип_двигателя from engine e left join car c on e.id = c.engine_id where c.engine_id is null;
select c.name as Название_машины, t.name as Коробка_передач from transmission  t left join car c on t.id = c.transmission_id where c.transmission_id is null;