drop database crudquarkus;
create database crudquarkus;
use crudquarkus;

create table estado(
	uf varchar(2) primary key,
    descricao varchar(30)
)ENGINE = innodb;

create table cidade(
	id int primary key auto_increment,
    descricao varchar(200) not null,
    uf varchar(2) not null,
    foreign key (uf) references estado (uf) on delete cascade on update no action
)ENGINE = innodb;

create table pessoa(
	id int primary key auto_increment,
    nome varchar(200),
    cpf varchar(14),
    idade int,
	endereco varchar(300),
    cidade_id int not null,
	foreign key (cidade_id) references cidade (id) on delete cascade on update no action
)ENGINE = innodb;

insert into estado values ('SP', 'São Paulo');
insert into estado values ('RJ', 'Rio de Janeiro');
insert into estado values ('MG', 'Minas Gerais');
insert into estado values ('ES', 'Espírito Santo');
insert into estado values ('BA', 'Bahia');

insert into cidade values (null, 'São Paulo', 'SP');
insert into cidade values (null, 'São José do Rio Preto', 'SP');
insert into cidade values (null, 'Rio de Janeiro', 'RJ');
insert into cidade values (null, 'Belo Horizonte', 'MG');
insert into cidade values (null, 'Vitória', 'ES');
insert into cidade values (null, 'Salvador', 'BA');