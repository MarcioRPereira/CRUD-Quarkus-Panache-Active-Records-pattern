create database crudquarkus;

use crudquarkus;

create table pessoa(
	id int primary key auto_increment,
    nome varchar(200),
    cpf varchar(14),
    idade int
);