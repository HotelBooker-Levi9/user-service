INSERT INTO role(id, name) values (1, "ROLE_CLIENT");
INSERT INTO role(id, name) values (2, "ROLE_ADMIN");

INSERT INTO client(id, email, name, password, surname, username, role_id, is_deleted, cart_id, is_blocked) values
(101, "hotelBookerL9+cvetko@gmail.com", "Cvetko", "{bcrypt}$2a$10$U6AINsvdl6KGv0xkzUcQveXg/JNBIgz0kJ7jwyy5ZjfvRNFvWDG96", "Cvetkovic", "cvetko1", 1, false, 1, false);
INSERT INTO client(id, email, name, password, surname, username, role_id, is_deleted, cart_id, is_blocked) values
    (102, "hotelBookerL9+milos@gmail.com", "Milos", "{bcrypt}$2a$10$U6AINsvdl6KGv0xkzUcQveXg/JNBIgz0kJ7jwyy5ZjfvRNFvWDG96", "Cvetkovic", "milos1", 1, false, 2, false);
INSERT INTO client(id, email, name, password, surname, username, role_id, is_deleted, cart_id, is_blocked) values
    (103, "hotelBookerL9+milan@gmail.com", "Milan", "{bcrypt}$2a$10$U6AINsvdl6KGv0xkzUcQveXg/JNBIgz0kJ7jwyy5ZjfvRNFvWDG96", "Cvetkovic", "milan1", 1, false, 3, false);
INSERT INTO client(id, email, name, password, surname, username, role_id, is_deleted, cart_id, is_blocked) values
    (104, "hotelBookerL9+jovana@gmail.com", "Jovana", "{bcrypt}$2a$10$U6AINsvdl6KGv0xkzUcQveXg/JNBIgz0kJ7jwyy5ZjfvRNFvWDG96", "Cvetkovic", "jovana1", 1, false, 4, false);
INSERT INTO client(id, email, name, password, surname, username, role_id, is_deleted, cart_id, is_blocked) values
    (105, "hotelBookerL9+jovan@gmail.com", "Jovan", "{bcrypt}$2a$10$U6AINsvdl6KGv0xkzUcQveXg/JNBIgz0kJ7jwyy5ZjfvRNFvWDG96", "Cvetkovic", "jovan1", 1, false, 5, false);

