DROP TABLE IF EXISTS attempt_option;
DROP TABLE IF EXISTS attempt_question;
DROP TABLE IF EXISTS attempt;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    us_id INT PRIMARY KEY AUTO_INCREMENT,
    us_name VARCHAR(100) NOT NULL
);

CREATE TABLE question (
    qn_id INT PRIMARY KEY AUTO_INCREMENT,
    qn_text VARCHAR(500) NOT NULL
);

CREATE TABLE options (
    op_id INT PRIMARY KEY AUTO_INCREMENT,
    op_text VARCHAR(500) NOT NULL,
    op_score DOUBLE NOT NULL,
    op_qn_id INT,
    FOREIGN KEY (op_qn_id) REFERENCES question(qn_id)
);

CREATE TABLE attempt (
    at_id INT PRIMARY KEY AUTO_INCREMENT,
    at_date DATETIME NOT NULL,
    at_us_id INT,
    FOREIGN KEY (at_us_id) REFERENCES user(us_id)
);

CREATE TABLE attempt_question (
    aq_id INT PRIMARY KEY AUTO_INCREMENT,
    aq_at_id INT,
    aq_qn_id INT,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qn_id) REFERENCES question(qn_id)
);

CREATE TABLE attempt_option (
    ao_id INT PRIMARY KEY AUTO_INCREMENT,
    ao_aq_id INT,
    ao_op_id INT,
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);

INSERT INTO user (us_name) VALUES ('Alice Smith');

INSERT INTO question (qn_text) VALUES ('What is the default port for MySQL?');
INSERT INTO options (op_text, op_score, op_qn_id) VALUES ('3306', 1.0, 1);
INSERT INTO options (op_text, op_score, op_qn_id) VALUES ('8080', 0.0, 1);

INSERT INTO attempt (at_date, at_us_id) VALUES (NOW(), 1);
INSERT INTO attempt_question (aq_at_id, aq_qn_id) VALUES (1, 1);
INSERT INTO attempt_option (ao_aq_id, ao_op_id) VALUES (1, 1);
