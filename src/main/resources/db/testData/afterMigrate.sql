INSERT INTO holder (id, cpf, name, email, creation_date) VALUES (1, '692.431.860-60', 'Renato', 'renato@gmail.com', CURRENT_TIMESTAMP);
INSERT INTO holder (id, cpf, name, email, creation_date) VALUES (2, '109.620.160-71', 'Mateus', 'mateus@gmail.com', CURRENT_TIMESTAMP);
INSERT INTO holder (id, cpf, name, email, creation_date) VALUES (3, '353.950.840-61', 'Ivan', 'ivan@gmail.com', CURRENT_TIMESTAMP);

INSERT INTO account (id, number, agency, balance, holder_id) VALUES (1, '42565-8', '5252', '3000', 1);
INSERT INTO account (id, number, agency, balance, holder_id) VALUES (2, '58566-3', '8686', '3000', 2);
INSERT INTO account (id, number, agency, balance, holder_id) VALUES (3, '86867-4', '2222', '3000', 3);