CREATE TABLE meeting(
id integer NOT NULL,
name varchar(255),
CONSTRAINT meeting_key PRIMARY KEY (id)
);

CREATE TABLE users(
id integer NOT NULL,
name varchar(255),
CONSTRAINT users_key PRIMARY KEY (id)
);

CREATE TABLE users_meeting(
id integer NOT NULL,
participation_status boolean,
meeting_id int REFERENCES meeting(id),
users_id int REFERENCES users(id),
CONSTRAINT users_meeting_key PRIMARY KEY (id)
);

INSERT INTO meeting(id, name) VALUES (1, 'Night party');
INSERT INTO meeting(id, name) VALUES (2, 'Spectacle');
INSERT INTO meeting(id, name) VALUES (3, 'Movie');
INSERT INTO meeting(id, name) VALUES (4, 'Museum');
INSERT INTO meeting(id, name) VALUES (5, 'Сircus');
INSERT INTO meeting(id, name) VALUES (6, 'Boat trip');
INSERT INTO meeting(id, name) VALUES (7, 'Tournament');
INSERT INTO meeting(id, name) VALUES (8, 'Festival');
INSERT INTO meeting(id, name) VALUES (9, 'Fair');
INSERT INTO users(id, name) VALUES (1, 'Toni');
INSERT INTO users(id, name) VALUES (2, 'Mike');
INSERT INTO users(id, name) VALUES (3, 'Jeff');
INSERT INTO users(id, name) VALUES (4, 'John');
INSERT INTO users(id, name) VALUES (5, 'David');
INSERT INTO users(id, name) VALUES (6, 'April');
INSERT INTO users(id, name) VALUES (7, 'Julia');
INSERT INTO users(id, name) VALUES (8, 'Alan');
INSERT INTO users(id, name) VALUES (9, 'Alex');
INSERT INTO users(id, name) VALUES (10, 'Bruce');
INSERT INTO users(id, name) VALUES (11, 'Mary');
INSERT INTO users(id, name) VALUES (12, 'Betty');
INSERT INTO users(id, name) VALUES (13, 'Helen');
INSERT INTO users(id, name) VALUES (14, 'Karen');
INSERT INTO users(id, name) VALUES (15, 'Margaret');
INSERT INTO users(id, name) VALUES (16, 'Edward');
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (1, true, 1, 6);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (2, true, 1, 1);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (3, false, 8, 5);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (4, false, 8, 3);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (5, true, 8, 8);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (6, true, 4, 11);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (7, false, 4, 4);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (8, false, 4, 16);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (9, true, 4, 1);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (10, true, 4, 3);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (11, false, 5, 1);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (12, false, 5, 4);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (13, true, 5, 11);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (14, false, 6, 7);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (15, true, 6, 8);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (16, false, 6, 9);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (17, true, 6, 10);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (18, false, 6, 13);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (19, true, 7, 5);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (20, false, 7, 6);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (21, false, 7, 7);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (22, true, 7, 12);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (23, true, 7, 13);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (24, false, 7, 14);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (25, false, 7, 15);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (26, false, 7, 16);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (27, true, 7, 1);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (28, true, 8, 2);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (29, false,8, 4);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (30, false, 9, 6);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (31, true, 9, 7);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (32, true, 9, 8);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (33, false, 9, 9);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (34, true, 1, 10);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (35, false, 1, 2);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (36, true, 1, 3);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (37, true, 1, 4);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (38, false, 1, 5);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (39, false, 1, 12);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (40, false, 4, 7);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (41, false, 4, 9);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (42, true, 4, 6);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (43, false, 5, 2);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (44, true, 5, 5);
INSERT INTO users_meeting(id, participation_status, meeting_id, users_id) VALUES (45, false, 5, 8);



SELECT m.name, COUNT(um.meeting_id) FROM users_meeting um JOIN users u ON um.users_id = u.id JOIN meeting m ON um.meeting_id = m.id
WHERE participation_status = true GROUP BY m.id ORDER BY m.id ASC

SELECT m.id, m.name FROM meeting m LEFT JOIN users_meeting um ON m.id = um.meeting_id WHERE um.meeting_id IS NULL;