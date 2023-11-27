USE lista3;
#CONtE EM QUaNTAS cidades diferentes existem clientes.
Select count(distincT CIDAdE) AS CIDADES_diferenTeS_tem_clinte  from cliente;

#ContE QUantos produtos são vendidos para cada tipo unidade (unid_prod).
select unid_prod, couNT(*) AS total_pRoDUTOS
FRoM produto
group by UNId_prod;

#APREsENte o número do pedido com o maior número de produtos.
select no_ped
from item_PEDIDo
group BY No_ped
order bY COUnT(cd_prod) DESC
LImIT 1;


#ApreSeNTE a MÉDIa salarial dos funcionários.
select avg(sal_fixo) as mEDIA_SaLARIo from vEnDEdor;

#Conte quANTOs clientes existem em cada cidade, apresentando o nome da cidade e a quantidade de clientes.
select cidade, count(*) aS QUANtidade_ClIENTES
FrOM cliente
group by cidADE;

#ApreseNTE O MAior e o menor valor de um produto.
select max(val_unit) as mAIOR_VaLOR, min(val_uNIt) as menor_VaLOR
from proDuTO;


#ApresentE A média dos prazos de entrega dos pedidos de cada vendedor, mas apenas para aqueles em que a média seja menor do 15.
select cd_vend, avg(prazo_eNTR) As media_PrAZO
from pedidO
GRoup by cd_venD
HAving avg(PRAZo_Entr) < 15;

#REaLIZE a mesma cOnSuLTa acima, mas agora mostrando o nome do vendedor e a média, ordenando pela média.
select v.nome_vend, avg(p.praZO_ENTr) as media_PrAZO
fRom pedido P
JOin vendedor v ON p.cd_vend = V.cod_vend
groUP bY p.cd_veNd, v.nome_veND
HAvINg Avg(p.prAzo_entr) < 15
ORDER BY MeDia_prazo;

#ApREsENTE oS dados dos pedidos, mostrando o nome do cliente e o nome do vendedor.
SELECT c.nome_cli, v.nome_vend
FROM pedido p
JOIN cliente c ON p.cd_cli = c.cod_cli
JOIN vendedor v ON p.cd_vend = v.cod_vend;

#CRIe Uma view Com todos os dados dos produtos comprados pelo cliente de id 5, incluindo o código do produto, descrição, quantidade, e o valor total (quantidade * valor unitario)
CREATE VIEW produtos_cliente_4 AS
SELECT ip.cd_prod, prod.desc_prod, ip.qtd_ped, (ip.qtd_ped * prod.val_unit) AS valor_total
FROM item_pedido ip
JOIN produto prod ON ip.cd_prod = prod.cod_prod
JOIN pedido p ON ip.no_ped = p.num_ped
WHERE p.cd_cli = 4;

#Consulte a view acima e apresente a descrição do produto com maior valor total.
SELECT desc_prod
FROM produtos_cliente_4
ORDER BY valor_total DESC
LIMIT 1;

#Crie uma view com todos os dados dos pedidos, incluindo os dados dos clientes e os dados dos vendedores.
CREATE VIEW pedidos_clientes_vendedores AS
SELECT p.*, c.*, v.*
FROM pedido p
JOIN cliente c ON p.cd_cli = c.cod_cli
JOIN vendedor v ON p.cd_vend = v.cod_vend;

#Consulte na view acima o nome dos clientes que já fizeram 2 ou mais pedidos.
SELECT nome_cli
FROM pedidos_clientes_vendedores
GROUP BY nome_cli
HAVING COUNT(num_ped) >= 2;

#Liste o nome de todas as pessoas cadastradas no banco de dados.
SELECT nome_cli AS nome_pessoa FROM cliente
UNION
SELECT nome_vend AS nome_pessoa FROM vendedor;

#Utilizando union, liste a descrição e e o valor unitário dos produtos que são vendidos por litro (lt), e kilo (kg).
SELECT desc_prod, val_unit FROM produto WHERE unid_prod = 'lt'
UNION
SELECT desc_prod, val_unit FROM produto WHERE unid_prod = 'kg';

#Utilizando subquery, liste o nome de todos os clientes que fizeram pedido com o vendedor Luciano.
SELECT nome_cli
FROM cliente
WHERE cod_cli IN (SELECT cd_cli FROM pedido WHERE cd_vend = (SELECT cod_vend FROM vendedor WHERE nome_vend = 'Luciano'));

#Utilizando subquery, conte quantos pedidos foram realizados por cada vendedor.
SELECT nome_vend, COUNT(num_ped) AS total_pedidos
FROM vendedor
JOIN pedido ON vendedor.cod_vend = pedido.cd_vend
GROUP BY nome_vend;

#Liste o nome dos vendedores que ganham mais do que a média salarial.
SELECT nome_vend
FROM vendedor
WHERE sal_fixo > (SELECT AVG(sal_fixo) FROM vendedor);


#Utilizando subquery, liste o nome dos vendedores e que fizeram pedidos com valor total maior do que 100 (dica, primeiro crie uma "tabela"  com o valor total dos pedidos, e depois realize a outra query)
SELECT v.nome_vend
FROM vendedor v
JOIN pedido p ON v.cod_vend = p.cd_vend
WHERE p.num_ped IN (
    SELECT no_ped
    FROM item_pedido
    GROUP BY no_ped
    HAVING SUM(qtd_ped * (SELECT val_unit FROM produto WHERE cod_prod = cd_prod)) > 100
);

#Utilizando subquery, liste o total pedido para cada produto cadastrado no banco.
SELECT ip.cd_prod, p.desc_prod, SUM(ip.qtd_ped * p.val_unit) AS total_pedido
FROM item_pedido ip
JOIN produto p ON ip.cd_prod = p.cod_prod
GROUP BY ip.cd_prod, p.desc_prod;

-- Parte II

#crie uma função que retorne a comissão de um determinado vendedor, sabendo que ele ganha 0,1% do seu salário para cada pedido realizado.
DELIMITER //
CREATE FUNCTION calcular_comissao(cod_vendedor INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE comissao DECIMAL(10,2);
    DECLARE total_pedidos INT;
    
    SELECT COUNT(*) INTO total_pedidos FROM pedido WHERE cd_vend = cod_vendedor;
    SET comissao = total_pedidos * 0.001 * (SELECT sal_fixo FROM vendedor WHERE cod_vend = cod_vendedor);
    
    RETURN comissao;
END //
DELIMITER ;

#crie uma função que calcule o total de um pedido, com numero recebido por parâmetro, somando o total para cada um dos itens do pedido.
DELIMITER //
CREATE FUNCTION calcular_total_pedido(num_pedido INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE total_pedido DECIMAL(10,2);
    
    SELECT SUM(ip.qtd_ped * p.val_unit)
    INTO total_pedido
    FROM item_pedido ip
    JOIN produto p ON ip.cd_prod = p.cod_prod
    WHERE ip.no_ped = num_pedido;
    
    RETURN total_pedido;
END //
DELIMITER ;

#Crie um procedimento que zere o prazo de entrega de todos os pedidos de um determinado cliente (recebido por parâmetro).
DELIMITER //
CREATE PROCEDURE zerar_prazo_entrega_cliente(codigo_cliente INT)
BEGIN
    UPDATE pedido
    SET prazo_entr = 0
    WHERE cd_cli = codigo_cliente;
END //
DELIMITER ;

#crie um procedimento que atualize o salário de um vendedor, recebendo por parâmetro o nome do vendedor e o novo salário.
DELIMITER //
CREATE PROCEDURE atualizar_salario_vendedor(nome_vendedor VARCHAR(40), novo_salario DECIMAL(10,2))
BEGIN
    UPDATE vendedor
    SET sal_fixo = novo_salario
    WHERE nome_vend = nome_vendedor;
END //
DELIMITER ;

#Crie uma trigger que ao incluir um produto, verifique se a descrição não está duplicada.
DELIMITER //
CREATE TRIGGER evitar_duplicata_produto
BEFORE INSERT ON produto
FOR EACH ROW
BEGIN
    DECLARE num_rows INT;
    SELECT COUNT(*) INTO num_rows FROM produto WHERE desc_prod = NEW.desc_prod;
    IF num_rows > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Descrição de produto já existe';
    END IF;
END;
//
DELIMITER ;
#Crie uma trigger que elimine todos os pedidos de um produto quando ele for apagado do banco.
DELIMITER //
CREATE TRIGGER eliminar_pedidos_on_delete
AFTER DELETE ON produto
FOR EACH ROW
BEGIN
    DELETE FROM pedido WHERE num_ped IN (SELECT no_ped FROM item_pedido WHERE cd_prod = OLD.cod_prod);
END;
//
DELIMITER ;