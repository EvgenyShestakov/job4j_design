create table accessories(
id serial primary key,
CPU varchar(255),
motherboard varchar(255),
RAM varchar(255)
);

create table computers(
id serial primary key,
category varchar(255),
 accessories_id int references accessories(id) unique
);

insert into accessories(CPU, motherboard, RAM) values ('Intel i3', 'Gigabite HZ3456', 'Corsair Vengeance RGB PRO');
insert into accessories(CPU, motherboard, RAM) values ('Intel i5', 'Asus AS677', 'Kingston ValueRAM');
insert into accessories(CPU, motherboard, RAM) values ('Intel i7', 'MSI QRT54', 'HyperX Fury');
insert into computers(category, accessories_id) values ('office', 2);
insert into computers(category, accessories_id) values ('home', 3);
insert into computers(category, accessories_id) values ('game', 1);

select * from computers as pc join accessories as accry on pc.accessories_id = accry.id;
select pc.category, accry.CPU from computers as pc join accessories as accry on pc.accessories_id = accry.id;
select pc.category as категория, accry.CPU as процессор from computers as pc join accessories as accry on pc.accessories_id = accry.id;