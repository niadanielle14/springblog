DROP DATABASE IF EXISTS spring_db;

CREATE DATABASE IF NOT EXISTS spring_db;

CREATE USER spring_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON spring_db.* TO spring_user@localhost;