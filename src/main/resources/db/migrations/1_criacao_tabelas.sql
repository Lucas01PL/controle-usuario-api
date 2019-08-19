create SCHEMA administrativo;

create table administrativo.papel 
(
 id serial primary key,
 descricao varchar
);

create table administrativo.funcao
(
 id serial primary key,
 nome varchar
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

insert into administrativo.funcao(nome) values ('ADMINISTRADOR'), ('USUÁRIO COMUM');

insert into administrativo.papel(descricao) values ('ADMINISTRADOR-1'), ('ADMINISTRADOR-2');

insert into administrativo.papel(descricao) values ('USUÁRIO-1'), ('USUÁRIO-2');

insert into administrativo.funcao_papel(funcao_id, papel_id) values (1, 1), (1, 2);

insert into administrativo.funcao_papel(funcao_id, papel_id) values (2, 3), (2, 4);