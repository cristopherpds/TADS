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

-- Inserindo 10 dados fictícios na tabela TiposAtivos
INSERT INTO TiposAtivos (id, nomeTipo, descricaoTipo) VALUES
(1, 'Computador', 'Computadores de mesa'),
(2, 'Notebook', 'Laptops portáteis'),
(3, 'Impressora', 'Impressoras laser e jato de tinta'),
(4, 'Monitor', 'Monitores LCD e LED'),
(5, 'Teclado', 'Teclados USB'),
(6, 'Mouse', 'Mouses sem fio'),
(7, 'Projetor', 'Projetores de alta resolução'),
(8, 'Telefone', 'Telefones VoIP'),
(9, 'Servidor', 'Servidores de alto desempenho'),
(10, 'Scanner', 'Scanners de documentos');

-- Inserindo 10 dados fictícios na tabela Ativos
INSERT INTO Ativos (id, nomeAtivo, numeroSerie, modelo, especificacoesTecnicas, dataAquisicao, tipoAtivoId) VALUES
(1, 'PC001', 'SN12345', 'Dell Optiplex', 'CPU: i7, RAM: 8GB, HDD: 1TB', '2023-01-15 10:00:00', 1),
(2, 'Laptop001', 'SN67890', 'HP EliteBook', 'CPU: i5, RAM: 16GB, SSD: 256GB', '2023-02-20 14:30:00', 2),
(3, 'Printer001', 'SN54321', 'Epson WorkForce', 'Impressora a jato de tinta', '2023-03-10 08:45:00', 3),
(4, 'Monitor001', 'SN98765', 'LG Ultrawide', 'Resolução: 2560x1080, 29 polegadas', '2023-04-05 12:15:00', 4),
(5, 'Teclado001', 'SN11111', 'Logitech K780', 'Teclado sem fio', '2023-05-15 15:30:00', 5),
(6, 'Mouse001', 'SN22222', 'Microsoft Wireless Mouse', 'Mouse óptico sem fio', '2023-06-20 11:45:00', 6),
(7, 'Projetor001', 'SN33333', 'BenQ HD Projector', 'Projetor de alta definição', '2023-07-01 09:00:00', 7),
(8, 'Telefone001', 'SN44444', 'Cisco VoIP Phone', 'Telefone VoIP para escritórios', '2023-08-10 14:30:00', 8),
(9, 'Servidor001', 'SN55555', 'HP ProLiant', 'Servidor empresarial', '2023-09-05 08:45:00', 9),
(10, 'Scanner001', 'SN66666', 'Epson Document Scanner', 'Scanner de documentos de alta velocidade', '2023-10-10 12:15:00', 10);

-- Inserindo 10 dados fictícios na tabela Usuarios
INSERT INTO Usuarios (id, nomeUsuario, cargo, informacoesContato) VALUES
(1, 'Admin1', 'Admin', 'admin1@email.com'),
(2, 'Usuario1', 'Usuario', 'usuario1@email.com'),
(3, 'Tecnico1', 'Tecnico', 'tecnico1@email.com'),
(4, 'Admin2', 'Admin', 'admin2@email.com'),
(5, 'Usuario2', 'Usuario', 'usuario2@email.com'),
(6, 'Tecnico2', 'Tecnico', 'tecnico2@email.com'),
(7, 'Admin3', 'Admin', 'admin3@email.com'),
(8, 'Usuario3', 'Usuario', 'usuario3@email.com'),
(9, 'Tecnico3', 'Tecnico', 'tecnico3@email.com'),
(10, 'Admin4', 'Admin', 'admin4@email.com');

-- Inserindo 10 dados fictícios na tabela Movimentacao
INSERT INTO Movimentacao (id, dataMovimentacao, localizacaoAnterior, localizacaoAtual, idAtivo, idUsuario) VALUES
(1, '2023-05-01 09:00:00', 'Sala 101', 'Sala 102', 1, 1),
(2, '2023-05-10 14:30:00', 'Sala 102', 'Sala 103', 1, 2),
(3, '2023-05-15 08:45:00', 'Sala 103', 'Sala 101', 1, 3),
(4, '2023-06-01 10:30:00', 'Escritório A', 'Sala de Reunião 1', 2, 4),
(5, '2023-06-10 15:15:00', 'Sala de Reunião 1', 'Sala de Reunião 2', 2, 5),
(6, '2023-06-15 11:30:00', 'Sala de Reunião 2', 'Escritório B', 2, 6),
(7, '2023-07-01 09:30:00', 'Sala 201', 'Sala 202', 3, 7),
(8, '2023-07-10 14:00:00', 'Sala 202', 'Sala 203', 3, 8),
(9, '2023-07-15 08:00:00', 'Sala 203', 'Sala 201', 3, 9),
(10, '2023-08-01 11:45:00', 'Recepção', 'Sala 101', 4, 10);

-- Inserindo 10 dados fictícios na tabela Manutencao
INSERT INTO Manutencao (id, dataManutencao, descricaoManutencao, custosManutencao, idAtivo) VALUES
(1, '2023-05-20 11:00:00', 'Substituição do disco rígido', 120.50, 1),
(2, '2023-06-05 13:30:00', 'Limpeza e manutenção preventiva', 50.25, 2),
(3, '2023-07-10 09:15:00', 'Troca de toner', 30.00, 3),
(4, '2023-08-15 14:45:00', 'Atualização de firmware', 25.75, 4),
(5, '2023-09-01 10:30:00', 'Substituição de cabo de rede', 15.20, 5),
(6, '2023-10-05 08:00:00', 'Reparo de lente quebrada', 40.60, 6),
(7, '2023-11-10 12:30:00', 'Limpeza e ajuste de foco', 35.30, 7),
(8, '2023-12-15 13:45:00', 'Substituição de peça danificada', 60.75, 8),
(9, '2024-01-20 09:30:00', 'Manutenção preventiva', 75.40, 9),
(10, '2024-02-25 14:15:00', 'Reparo de sistema operacional', 55.90, 10);




