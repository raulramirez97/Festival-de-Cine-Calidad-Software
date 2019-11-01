/* DELETE 'festivalcineDB' database*/
DROP SCHEMA IF EXISTS festivalcineDB;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'%';

/* CREATE 'festivalcineDB' DATABASE */
CREATE SCHEMA festivalcineDB;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'%' IDENTIFIED BY 'spq';

GRANT ALL ON festivalcineDB.* TO 'spq'@'%';