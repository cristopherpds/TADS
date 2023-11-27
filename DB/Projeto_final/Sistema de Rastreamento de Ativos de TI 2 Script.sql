CREATE DATABASE SRATI;
USE SRATI;

CREATE TABLE TiposAtivos (
  id int PRIMARY KEY NOT NULL,
  nomeTipo varchar(255) NOT NULL,
  descricaoTipo text
);

CREATE TABLE Ativos (
  id int PRIMARY KEY NOT NULL,
  nomeAtivo varchar(255) NOT NULL,
  numeroSerie varchar(255) NOT NULL,
  modelo varchar(255),
  especificacoesTecnicas text,
  dataAquisicao datetime NOT NULL,
  tipoAtivoId int,
  FOREIGN KEY (tipoAtivoId) REFERENCES TiposAtivos (id)
);

CREATE TABLE Usuarios (
  id int PRIMARY KEY NOT NULL,
  nomeUsuario varchar(255) NOT NULL,
  cargo enum("Admin", "Usuario", "Tecnico") NOT NULL,
  email varchar(255)  NOT NULL,
  telefone varchar(255) NOT NULL,
  endereco varchar(255)
);

CREATE TABLE Movimentacao (
  id int PRIMARY KEY NOT NULL,
  dataMovimentacao datetime NOT NULL,
  localizacaoAnterior varchar(255) NOT NULL,
  localizacaoAtual varchar(255) NOT NULL,
  idAtivo int,
  idUsuario int,
  FOREIGN KEY (idAtivo) REFERENCES Ativos (id),
  FOREIGN KEY (idUsuario) REFERENCES Usuarios (id)
);

CREATE TABLE Manutencao (
  id int PRIMARY KEY NOT NULL,
  dataManutencao datetime NOT NULL,
  descricaoManutencao text NOT NULL,
  custosManutencao decimal NOT NULL,
  idAtivo int,
  FOREIGN KEY (idAtivo) REFERENCES Ativos (id)
);


-- Inserindo dados na tabela TiposAtivos
INSERT INTO TiposAtivos (id, nomeTipo, descricaoTipo) VALUES
(1, 'Computador', 'Dispositivo eletrônico para processamento de dados.'),
(2, 'Impressora', 'Dispositivo para imprimir documentos e imagens.'),
(3, 'Telefone', 'Aparelho de comunicação.'),
(4, 'Monitor', 'Dispositivo de saída que exibe informações visuais.'),
(5, 'Teclado', 'Dispositivo de entrada para inserção de dados.'),
(6, 'Mouse', 'Dispositivo apontador para interação com o computador.'),
(7, 'Roteador', 'Dispositivo de rede para conexão à internet.'),
(8, 'Servidor', 'Computador central para fornecer serviços a outras máquinas.'),
(9, 'Switch', 'Dispositivo de rede para conectar vários dispositivos.'),
(10, 'Câmera', 'Dispositivo para capturar imagens e vídeos.');

-- Inserindo dados na tabela Ativos
INSERT INTO Ativos (id, nomeAtivo, numeroSerie, modelo, especificacoesTecnicas, dataAquisicao, tipoAtivoId) VALUES
(1, 'PC001', 'SN12345', 'Dell OptiPlex', '8GB RAM, 256GB SSD', '2023-01-15', 1),
(2, 'Imp001', 'SN67890', 'HP LaserJet', 'Impressão em preto e branco', '2022-12-20', 2),
(3, 'Tel001', 'SN54321', 'iPhone 13', '128GB de armazenamento', '2023-02-28', 3),
(4, 'Monitor001', 'SN98765', 'Samsung 24"', 'Resolução 1920x1080', '2023-03-10', 4),
(5, 'Teclado001', 'SN24680', 'Logitech K120', 'Layout ABNT2', '2023-04-05', 5),
(6, 'Mouse001', 'SN13579', 'Microsoft Wireless', 'Conexão Bluetooth', '2023-05-20', 6),
(7, 'Roteador001', 'SN11223', 'TP-Link Archer C7', 'Wi-Fi 5 (802.11ac)', '2023-06-15', 7),
(8, 'Servidor001', 'SN99887', 'Dell PowerEdge', 'Xeon Processor, 16GB RAM', '2023-07-30', 8),
(9, 'Switch001', 'SN665544', 'Cisco Catalyst 2960', '24 portas Gigabit Ethernet', '2023-08-25', 9),
(10, 'Câmera001', 'SN443322', 'Sony Alpha a6000', 'Sensor APS-C, 24MP', '2023-09-12', 10);

-- Inserindo dados na tabela Usuarios
INSERT INTO Usuarios (id, nomeUsuario, cargo, email, telefone, endereco) VALUES
(1, 'João', 'Admin', 'joao@email.com', '(11) 1234-5678', 'Rua A, 123'),
(2, 'Maria', 'Usuário', 'maria@email.com', '(11) 9876-5432', 'Rua B, 456'),
(3, 'Pedro', 'Técnico', 'pedro@email.com', '(11) 5555-4444', 'Rua C, 789'),
(4, 'Lucia', 'Admin', 'lucia@email.com', '(11) 2222-3333', 'Rua D, 789'),
(5, 'Ana', 'Usuário', 'ana@email.com', '(11) 8888-9999', 'Rua E, 456'),
(6, 'Marcos', 'Técnico', 'marcos@email.com', '(11) 7777-8888', 'Rua F, 123'),
(7, 'Carla', 'Admin', 'carla@email.com', '(11) 6666-7777', 'Rua G, 789'),
(8, 'Roberto', 'Usuário', 'roberto@email.com', '(11) 3333-2222', 'Rua H, 456'),
(9, 'Sandra', 'Técnico', 'sandra@email.com', '(11) 9999-8888', 'Rua I, 123'),
(10, 'Paulo', 'Admin', 'paulo@email.com', '(11) 4444-5555', 'Rua J, 789');

-- Inserindo dados na tabela Movimentacao
INSERT INTO Movimentacao (id, dataMovimentacao, localizacaoAnterior, localizacaoAtual, idAtivo, idUsuario) VALUES
(1, '2023-01-20', 'Sala A', 'Sala B', 1, 2),
(2, '2023-02-15', 'Depósito', 'Sala Principal', 2, 3),
(3, '2023-03-10', 'Almoxarifado', 'Sala de Reuniões', 3, 4),
(4, '2023-04-05', 'Sala 1', 'Sala 2', 4, 5),
(5, '2023-05-01', 'Recepção', 'Escritório', 5, 6),
(6, '2023-06-20', 'Andar 1', 'Andar 2', 6, 7),
(7, '2023-07-15', 'Sala de Descanso', 'Cozinha', 7, 8),
(8, '2023-08-10', 'Corredor Principal', 'Sala de Treinamento', 8, 9),
(9, '2023-09-25', 'Sala 3', 'Sala 4', 9, 10),
(10, '2023-10-12', 'Sala de TI', 'Sala de Servidores', 10, 1);

-- Inserindo dados na tabela Manutencao
INSERT INTO Manutencao (id, dataManutencao, descricaoManutencao, custosManutencao, idAtivo) VALUES
(1, '2023-02-01', 'Troca de HD', 250.00, 1),
(2, '2023-03-18', 'Limpeza dos Rolos', 100.00, 2),
(3, '2023-04-20', 'Atualização de Sistema', 150.00, 3),
(4, '2023-05-10', 'Calibração de Cores', 80.00, 4),
(5, '2023-06-05', 'Substituição de Teclas', 50.00, 5),
(6, '2023-07-30', 'Manutenção de Conexão', 120.00, 6),
(7, '2023-08-25', 'Atualização de Firmware', 90.00, 7),
(8, '2023-09-15', 'Revisão Geral', 200.00, 8),
(9, '2023-10-05', 'Configuração de Rede', 180.00, 9),
(10, '2023-11-02', 'Limpeza do Sensor', 70.00, 10);



-- Consultas e RelatóriosTarefa

-- Listar todos os ativos
DELIMITER //
CREATE PROCEDURE ListarTodosAtivos()
BEGIN
  SELECT * FROM Ativos;
END //
DELIMITER ;

-- Buscar ativos por tipo
DELIMITER //
CREATE FUNCTION BuscarAtivosPorTipo(tipoAtivoId INT)
RETURNS TABLE
RETURN SELECT * FROM Ativos WHERE tipoAtivoId = tipoAtivoId;
DELIMITER ;

-- Adicionar um novo usuário
DELIMITER //
CREATE PROCEDURE AdicionarNovoUsuario(IN nomeUsuario VARCHAR(255), IN cargo VARCHAR(255), IN email VARCHAR(255), IN telefone VARCHAR(255), IN endereco VARCHAR(255))
BEGIN
  INSERT INTO Usuarios (nomeUsuario, cargo, email, telefone, endereco) VALUES (nomeUsuario, cargo, email, telefone, endereco);
END //
DELIMITER ;

-- Atualizar detalhes do ativo
DELIMITER //
CREATE PROCEDURE AtualizarDetalhesAtivo(IN id INT, IN nomeAtivo VARCHAR(255), IN numeroSerie VARCHAR(255), IN modelo VARCHAR(255), IN especificacoesTecnicas TEXT, IN dataAquisicao DATETIME, IN tipoAtivoId INT)
BEGIN
  UPDATE Ativos SET nomeAtivo = nomeAtivo, numeroSerie = numeroSerie, modelo = modelo, especificacoesTecnicas = especificacoesTecnicas, dataAquisicao = dataAquisicao, tipoAtivoId = tipoAtivoId WHERE id = id;
END //
DELIMITER ;

-- Excluir um ativo
DELIMITER //
CREATE TRIGGER ExcluirAtivo
AFTER DELETE ON Ativos
FOR EACH ROW
BEGIN
  DELETE FROM Ativos WHERE id = OLD.id;
END; //
DELIMITER ;

