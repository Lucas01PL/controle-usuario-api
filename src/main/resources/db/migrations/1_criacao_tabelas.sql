create SCHEMA administrativo;

create table administrativo.papel 
(
 id serial primary key,
 descricao varchar
);

create table administrativo.funcao
(
 id serial primary key,
 descricao varchar
);

create table administrativo.funcao_papel
(
 id serial primary key,
 funcao_id integer references administrativo.funcao(id),
 papel_id integer references administrativo.papel(id)
);

create table administrativo.usuario 
(
 id serial primary key,
 nome varchar(100) not null,
 cpf varchar(14) not null unique,
 data_nascimento date not null,
 genero varchar(1) check (genero in ('M', 'F')),
 funcao_id integer references administrativo.funcao(id)
);

create table administrativo.usuario_papel
(
 id serial primary key,
 usuario_id integer references administrativo.usuario(id),
 papel_id integer references administrativo.papel(id)
);