INSERT INTO "persons" ("person_id", "firstname", "surname", "lastname", "has_fop", "email", "phone", "birthday")
VALUES (1, 'Rocky', 'Balboa', NULL, 'true', 'rocky.balboa@gmail.com', '+38000000000', NULL),
       (2, 'Apollo', 'Creed', NULL, 'true', 'apollo.creed@gmail.com', '+38000000000', NULL),
       (3, 'Ivan', 'Drago', 'Ivanovich', 'false', 'apollo.creed@gmail.com', '+38000000000', NULL);

INSERT INTO "user" (firstname, lastname, email, personal_code, role, password, require_password_change, phone)
VALUES ('Apollo', 'Creed', 'superadmin@g.com', '1234567890', 'SUPERADMIN',
        '$2a$12$jyip/stoOLMPIpBathddIeG080xFx2SaAKcZKN2CBHTpIbaTgB0S6', FALSE, '+380632123456'),
       ('Rocky', 'Balboa', 'operator.superuser@g.com', '1234567891', 'OPERATOR_SUPERUSER',
        '$2a$12$jyip/stoOLMPIpBathddIeG080xFx2SaAKcZKN2CBHTpIbaTgB0S6', TRUE, '+380632123456'),
       ('Ivan', 'Drago', 'operator.user@g.com', null, 'OPERATOR_USER',
        '$2a$12$jyip/stoOLMPIpBathddIeG080xFx2SaAKcZKN2CBHTpIbaTgB0S6', TRUE, '+380632123456'),
       ('Tommy', 'Gunn', 'hansab.admin@g.com', '1234567887', 'OPERATOR_USER',
        '$2a$12$jyip/stoOLMPIpBathddIeG080xFx2SaAKcZKN2CBHTpIbaTgB0S6', TRUE, '+380632123456');

