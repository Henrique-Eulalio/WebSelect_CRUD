

create database registro;
use registro;

create table aluno
(
id int primary key auto_increment,
nombres varchar(50),
email varchar(50)
);

insert into aluno values ('1', 'Fabio', 'perucello@hotmail.com');
insert into aluno values ('4','Fabio', 'educaciencia@fastcode.com');

insert into aluno (nombres, email) values ( 'teste', 'tste');


select * from aluno;