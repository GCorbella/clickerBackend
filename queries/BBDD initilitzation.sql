DROP DATABASE clickerdb;

CREATE SCHEMA IF NOT EXISTS clickerdb;

USE clickerdb;

CREATE TABLE users (
usr_id INTEGER NOT NULL,
usr_name VARCHAR(255) NOT NULL,
usr_mail VARCHAR(255),
usr_password VARCHAR(255) NOT NULL,
usr_svfileid INTEGER,
PRIMARY KEY (usr_id)
);

CREATE TABLE savefile (
svfile_id INTEGER NOT NULL,
svfile_usrid INTEGER NOT NULL,
svfile_currency BIGINT,
svfile_totalcps BIGINT,
svfile_producers JSON,
svfile_upgrades JSON,
PRIMARY KEY (svfile_id)
);

CREATE TABLE producers (
prod_id INTEGER NOT NULL,
prod_name VARCHAR(64) NOT NULL,
prod_cpsvalue FLOAT NOT NULL,
PRIMARY KEY (prod_id)
);

CREATE TABLE upgrades (
upgrd_id INTEGER NOT NULL,
upgrd_effect VARCHAR(255) NOT NULL,
upgrd_price BIGINT NOT NULL,
PRIMARY KEY (upgrd_id)
);