-- aula 21/08 - agregacao, ordenacao e subquery
use sakilapt;

# maior valor da tabela pagamento
select MAX(valor)
from pagamento;

# menor valor da tabela pagamento
select MIN(valor)
from pagamento;

# qual o total ja pago?
select SUM(valor)
from pagamento;

# qual o total pago pelo cliente de id = 20
select SUM(valor)
from pagamento where cliente_id = 20;

# media do valor pago
select AVG(valor)
from pagamento;

# contar quantos clientes existem
select count(*)
from cliente;

# contar quantos pagamento o cliente de id 20 ja efetuou
select count(*)
from pagamento where cliente_id = 20;


# qual o total que cada cliente ja pago?
select cliente_id, sum(valor)
from pagamento
group by cliente_id;

# contar quantos funcionarios tem em cada loja
select loja_id, count(*)
from funcionario
group by loja_id;

# qual os clientes que ja pagaram mais que 100?
select cliente_id
from pagamento
group by  cliente_id
having SUM(valor) > 100;

# mostre priemero e ultimo nome dos cleintes, ordenados pelo
# ultimo nome em ordem ascendente e pelo primero nome de forma decendente

select primeiro_nome, ultimo_nome 
from cliente
order by primeiro_nome desc, ultimo_nome;


#Aula 28/08
# Com base no banco de dados Sakila em português responda com o script SQL que resolva a questão:

-- Listar o nome dos clientes (primeiro e último) que realizaram pagamentos com valor maior do que 2.5.
select distinct cliente.primeiro_nome, cliente.ultimo_nome
from cliente
inner join pagamento 
on cliente.cliente_id = pagamento.cliente_id
where pagamento.valor > 2.5;

-- Listar o título de todos os filmes e o nome do seu idioma.
select distinct filme.titulo, idioma.nome
from filme
inner join idioma
on filme.idioma_id = idioma.idioma_id;

-- Listar os títulos dos filmes em que o ator "Leonardo DiCaprio" atua.
select filme.titulo
from filme
inner join filme_ator
on filme.filme_id = filme_ator.filme_id
inner join ator
on ator.ator_id = filme_ator.ator_id
where ator.primeiro_nome + ator.ultimo_nome = "Leonardo DiCaprio"; 

-- Listar o título de todos os filmes, o nome do seu idioma e o nome do seu idioma original, mesmo que não possua idioma original.

-- Liste o nome e endereço completo (cidade e pais também) de todos os clientes.

-- Listar o nome de todos os filmes da loja de id 3.

-- Contar em quantas lojas cada filme está disponível, mostrando o nome do filme e o número de lojas, mas apenas aqueles filmes que estão em 2 ou mais lojas.

-- Quais atores não atuam em nenhum filme? Mostre eles ordenados pelo primeiro nome, e caso sejam tenham o mesmo nome ordenados pelo segundo nome.

-- Relacione os clientes que possuem seu primeiro nome igual ao último nome de outros clientes. (Self join)



