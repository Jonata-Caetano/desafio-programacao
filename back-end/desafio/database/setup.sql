create table espaco_cafe(
id integer not null,
nome varchar (50) not null,
lotacao integer not null,
primary key (id)
);

create table pessoa(
id integer not null,
nome varchar (50) not null,
sobrenome varchar(50) not null,
primary key (id)
);

create table sala_evento(
id integer not null,
nome varchar (50) not null,
lotacao integer not null,
primary key (id)
);

