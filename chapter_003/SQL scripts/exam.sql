CREATE TABLE meeting(
id integer NOT NULL,
name varchar(255),
CONSTRAINT meeting_key PRIMARY KEY (id)
);

CREATE TABLE users(
id integer NOT NULL,
name varchar(255),
participation_status boolean,
meeting_id int REFERENCES meeting(id),
CONSTRAINT users_key PRIMARY KEY (id)
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
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (1, 'Toni', true, 1);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (2, 'Mike', false, 1);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (3, 'Jeff', true, 1);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (4, 'John', false, 2);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (5, 'David', true, 2);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (6, 'April', true, 3);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (7, 'Julia', false, 4);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (8, 'Alan', false, 4);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (9, 'Alex', false, 6);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (10, 'Bruce', true, 6);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (11, 'Mary', true, 2);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (12, 'Betty', false, 2);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (13, 'Helen', true, 4);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (14, 'Karen', false, 1);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (15, 'Margaret', true, 2);
INSERT INTO users(id, name, participation_status, meeting_id) VALUES (16, 'Edward', true, 3);

SELECT m.name AS Мероприятие, COUNT(u.meeting_id) AS Количество_участников FROM meeting m JOIN users u ON m.id = u.meeting_id 
WHERE participation_status = true GROUP BY m.id ORDER BY m.id ASC

SELECT m.name AS Мероприятие FROM meeting m LEFT JOIN users u ON m.id = u.meeting_id WHERE u.meeting_id IS NULL;