DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS skill;

CREATE TABLE department(
    dp_id INT PRIMARY KEY AUTO_INCREMENT,
    dp_name VARCHAR(50)
);

CREATE TABLE employee(
    em_id INT PRIMARY KEY AUTO_INCREMENT,
    em_name VARCHAR(50),
    em_salary DOUBLE,
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE skill(
    sk_id INT PRIMARY KEY AUTO_INCREMENT,
    sk_name VARCHAR(50)
);

CREATE TABLE employee_skill(
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

INSERT INTO department (dp_name) VALUES ('IT');
INSERT INTO department (dp_name) VALUES ('HR');
INSERT INTO department (dp_name) VALUES ('Finance');

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Alice', 95000.0, true, '1990-01-15', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Bob', 80000.0, true, '1992-03-22', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Charlie', 70000.0, false, '1994-08-10', 2);

INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');
INSERT INTO skill (sk_name) VALUES ('Hibernate');
INSERT INTO skill (sk_name) VALUES ('SQL');

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
