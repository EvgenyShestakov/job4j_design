create table category(
    id serial primary key,
    name varchar(200)
);
create table state(
    id serial primary key,
    name varchar(200)
);
create table role(
    id serial primary key,
    name varchar(200)
);
create table users(
    id serial primary key,
    name varchar(200),
    role_id int references role(id)
);
create table rules(
    id serial primary key,
    name varchar(200),
    role_id int references role(id)
);
create table item(
    id serial primary key,
    name varchar(200),
    users_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);
create table comments(
    id serial primary key,
    name varchar(200),
    item_id int references  item(id)
);
create table attachs(
    id serial primary key,
    name varchar(200),
    item_id int references  item(id)
);
ALTER TABLE role
add rules_id int references rules(id);