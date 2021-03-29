insert into category(name) values ('Category1');
insert into category(name) values ('Category2');
insert into category(name) values ('Category3');
insert into state(name) values ('State1');
insert into state(name) values ('State2');
insert into state(name) values ('State3');
insert into role(name) values ('Role1');
insert into role(name) values ('Role2');
insert into role(name) values ('Role3');
insert into users(name, role_id) values ('User1', 1);
insert into users(name, role_id) values ('User2', 2);
insert into users(name, role_id) values ('User3', 3);
insert into rules(name, role_id) values ('RuleOne', 1);
insert into rules(name, role_id) values ('RuleTwo', 2);
insert into rules(name, role_id) values ('RuleThree', 3);
insert into item(name, users_id, category_id, state_id) values ('Item1', 1, 2, 3);
insert into item(name, users_id, category_id, state_id) values ('Item2', 2, 1, 2);
insert into item(name, users_id, category_id, state_id) values ('Item3', 3, 3, 1);
insert into comments(name, item_id) values ('Comments1', 2);
insert into comments(name, item_id) values ('Comments2', 3);
insert into comments(name, item_id) values ('Comments3', 1);
insert into attachs(name, item_id) values ('Attachs1', 3);
insert into attachs(name, item_id) values ('Attachs2', 2);
insert into attachs(name, item_id) values ('Attachs3', 1);
update role set rules_id = 1
   where name = 'Role1';
update role set rules_id = 2
   where name = 'Role2';
update role set rules_id = 3
   where name = 'Role3';