INSERT INTO lectors (full_name, degree, salary) VALUES
                                                   ('John Smith', 'PROFESSOR', 10000),
                                                   ('Anna Lee', 'ASSOCIATE_PROFESSOR', 8000),
                                                   ('David Kim', 'ASSISTANT', 6000),
                                                   ('Jennifer Brown', 'PROFESSOR', 12000),
                                                   ('Michael Johnson', 'ASSOCIATE_PROFESSOR', 9000),
                                                   ('Sarah Wilson', 'ASSISTANT', 5000),
                                                   ('William Davis', 'PROFESSOR', 11000),
                                                   ('Emily Martin', 'ASSOCIATE_PROFESSOR', 7500),
                                                   ('Christopher Thompson', 'ASSISTANT', 5500),
                                                   ('Jessica Clark', 'PROFESSOR', 13000),
                                                   ('Brian Taylor', 'ASSOCIATE_PROFESSOR', 8500),
                                                   ('Karen Hall', 'ASSISTANT', 7000),
                                                   ('Thomas Lewis', 'PROFESSOR', 12500),
                                                   ('Catherine Adams', 'ASSOCIATE_PROFESSOR', 8200),
                                                   ('Paul Mitchell', 'ASSISTANT', 5800),
                                                   ('Nancy Wright', 'PROFESSOR', 10500),
                                                   ('Robert Turner', 'ASSOCIATE_PROFESSOR', 9200),
                                                   ('Maria Hernandez', 'ASSISTANT', 5400),
                                                   ('Daniel Brown', 'PROFESSOR', 11500),
                                                   ('Megan White', 'ASSOCIATE_PROFESSOR', 7800);

INSERT INTO departments (name, head_id) VALUES
                                  ('Mathematics', 1),
                                  ('Physics', 7),
                                  ('Chemistry', 10),
                                  ('Computer Science', 13),
                                  ('Biology', 19);

INSERT INTO lectors_departments (departments_id, lectors_id) VALUES
                                                             (1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
                                                             (2, 6), (2, 7), (2, 8), (2, 9), (2, 10),
                                                             (3, 11), (3, 12), (3, 13), (3, 14), (3, 15),
                                                             (4, 16), (4, 17), (4, 18), (4, 19), (4, 20),
                                                             (5, 1), (5, 6), (5, 11), (5, 16), (5, 20);
