use sakilapt;

# 1. Listar todos os pagamentos com valores entre 2 e 5.5, ordenados pela data de pagamento, dos últimos realizados para os primeiros.
select *
from pagamento
order by data_de_pagamento desc;

# 2. Qual o total recebido de pagamentos?
select sum(valor)
from pagamento;

# 3. Quantos filmes estão cadastrados?
select count(filme_id)
from filme;

# 4. Qual a média de duração dos filmes?
select avg(duracao_do_filme)
from filme;

# 5. Quantos endereços estão cadastrados na mesma cidade?
select count(endereco_id) as quantidade_enderecos, cidade_id
from endereco
group by cidade_id;

# 6. Quantos filmes estão em cada categoria?
select c.categoria_id, c.nome as nome_categoria, count(fc.filme_id) as quantidade_filmes
from categoria c
join filme_categoria fc on c.categoria_id = fc.categoria_id
group by c.categoria_id, c.nome
order by c.categoria_id;

# 7. Qual o id das categorias com mais de 15 filmes, ordenados de forma descendente?
select categoria_id, count(filme_id) as quantidade_filmes
from filme_categoria
group by categoria_id
having quantidade_filmes > 15
order by quantidade_filmes desc;

# 8. Quantos clientes foram cadastrados após o dia '2020-01-06'?
select count(cliente_id) as quantidade_clientes
from cliente
where data_criacao > '2020-01-06';

# 9. Quantos alugueis foram realizados pelos clientes de id maior do que 100 e que tenham realizados mais do que 20 alugueis.
select c.cliente_id, count(a.aluguel_id) as quantidade_alugueis
from cliente c
join aluguel a on c.cliente_id = a.cliente_id
where c.cliente_id > 100
group by c.cliente_id
having quantidade_alugueis > 20;

# 10. Listar o primeiro e ultimo nome de todos os funcionários, ordenados pelo seu usuário, mas apenas aqueles que não tenham a senha cadastrada.
select primeiro_nome, ultimo_nome
from funcionario
where senha is null
order by usuario;
