create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    people_id int references people(id),
    device_id int references devices(id)
);

insert into devices(name, price) values ('Xiaomi Redmi Note 9 Pro 6/128GB', 8000.0);
insert into devices(name, price) values ('Nokia 3310', 1000.0);
insert into devices(name, price) values ('OnePlus 8 Pro 12/256GB', 4000.0);

insert into people(name) values ('Ваня');
insert into people(name) values ('Света');
insert into people(name) values ('Толя');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 2);
insert into devices_people(device_id, people_id) values (3, 3);

select avg(price) from devices

select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id = p.id join devices as d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id = p.id join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000.0;


