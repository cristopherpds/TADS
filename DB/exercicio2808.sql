use sakilapt;
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
where concat(ator.primeiro_nome, ' ', ator.ultimo_nome) = "Leonardo DiCaprio";

-- Listar o título de todos os filmes, o nome do seu idioma e o nome do seu idioma original, mesmo que não possua idioma original.
select filme.titulo as "Nome do fimel", idioma.nome as "Idioma da dublagem", coalesce(filme.idioma_original_id, "Desconhecido")
from filme
inner join idioma
on filme.idioma_id = idioma.idioma_id;

-- Liste o nome e endereço completo (cidade e pais também) de todos os clientes.
select cliente.primeiro_nome, endereco.*, cidade.cidade, pais.pais
from cliente
inner join endereco
on cliente.endereco_id = endereco.endereco_id
inner join cidade
on endereco.cidade_id = cidade.cidade_id
inner join pais
on cidade.pais_id = pais.pais_id;


-- Listar o nome de todos os filmes da loja de id 3.

-- Contar em quantas lojas cada filme está disponível, mostrando o nome do filme e o número de lojas, mas apenas aqueles filmes que estão em 2 ou mais lojas.

-- Quais atores não atuam em nenhum filme? Mostre eles ordenados pelo primeiro nome, e caso sejam tenham o mesmo nome ordenados pelo segundo nome.

-- Relacione os clientes que possuem seu primeiro nome igual ao último nome de outros clientes. (Self join)



