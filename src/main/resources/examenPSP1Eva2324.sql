

drop database if exists tallerMecanico;
create database tallerMecanico collate utf8mb4_spanish_ci;
use tallerMecanico;

DROP USER IF EXISTS "examen";
CREATE USER 'examen'@'%' IDENTIFIED BY 'examen';
GRANT SELECT, INSERT, UPDATE, DELETE ON tallerMecanico.* TO 'examen'@'%';  

create table Cars (
	id int primary key auto_increment,
    car_registration varchar(12) not null unique,
    model varchar(100),
    color varchar(100)
);

create table reparations (
	id int primary key auto_increment,
    reparation_date Date not null,
    price float not null,
    id_car int,
    constraint fk_reparations_cars foreign key (id_car) REFERENCES Cars(id)
);

insert into Cars (id, car_registration, model, color) VALUES 
	(1, "1234-ABC", "Ford Focus", "Red"),
    (2, "1235-ABC", "Renaul Megane", "Green"),
    (3, "1236-ABC", "Opel Astra", "Purple"),
    (4, "1237-ABC", "Seat Leon", "Black"),
    (5, "1238-ABC", "Kia Rio", "White")
;

insert into reparations (id, reparation_date, price, id_car) VALUES 
	(1, "2022-01-02", 1800, 1),
    (2, "2022-01-03", 2100, 2),
    (3, "2022-01-04", 4000, 3),
    (4, "2022-01-05", 3000, 4),
    (5, "2022-01-06", 2500, 5),
    (6, "2022-01-12", 1800, 1)
;




