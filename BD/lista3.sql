create database lista3;
use lista3;

create table cliente(
	cod_cli int primary key,
    nome_cli varchar(45),
    endereco varchar(45),
    cidade varchar(45),
    cep varchar(45),
    uf varchar(45)
);

create table vendedor(
	cod_vend int primary key,
    nome_vend varchar(45),
    sal_fixo varchar(45),
    faixa_comiss varchar(1)
);

create table produto(
	cod_prod int primary key,
    unid_prod varchar(45),
    desc_prod varchar(45),
    val_unit float
);

create table pedido(
	num_ped int primary key,
    prazo_entr varchar(45),
    cd_cli int,
    cd_vend int,
	foreign key (cd_cli)
    references cliente(cod_cli),
	foreign key (cd_vend)
    references vendedor(cod_vend)
);

create table item_pedido(
	no_ped int,
    cd_prod int,
    qtd_ped int,
	primary key (no_ped, cd_prod),
	foreign key (no_ped)
    references pedido(num_ped),
	foreign key (cd_prod)
    references produto(cod_prod)
);


insert into cliente (cod_cli, nome_cli, endereco, cidade, cep, uf)
values
    (1, 'João Silva', 'Rua A', 'São Paulo', '12345-678', 'SP'),
    (2, 'Maria Santos', 'Avenida B', 'Rio de Janeiro', '98765-432', 'RJ'),
    (3, 'Pedro Oliveira', 'Rua C', 'Niterói', '54321-876', 'RJ'),
    (4, 'Ana Souza', 'Rua D', 'Niterói', '54321-876', 'RJ'),
    (5, 'Carlos Pereira', 'Avenida E', 'São Paulo', '12345-678', 'SP');


insert into vendedor (cod_vend, nome_vend, sal_fixo, faixa_comiss)
values
    (1, 'Ana Cristina', '1500.00', 'A'),
    (2, 'Carlos Ferreira', '2000.00', 'B'),
    (3, 'Mariana Rodrigues', '1800.00', 'C'),
    (4, 'Ricardo Oliveira', '1700.00', 'B'),
    (5, 'Paula Mendes', '1600.00', 'A');


insert into produto (cod_prod, unid_prod, desc_prod, val_unit)
values
    (1, 'Kg', 'Arroz', 2.5),
    (2, 'Un', 'Cimento', 15.0),
    (3, 'L', 'Água Mineral', 2.0),
    (4, 'Un', 'Lápis', 1.0),
    (5, 'L', 'Leite', 3.0);

insert into pedido (num_ped, prazo_entr, cd_cli, cd_vend)
values
    (1001, '2023-08-20', 1, 1),
    (1002, '2023-08-25', 2, 2),
    (1003, '2023-08-23', 3, 1),
    (1004, '2023-08-28', 4, 3),
    (1005, '2023-08-22', 5, 4);


insert into item_pedido (no_ped, cd_prod, qtd_ped)
values
    (1001, 1, 300),
    (1001, 2, 50),
    (1002, 3, 100),
    (1003, 4, 200),
    (1004, 5, 150),
    (1005, 1, 400),
    (1005, 3, 75);



select nome_cli, cidade, uf from cliente;

select no_ped, cd_prod, qtd_ped from item_pedido where qtd_ped = 500;

select * from cliente where cidade = 'Niterói';

select nome_cli from cliente where uf <> 'SP';

select * from pedido where cd_vend = 1 and prazo_entr > 5;

select nome_cli from cliente where uf = 'RJ' and cidade <> 'Rio de Janeiro';

select desc_prod, val_unit from produto where unid_prod = 'L' or val_unit <> 4.5;

select * from pedido where cd_cli > 1000 and (cd_vend = 4 or cd_vend = 5);

select cod_prod, desc_prod from produto where val_unit between 0.10 and 3.00;

select * from produto where unid_prod like 'k%';

select * from vendedor where nome_vend not like 'A%';

select * from cliente where endereco is null;

select nome_vend, sal_fixo from vendedor order by nome_vend;

select nome_cli, endereco from cliente where (uf = 'SP' or uf = 'RJ') and nome_cli like 'R%' order by cep desc;

select nome_vend, (0.75 * cast(sal_fixo as decimal(10, 2)) + 120) as novo_salario from vendedor where faixa_comiss = 'C';

select min(cast(sal_fixo as decimal(10, 2))) as menor_salario, max(cast(sal_fixo as decimal(10, 2))) as maior_salario from vendedor;

select sum(qtd_ped) as total_pedidos from item_pedido where cd_prod = 2;

select sum(cast(sal_fixo as decimal(10, 2))) as total_folha_salarial from vendedor;

select avg(cast(sal_fixo as decimal(10, 2))) as media_salarios from vendedor;

select count(*) as num_vendedores from vendedor where cast(sal_fixo as decimal(10, 2)) = 2000.00;

select c.nome_cli, p.cd_cli, p.num_ped from cliente c inner join pedido p on c.cod_cli = p.cd_cli;

select c.nome_cli from cliente c inner join pedido p on c.cod_cli = p.cd_cli where p.prazo_entr > 15 and (c.uf = 'SP' or c.uf = 'RJ');

select c.nome_cli, p.prazo_entr from cliente c inner join pedido p on c.cod_cli = p.cd_cli order by p.prazo_entr desc;

select c.nome_cli from cliente c
join pedido p on c.cod_cli = p.cd_cli
join item_pedido i on p.num_ped = i.no_ped
where c.uf = 'RJ' and i.cd_prod = 2 and p.prazo_entr > 15
order by c.nome_cli;

select count(distinct p.cd_cli) as num_clientes from pedido p
join vendedor v on p.cd_vend = v.cod_vend
where v.nome_vend = 'Ana Cristina';

select c.* from cliente c
left join pedido p on c.cod_cli = p.cd_cli
where p.num_ped is null;

select p.num_ped, coalesce(c.nome_cli, 'Cliente Desconhecido') as nome_cliente
from pedido p
left join cliente c on p.cd_cli = c.cod_cli;

select nome_cli from cliente c
left join pedido p on c.cod_cli = p.cd_cli
where p.num_ped is null;

select distinct pr.desc_prod from produto pr
left join item_pedido ip on pr.cod_prod = ip.cd_prod
where ip.qtd_ped is null or ip.qtd_ped < 200;




