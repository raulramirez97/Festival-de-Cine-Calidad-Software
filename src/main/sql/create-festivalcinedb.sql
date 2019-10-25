/* DELETE 'festivalcinedb' database*/
DROP SCHEMA IF EXISTS festivalcinedb;
/* DELETE USER 'sc' AT LOCAL SERVER*/
DROP USER IF EXISTS 'sd'@'%';

/* CREATE 'festivalcinedb' DATABASE */
CREATE SCHEMA festivalcinedb;
/* CREATE THE USER 'sd' AT LOCAL SERVER WITH PASSWORD 'sd' */
CREATE USER IF NOT EXISTS 'sd'@'%' IDENTIFIED BY 'sd';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'sd' AT LOCAL SERVER*/
GRANT ALL ON festivalcinedb.* TO 'sd'@'%';