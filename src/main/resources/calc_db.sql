CREATE DATABASE calc_db;

USE calc_db;

CREATE TABLE formula (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO formula VALUES (0, '5+7-(4+2)/(20-19)+1');
INSERT INTO formula VALUES (1, '3+4*2/(1-5)+2');
INSERT INTO formula VALUES (2, '2-6+(4*5)');
INSERT INTO formula VALUES (3, '(20+4)/2');
INSERT INTO formula VALUES (4, '(65-25+11)/4');
INSERT INTO formula VALUES (5, 'ce-a*2');
INSERT INTO formula VALUES (6, 'a+2-4');
INSERT INTO formula VALUES (7, '1010*10');
INSERT INTO formula VALUES (8, '1001110-1001');
INSERT INTO formula VALUES (9, '(100001-11)*10');

CREATE TABLE result (
  id int(11) NOT NULL AUTO_INCREMENT,
  result varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;