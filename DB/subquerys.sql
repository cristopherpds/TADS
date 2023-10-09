use sakilapt;

select 
    c.primeiro_nome,
    (select cid.cidade
		from cidade cid
        where(select e.cidade_id
			from endereco e
			where e.endereco_id = c.endereco_id) = cid.cidade_id) as nome_cidade
from cliente c;
