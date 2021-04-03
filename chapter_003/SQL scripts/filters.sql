create table type(
id serial primary key,
name varchar(255)
);

create table product(
id serial primary key,
name varchar(255),
type_id int references type(id),
ecpired_date date,
price float
);

insert into type(name) values ('Сыр');
insert into type(name) values ('Молоко');
insert into type(name) values ('Масло');
insert into type(name) values ('Мороженное');
insert into type(name) values ('Мясо');
insert into type(name) values ('Рыба');
insert into type(name) values ('Хлеб');
insert into type(name) values ('Крупа');
insert into type(name) values ('Колбаса');
insert into type(name) values ('Пельмени');
insert into type(name) values ('Конфеты');
insert into type(name) values ('Печенье');
insert into type(name) values ('Сок');
insert into type(name) values ('Чай');

insert into product(name, type_id, ecpired_date, price) values ('Пармезан', 1, '2021.06.25', 200.0);
insert into product(name, type_id, ecpired_date, price) values ('Рокфор', 1, '2021.09.01', 250.0);
insert into product(name, type_id, ecpired_date, price) values ('Гауда', 1, '2021.10.09', 100.0);
insert into product(name, type_id, ecpired_date, price) values ('Домик в деревне', 2, '2021.04.15', 50.0);
insert into product(name, type_id, ecpired_date, price) values ('Простоквашено', 2, '2021.04.11', 60.0);
insert into product(name, type_id, ecpired_date, price) values ('Веселый молочник', 2, '2021.04.20', 70.0);
insert into product(name, type_id, ecpired_date, price) values ('Крестьянское', 3, '2021.09.17', 100.0);
insert into product(name, type_id, ecpired_date, price) values ('Мороженное пломбир', 4, '2022.09.17', 70.0);
insert into product(name, type_id, ecpired_date, price) values ('Мороженное эскими в шоколаде', 4, '2022.08.17', 100.0);
insert into product(name, type_id, ecpired_date, price) values ('Мороженное мясо', 5, '2021.07.01', 200.0);
insert into product(name, type_id, ecpired_date, price) values ('Мясо ящерицы', 5, '2021.04.02', 250.0);
insert into product(name, type_id, ecpired_date, price) values ('Мясо слона', 5, '2021.05.03', 230.0);
insert into product(name, type_id, ecpired_date, price) values ('Мясо кита', 5, '2021.06.04', 300.0);
insert into product(name, type_id, ecpired_date, price) values ('Курятина', 5, '2021.07.05', 400.0);
insert into product(name, type_id, ecpired_date, price) values ('Говядина', 5, '2021.08.06', 500.0);
insert into product(name, type_id, ecpired_date, price) values ('Свинина', 5, '2021.09.07', 340.0);
insert into product(name, type_id, ecpired_date, price) values ('Баранина', 5, '2021.10.08', 210.0);
insert into product(name, type_id, ecpired_date, price) values ('Крольчатина', 5, '2021.11.09', 180.0);
insert into product(name, type_id, ecpired_date, price) values ('Пингвинятина', 5, '2021.12.10', 350.0);
insert into product(name, type_id, ecpired_date, price) values ('Моржатина', 5, '2021.05.11', 370.0);
insert into product(name, type_id, ecpired_date, price) values ('Треска', 6, '2021.05.13', 420.0);
insert into product(name, type_id, ecpired_date, price) values ('Окунь', 6, '2021.10.13', 320.0);
insert into product(name, type_id, ecpired_date, price) values ('Плотва', 6, '2021.04.13', 550.0);
insert into product(name, type_id, ecpired_date, price) values ('Щука', 6, '2021.07.13', 300.0);
insert into product(name, type_id, ecpired_date, price) values ('Карась', 6, '2021.11.13', 260.0);
insert into product(name, type_id, ecpired_date, price) values ('Черный', 7, '2021.04.10', 30.0);
insert into product(name, type_id, ecpired_date, price) values ('Белый', 7, '2021.04.09', 40.0);
insert into product(name, type_id, ecpired_date, price) values ('Батон', 7, '2021.04.08', 50.0);
insert into product(name, type_id, ecpired_date, price) values ('Греча', 8, '2023.07.25', 80.0);
insert into product(name, type_id, ecpired_date, price) values ('Рис', 8, '2022.07.25', 50.0);
insert into product(name, type_id, ecpired_date, price) values ('Пшено', 8, '2024.01.25', 100.0);
insert into product(name, type_id, ecpired_date, price) values ('Монка', 8, '2025.06.25', 40.0);
insert into product(name, type_id, ecpired_date, price) values ('Просо', 8, '2021.02.25', 90.0);
insert into product(name, type_id, ecpired_date, price) values ('Ячмень', 8, '2022.10.25', 120.0);
insert into product(name, type_id, ecpired_date, price) values ('Греча', 8, '2023.11.25', 70.0);
insert into product(name, type_id, ecpired_date, price) values ('Докторская', 9, '2021.11.13', 350.0);
insert into product(name, type_id, ecpired_date, price) values ('Любительская', 9, '2021.10.24', 400.0);
insert into product(name, type_id, ecpired_date, price) values ('Малышок', 10, '2021.11.01', 400.0);
insert into product(name, type_id, ecpired_date, price) values ('Равиолли', 10, '2021.08.12', 450.0);
insert into product(name, type_id, ecpired_date, price) values ('Цезарь', 10, '2021.06.18', 380.0);
insert into product(name, type_id, ecpired_date, price) values ('Мишка на севере', 11, '2022.03.11', 210.0);
insert into product(name, type_id, ecpired_date, price) values ('Аленка', 11, '2021.04.20', 300.0);
insert into product(name, type_id, ecpired_date, price) values ('Овсяное', 12, '2021.05.05', 100.0);
insert into product(name, type_id, ecpired_date, price) values ('Мария', 12, '2021.08.21', 70.0);
insert into product(name, type_id, ecpired_date, price) values ('Крекер', 12, '2021.09.14', 60.0);
insert into product(name, type_id, ecpired_date, price) values ('Апельсиновый', 13, '2021.09.10', 150.0);
insert into product(name, type_id, ecpired_date, price) values ('Яблочный', 13, '2021.09.09', 120.0);
insert into product(name, type_id, ecpired_date, price) values ('Черный', 14, '2022.07.10', 90.0);
insert into product(name, type_id, ecpired_date, price) values ('Зеленый', 14, '2021.10.11', 70.0);

select p.name as Название, t.name as Тип_продукта , p.ecpired_date as Годен_до, p.price as Цена from product as p join type as t on p.type_id = t.id and t.name = 'Сыр'
select * from product where name like '%Мороженное%'
select * from product where current_date + interval '1 month' > ecpired_date
select * from product where price = (select max(price) from product)
select  type.name as Тип, count(*) as Количество from product join type on product.type_id = type.id group by type.name
select p.name as Название, t.name as Тип_продукта , p.ecpired_date as Годен_до, p.price as Цена from product as p join type as t on p.type_id = t.id where t.name in('Сыр','Молоко')
select  type.name as тип, count(*) as количество from product join type on product.type_id = type.id group by type.name having count(*)<10;
select p.name as имя, t.name as тип, p.ecpired_date годен_до, p.price as цена from product as p join type as t on p.type_id = t.id 



