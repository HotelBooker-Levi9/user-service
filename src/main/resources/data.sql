INSERT INTO ROLE(id, name) values (1, "ROLE_CLIENT");
INSERT INTO ROLE(id, name) values (2, "ROLE_ADMIN");


INSERT INTO CLIENT(id, email, name, password, surname, username, role_id, is_deleted, cart_id, is_blocked, salt) values 
(1, "user1@gmail.com", "Cvetko", "123", "Cvetkovic", "svetko1", 1, false, 1, false, null);