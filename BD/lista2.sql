use lista2;

create table funcionario(
	idFuncionario int primary key auto_increment not null,
    nome varchar(45),
    idade int
);

create table planta(
	idPlanta int primary key auto_increment not null,
    nome varchar(45),
    luzDiaria float,
    aguaDiaria float
);

create table canteiro(
	idCanteiro int primary key auto_increment not null,
    nome varchar(45),
    luzDiaria float,
    aguaDiaria float
);

create table plantio(
	idPlantio int primary key auto_increment not null,
    dataPlantio date,
    sementes int,
    planta_idPlanta int,
    funcionario_idFuncionario int,
    canteiro_idCanteiro int,
    foreign key (planta_idPlanta)
    references planta(idPlanta),
    foreign key (funcionario_idFuncionario)
    references funcionario(idFuncionario),
    foreign key (canteiro_idCanteiro)
    references canteiro(idCanteiro)
);

alter table funcionario drop column idade;
alter table funcionario add column dataNacimento date;
insert into canteiro (nome, luzdiaria, aguaDiaria) values("Canteiro do Cris", 7.10, 4.7);
insert into funcionario (nome, dataNacimento) values ('Cris', '2000-11-30');
insert into plantio (dataPlantio, sementes, planta_idPlanta, funcionario_idFuncionario, canteiro_idCanteiro)
values('2023-08-01', 50, 1, 1, 1);
delete from funcionario;
delete from planta where aguaDiaria > 5;
update canteiro set luzDiaria = 5.0;
update canteiro set aguaDiaria = 10.0 where aguaDiaria < 7;


