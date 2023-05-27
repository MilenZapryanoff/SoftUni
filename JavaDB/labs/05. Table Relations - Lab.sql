#1
CREATE TABLE mountains (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL);


CREATE TABLE peaks (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mountain_id INT NOT NULL,
    CONSTRAINT fk_peaks_mountains FOREIGN KEY (mountain_id)
        REFERENCES mountains (id));

#2
SELECT 
    v.driver_id,
    v.vehicle_type,
    CONCAT(c.first_name, ' ', c.last_name) AS driver_name
FROM
    vehicles v,
    campers c
WHERE
    v.driver_id = c.id;
    
#3
SELECT 
    r.starting_point,
    r.end_point,
    r.leader_id,
    CONCAT(c.first_name, ' ', c.last_name)
FROM
    routes r,
    campers c
WHERE
    r.leader_id = c.id;

#4    
CREATE TABLE mountains (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL);
    
CREATE TABLE peaks (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mountain_id INT NOT NULL,
    CONSTRAINT fk_peaks_mountains FOREIGN KEY (mountain_id)
        REFERENCES mountains (id)
        ON DELETE CASCADE
);