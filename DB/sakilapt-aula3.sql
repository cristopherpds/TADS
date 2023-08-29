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


