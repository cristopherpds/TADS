CREATE DATABASE barber_shop;
USE barber_shop;

-- Criando a tabela Cliente
CREATE TABLE Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(255)
);

-- Criando a tabela Funcionario
CREATE TABLE Funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cargo VARCHAR(255),
    salario DOUBLE,
    comissao DOUBLE,
    horario DATETIME
);

-- Criando a tabela Produto
CREATE TABLE Produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    preco DOUBLE,
    quantidade_em_estoque INT
);

-- Criando a tabela Servico
CREATE TABLE Servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    duracao VARCHAR(255),
    valor DOUBLE
);

-- Criando a tabela Venda
CREATE TABLE Venda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data DATETIME,
    cliente_id BIGINT,
    funcionario_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (funcionario_id) REFERENCES Funcionario(id)
);

CREATE TABLE Venda_Produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    venda_id BIGINT,
    produto_id BIGINT,
    quantidade INT,
    FOREIGN KEY (venda_id) REFERENCES Venda(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);

-- Criando a tabela Agendamento
CREATE TABLE Agendamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME,
    cliente_id BIGINT,
    servico_id BIGINT,
    funcionario_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (servico_id) REFERENCES Servico(id),
    FOREIGN KEY (funcionario_id) REFERENCES Funcionario(id)
);

-- Criando a tabela Estoque
CREATE TABLE Estoque (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produto_id BIGINT,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);

-- Criando a tabela Pagamento
CREATE TABLE Pagamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor INT,
    data DATETIME,
    forma_pagamento VARCHAR(255),
    venda_id BIGINT,
    agendamento_id BIGINT,
    FOREIGN KEY (venda_id) REFERENCES Venda(id),
    FOREIGN KEY (agendamento_id) REFERENCES Agendamento(id)
);

-- Criando view para Relatório de Vendas por Dia
CREATE VIEW Relatorio_Vendas_Por_Dia AS
SELECT DATE(data) AS dia, COUNT(*) AS total_vendas
FROM Venda
GROUP BY DATE(data)
ORDER BY dia;

-- Criando view para Relatório de Vendas por Funcionário
CREATE VIEW Relatorio_Vendas_Por_Funcionario AS
SELECT f.nome AS funcionario, COUNT(v.id) AS total_vendas
FROM Venda v
JOIN Funcionario f ON v.funcionario_id = f.id
GROUP BY f.nome
ORDER BY total_vendas DESC;

-- Criando view para Relatório de Produtos Mais Vendidos
CREATE VIEW Relatorio_Produtos_Mais_Vendidos AS
SELECT p.nome AS produto, SUM(vp.quantidade) AS quantidade_vendida
FROM Venda_Produto vp
JOIN Produto p ON vp.produto_id = p.id
GROUP BY p.nome
ORDER BY quantidade_vendida DESC;

SELECT * FROM Relatorio_Vendas_Por_Dia;
SELECT * FROM Relatorio_Vendas_Por_Funcionario;
SELECT * FROM Relatorio_Produtos_Mais_Vendidos;


INSERT INTO Cliente (nome, telefone, email, cpf) VALUES
('João Silva', '123456789', 'joao@example.com', '111.222.333-44'),
('Maria Oliveira', '987654321', 'maria@example.com', '222.333.444-55'),
('Carlos Pereira', '456123789', 'carlos@example.com', '333.444.555-66'),
('Ana Costa', '789456123', 'ana@example.com', '444.555.666-77'),
('Pedro Santos', '321654987', 'pedro@example.com', '555.666.777-88'),
('Lucas Lima', '654987321', 'lucas@example.com', '666.777.888-99'),
('Fernanda Souza', '147258369', 'fernanda@example.com', '777.888.999-00'),
('Juliana Rocha', '369258147', 'juliana@example.com', '888.999.000-11'),
('Ricardo Alves', '258147369', 'ricardo@example.com', '999.000.111-22'),
('Patricia Mendes', '159753486', 'patricia@example.com', '000.111.222-33');


INSERT INTO Funcionario (nome, cargo, salario, comissao, horario) VALUES
('Lucas Martins', 'Vendedor', 2500.00, 5.00, '2023-10-01 08:00:00'),
('Mariana Silva', 'Gerente', 4500.00, 10.00, '2023-10-01 09:00:00'),
('Rafael Costa', 'Caixa', 2000.00, 3.00, '2023-10-01 10:00:00'),
('Beatriz Lima', 'Vendedor', 2500.00, 5.00, '2023-10-01 11:00:00'),
('Fernando Souza', 'Supervisor', 3500.00, 7.00, '2023-10-01 12:00:00'),
('Camila Rocha', 'Barbeiro', 3000.00, 8.00, '2023-10-01 13:00:00'),
('Gustavo Alves', 'Barbeiro', 3000.00, 8.00, '2023-10-01 14:00:00'),
('Larissa Mendes', 'Barbeiro', 3000.00, 8.00, '2023-10-01 15:00:00'),
('Thiago Santos', 'Vendedor', 2500.00, 5.00, '2023-10-01 16:00:00'),
('Isabela Pereira', 'Supervisor', 3500.00, 7.00, '2023-10-01 17:00:00');

INSERT INTO Produto (nome, descricao, preco, quantidade_em_estoque) VALUES
('Notebook', 'Notebook Dell Inspiron', 3500.00, 10),
('Smartphone', 'iPhone 12', 4500.00, 15),
('Tablet', 'Samsung Galaxy Tab', 1500.00, 20),
('Monitor', 'Monitor LG 24"', 800.00, 25),
('Teclado', 'Teclado Mecânico', 250.00, 30),
('Mouse', 'Mouse Sem Fio', 150.00, 35),
('Impressora', 'Impressora HP', 600.00, 5),
('Cadeira', 'Cadeira Gamer', 700.00, 8),
('Mesa', 'Mesa para Escritório', 500.00, 12),
('Fone de Ouvido', 'Fone Bluetooth', 200.00, 18);

INSERT INTO Servico (nome, duracao, valor) VALUES
('Corte de Cabelo', '30 minutos', 50.00),
('Manicure', '45 minutos', 40.00),
('Pedicure', '45 minutos', 45.00),
('Massagem', '1 hora', 100.00),
('Limpeza de Pele', '1 hora', 80.00),
('Depilação', '30 minutos', 60.00),
('Sobrancelha', '15 minutos', 30.00),
('Maquiagem', '1 hora', 120.00),
('Escova', '30 minutos', 70.00),
('Coloração', '2 horas', 150.00);

INSERT INTO Servico (nome, duracao, valor) VALUES
('Corte de Cabelo', '30 minutos', 50.00),
('Manicure', '45 minutos', 40.00),
('Pedicure', '45 minutos', 45.00),
('Massagem', '1 hora', 100.00),
('Limpeza de Pele', '1 hora', 80.00),
('Depilação', '30 minutos', 60.00),
('Sobrancelha', '15 minutos', 30.00),
('Maquiagem', '1 hora', 120.00),
('Escova', '30 minutos', 70.00),
('Coloração', '2 horas', 150.00);

INSERT INTO Venda (data, cliente_id, funcionario_id) VALUES
('2023-10-01 10:00:00', 1, 1),
('2023-10-02 11:00:00', 2, 2),
('2023-10-03 12:00:00', 3, 3),
('2023-10-04 13:00:00', 4, 4),
('2023-10-05 14:00:00', 5, 5),
('2023-10-06 15:00:00', 6, 6),
('2023-10-07 16:00:00', 7, 7),
('2023-10-08 17:00:00', 8, 8),
('2023-10-09 18:00:00', 9, 9),
('2023-10-10 19:00:00', 10, 10);

INSERT INTO Agendamento (data_hora, cliente_id, servico_id, funcionario_id) VALUES
('2023-10-01 09:00:00', 1, 1, 1),
('2023-10-02 10:00:00', 2, 2, 2),
('2023-10-03 11:00:00', 3, 3, 3),
('2023-10-04 12:00:00', 4, 4, 4),
('2023-10-05 13:00:00', 5, 5, 5),
('2023-10-06 14:00:00', 6, 6, 6),
('2023-10-07 15:00:00', 7, 7, 7),
('2023-10-08 16:00:00', 8, 8, 8),
('2023-10-09 17:00:00', 9, 9, 9),
('2023-10-10 18:00:00', 10, 10, 10);

INSERT INTO Estoque (produto_id) VALUES
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10);

INSERT INTO Pagamento (valor, data, forma_pagamento, venda_id, agendamento_id) VALUES
(100, '2023-10-01 10:00:00', 'Cartão de Crédito', 1, NULL),
(200, '2023-10-02 11:00:00', 'Dinheiro', 2, NULL),
(150, '2023-10-03 12:00:00', 'Cartão de Débito', NULL, 1),
(250, '2023-10-04 13:00:00', 'Cartão de Crédito', 3, NULL),
(300, '2023-10-05 14:00:00', 'Dinheiro', NULL, 2),
(350, '2023-10-06 15:00:00', 'Cartão de Débito', 4, NULL),
(400, '2023-10-07 16:00:00', 'Cartão de Crédito', NULL, 3),
(450, '2023-10-08 17:00:00', 'Dinheiro', 5, NULL),
(500, '2023-10-09 18:00:00', 'Cartão de Débito', NULL, 4),
(550, '2023-10-10 19:00:00', 'Cartão de Crédito', 6, NULL);

INSERT INTO Venda_Produto (venda_id, produto_id, quantidade) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 1),
(2, 4, 2),
(3, 5, 1),
(3, 6, 3),
(4, 7, 1),
(4, 8, 2),
(5, 9, 1),
(5, 10, 1);