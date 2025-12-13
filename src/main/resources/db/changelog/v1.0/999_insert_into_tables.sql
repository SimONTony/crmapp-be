--TEST DATA!

-- Insert values into the employees table
INSERT INTO "employees"
("id", "firstname", "lastname", "patronymic", "email", "has_fop", "phone", "birthday", "job_title", "hire_date")
VALUES (101, 'John', 'Smith', NULL, 'john.smith@company.com', FALSE, '555-123-4567', '1985-05-15 00:00:00',
        'Software Engineer', '2019-01-10 00:00:00'),
       (102, 'Sarah', 'Johnson', 'Elizabeth', 'sarah.johnson@company.com', TRUE, '555-234-5678', '1990-10-20 00:00:00',
        'Marketing Director', '2020-03-01 00:00:00'),
       (103, 'Robert', 'Williams', NULL, 'robert.williams@company.com', FALSE, '555-345-6789', '1993-02-28 00:00:00',
        'Financial Analyst', '2021-07-15 00:00:00'),
       (104, 'Emily', 'Brown', 'Marie', 'emily.brown@company.com', FALSE, '555-456-7890', '1988-11-05 00:00:00',
        'UX Designer', '2018-05-20 00:00:00'),
       (105, 'Michael', 'Davis', 'James', 'michael.davis@company.com', TRUE, NULL, '1995-07-12 00:00:00',
        'HR Coordinator', '2022-11-01 00:00:00'),
       (106, 'Иван', 'Иванов', 'Иванович', 'ivanov.ii@company.com', FALSE, '+79001234567', '1985-05-15 00:00:00',
        'Старший разработчик', '2019-01-10 00:00:00'),
       (107, 'Мария', 'Петрова', 'Александровна', 'petrova.ma@company.com', TRUE, '+79002345678', '1990-10-20 00:00:00',
        'Менеджер по продажам', '2020-03-01 00:00:00'),
       (108, 'Алексей', 'Сидоров', NULL, 'sidorov.a@company.com', FALSE, '+79003456789', '1993-02-28 00:00:00',
        'Аналитик данных', '2021-07-15 00:00:00'),
       (109, 'Елена', 'Козлова', 'Сергеевна', 'kozlova.e@company.com', FALSE, '+79004567890', '1988-11-05 00:00:00',
        'Дизайнер', '2018-05-20 00:00:00'),
       (110, 'Дмитрий', 'Морозов', 'Павлович', 'morozov.d@company.com', TRUE, NULL, '1995-07-12 00:00:00',
        'Младший специалист', '2022-11-01 00:00:00');

-- Insert values into the users table
INSERT INTO "users"
("id", "username", "password", "employee_id", "enabled", "locked", "last_login_at")
VALUES (1, 'john.smith@company.com', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 101, TRUE, FALSE,
        '2025-12-10 18:00:00-05'),
       (2, 'sjohnson', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 102, TRUE, FALSE,
        '2025-12-09 10:30:00-05'),
       (3, 'rwilliams', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 103, TRUE, FALSE, NULL),
       (4, 'e_brown', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 104, TRUE, FALSE,
        '2025-12-10 09:15:00-05'),
       (5, 'mdavis', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 105, FALSE, FALSE, NULL),
       (6, 'ivanov_i', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 106, TRUE, FALSE,
        '2025-12-10 18:00:00+03'),
       (7, 'petrova_m', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 107, TRUE, FALSE,
        '2025-12-09 10:30:00+03'),
       (8, 'sidorov_a', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 108, TRUE, FALSE, NULL),
       (9, 'kozlova_e', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 109, TRUE, FALSE,
        '2025-12-10 09:15:00+03'),
       (10, 'morozov_d', '$2a$04$Jtz5wZzppdv3xkDj5WPPXe4pv8/E74/8eentKCkoAayP6R6R9N8mO', 110, FALSE, FALSE, NULL);
