create table espaco_cafe(
id integer not null,
nome varchar (50) not null,
lotacao integer not null,
primary key (id)
);

insert into espaco_cafe (id,nome,lotacao)
values (1, "Espaco Cafe 1",25);

insert into espaco_cafe (id,nome,lotacao)
values (2, "Espaco Cafe 2",25);

create table pessoa(
id integer not null,
nome varchar (50) not null,
sobrenome varchar(50) not null,
primary key (id)
);

insert into pessoa(id,nome,sobrenome)
values (1,"João", "Silva");

insert into pessoa(id,nome,sobrenome)
values (2,"Paulo", "Costa");

create table sala_evento(
id integer not null,
nome varchar (50) not null,
lotacao integer not null,
primary key (id)
);

insert into sala_evento(id,nome,lotacao)
values (1,"Sala Evento 1",25);

insert into sala_evento(id,nome,lotacao)
values (2,"Sala Evento 2",25);