INSERT INTO ROLE(id, name) values (1, "ROLE_CLIENT");
INSERT INTO ROLE(id, name) values (2, "ROLE_ADMIN");

INSERT INTO CLIENT(id, email, name, password, surname, username, is_deleted, cart_id, is_blocked) values
(101, "user1@gmail.com", "Cvetko", "$2a$10$U6AINsvdl6KGv0xkzUcQveXg/JNBIgz0kJ7jwyy5ZjfvRNFvWDG96", "Cvetkovic", "cvetko1", false, null, false);

INSERT INTO USER_ROLES(user_id, role_id)
values (101, 1);
