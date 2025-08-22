create database cinehome;

USE cinehome;
drop table filmes;
create table filmes(
id int not null auto_increment,
idUsuario int,
nome varchar(50),
genero varchar(20),
produtor varchar(30),
ano varchar(20),
primary key(id),
foreign key(idUsuario) references usuario(id)
);

drop table usuario;
create table usuario(
id int not null auto_increment,
idTipo int,
nome varchar(30),
telefone varchar(30),
email varchar(50),
senha varchar(30),
login varchar(50),
primary key(id),
foreign key(idTipo) references nivel_acesso(id)
);

create table nivel_acesso(
id int primary key not null auto_increment,
descricao varchar(20)
);

insert into nivel_acesso(id, descricao) values
("1","Administrador"),
("2","Operador"),
("3","Usuário");

INSERT INTO usuario (id, idTipo, nome, telefone, email, senha, login) VALUES 
(1, 1, 'Lucas ', '11999999999', 'admin@email.com', '123456', 'admin'),
(2, 2, 'Maria ', '21988888888', 'maria@email.com', 'abcdef', 'maria'),
(3, 3, 'João ', '31977777777', 'joao@email.com', '654321', 'joao'),
(4, 1, 'Ana ', '41966666666', 'ana@email.com', 'senha123', 'ana'),
(5, 2, 'Carlos ', '51955555555', 'carlos@email.com', 'pass789', 'carlos'),
(6, 3, 'Fernanda ', '61944444444', 'fernanda@email.com', 'minhasenha', 'fernanda');

select * from usuario;
select * from filmes;
