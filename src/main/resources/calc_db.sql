CREATE DATABASE calc_db;
USE calc_db;
CREATE TABLE formula (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE result (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;