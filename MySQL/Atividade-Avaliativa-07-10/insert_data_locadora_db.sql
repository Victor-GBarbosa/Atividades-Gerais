-- #################################################################
-- # DML: POPULAÇÃO DOS DADOS COM NOMES REALISTAS
-- #################################################################
USE locadora;

-- Desativa temporariamente as checagens de chaves estrangeiras para limpeza e reinserção
SET FOREIGN_KEY_CHECKS = 0;

-- Limpa as tabelas (assumindo que você está reexecutando o DML após o DDL)
TRUNCATE TABLE pagamento;
TRUNCATE TABLE aluguel;
TRUNCATE TABLE inventario;
TRUNCATE TABLE cliente;
TRUNCATE TABLE loja;
TRUNCATE TABLE funcionario;
TRUNCATE TABLE endereco;
TRUNCATE TABLE cidade;
TRUNCATE TABLE pais;
TRUNCATE TABLE ator_filme;
TRUNCATE TABLE filme_categoria;
TRUNCATE TABLE categoria;
TRUNCATE TABLE filme;
TRUNCATE TABLE idioma;
TRUNCATE TABLE ator;

SET FOREIGN_KEY_CHECKS = 1;


-- 1. População de Tabelas Auxiliares (PAIS, CIDADE, ENDERECO)
-- --------------------------------------------------------------------------------------
INSERT INTO pais (pais, ultima_atualizacao) VALUES
('Brasil', NOW()), ('EUA', NOW());

INSERT INTO cidade (cidade, pais_id, ultima_atualizacao) VALUES
('São Paulo', 1, NOW()), ('Rio de Janeiro', 1, NOW()), ('Nova York', 2, NOW());

-- ENDERECO (IDs 1-2 p/ Lojas, 3-4 p/ Funcionários-Gerentes)
INSERT INTO endereco (endereco, bairro, cidade_id, cep, telefone, ultima_atualizacao) VALUES
('Rua da Locadora, 100', 'Centro', 1, '01000-000', NULL, NOW()), -- 1: Loja 1
('Avenida Filmes, 200', 'Copacabana', 2, '22000-000', NULL, NOW()), -- 2: Loja 2
('Rua das Flores, 55', 'Bela Vista', 1, '01310-100', '11987654321', NOW()), -- 3: Func 1
('Av. Atlântica, 10', 'Tijuca', 2, '20510-000', '21998765432', NOW()); -- 4: Func 2

-- Inserção dos 25 endereços de clientes (IDs 5 a 29)
INSERT INTO endereco (endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao)
VALUES
('Rua Ficticia 1', NULL, 'Jardim', 1, '01001-001', '1133331111', NOW()),
('Av. Principal 2', 'Apto 201', 'Centro', 2, '22002-002', '2133332222', NOW()),
('Estrada Secundária 3', NULL, 'Rural', 3, '10003-003', '6133333333', NOW()),
('Praça da Arvore 4', 'Casa', 'Centro', 1, '01004-004', '1133334444', NOW()),
('Rua Ficticia 5', 'Bloco 1', 'Subúrbio', 2, '22005-005', '2133335555', NOW()),
('Av. Ficticia 6', NULL, 'Industrial', 3, '10006-006', '6133336666', NOW()),
('Rua do Teste 7', 'Sala 10', 'Comercial', 1, '01007-007', '1133337777', NOW()),
('Av. da Paz 8', NULL, 'Residencial', 2, '22008-008', '2133338888', NOW()),
('Rua do Sol 9', 'Cobertura', 'Praia', 3, '10009-009', '6133339999', NOW()),
('Estrada do Mar 10', NULL, 'Litoral', 1, '01010-010', '1144440000', NOW()),
('Rua X, 11', 'Apto 11', 'Vila', 2, '22011-011', '2144441111', NOW()),
('Av. Y, 12', NULL, 'Distrito', 3, '10012-012', '6144442222', NOW()),
('Rua Z, 13', 'Casa 13', 'Bairro Novo', 1, '01013-013', '1144443333', NOW()),
('Av. Alfa, 14', NULL, 'Bairro Antigo', 2, '22014-014', '2144444444', NOW()),
('Rua Beta, 15', '15A', 'Centro', 3, '10015-015', '6144445555', NOW()),
('Rua Gamma, 16', NULL, 'Jardim', 1, '01016-016', '1144446666', NOW()),
('Av. Delta, 17', 'Apto 170', 'Subúrbio', 2, '22017-017', '2144447777', NOW()),
('Rua Epsilon, 18', NULL, 'Rural', 3, '10018-018', '6144448888', NOW()),
('Av. Zeta, 19', 'Bloco C', 'Centro', 1, '01019-019', '1144449999', NOW()),
('Rua Eta, 20', NULL, 'Vila', 2, '22020-020', '2155550000', NOW()),
('Av. Theta, 21', 'Casa 21', 'Distrito', 3, '10021-021', '6155551111', NOW()),
('Rua Iota, 22', NULL, 'Bairro Novo', 1, '01022-022', '1155552222', NOW()),
('Av. Kappa, 23', 'Apto 23', 'Bairro Antigo', 2, '22023-023', '2155553333', NOW()),
('Rua Lambda, 24', NULL, 'Praia', 3, '10024-024', '6155554444', NOW()),
('Av. Mu, 25', '25B', 'Litoral', 1, '01025-025', '1155555555', NOW());


-- FUNCIONARIO (Nomes e Sobrenomes mais reais)
INSERT INTO funcionario (primeiro_nome, ultimo_nome, email, ativo, usuario, senha, ultima_atualizacao, loja_id, endereco_id) VALUES
( 'João', 'Gomes', 'joao.gomes@locadora.com', 1, 'jgomes', SHA1('senha123'), NOW(), NULL, 3), -- ID 1 (Gerente Loja 1)
( 'Isabela', 'Costa', 'isabela.costa@locadora.com', 1, 'icosta', SHA1('senha123'), NOW(), NULL, 4), -- ID 2 (Gerente Loja 2)
( 'Carlos', 'Drumond', 'carlos.drumond@locadora.com', 1, 'cdrumond', SHA1('senha123'), NOW(), NULL, 5), -- ID 3 (Funcionário comum)
( 'Lucia', 'Ramos', 'lucia.ramos@locadora.com', 1, 'lramos', SHA1('senha123'), NOW(), NULL, 6); -- ID 4 (Funcionário comum)

-- LOJA (Insere com gerente_id = NULL)
INSERT INTO loja (gerente_id, endereco_id, ultima_atualizacao) VALUES
( NULL, 1, NOW()), -- ID 1
( NULL, 2, NOW()); -- ID 2

-- ATUALIZA FUNCIONARIO e LOJA (Resolve a dependência circular)
UPDATE funcionario SET loja_id = 1 WHERE id IN (1, 3);
UPDATE funcionario SET loja_id = 2 WHERE id IN (2, 4);

UPDATE loja SET gerente_id = 1 WHERE id = 1;
UPDATE loja SET gerente_id = 2 WHERE id = 2;


-- 2. População de Dados do Catálogo (ATOR, IDIOMA, CATEGORIA, FILME)
-- Nomes de atores fictícios com bom mix
INSERT INTO ator (primeiro_nome, ultimo_nome, ultima_atualizacao) VALUES
('Ana', 'Souza', NOW()), ('Bruno', 'Mello', NOW()), ('Camila', 'Lopes', NOW()), ('Daniel', 'Freitas', NOW()), ('Elisa', 'Guerra', NOW()),
('Fábio', 'Nunes', NOW()), ('Giovanna', 'Pinto', NOW()), ('Hugo', 'Queiroz', NOW()), ('Iara', 'Ribeiro', NOW()), ('Jonas', 'Santos', NOW()),
('Karen', 'Teixeira', NOW()), ('Luiz', 'Vargas', NOW()), ('Marta', 'Xavier', NOW()), ('Nuno', 'Zimmermann', NOW()), ('Olivia', 'Almeida', NOW()),
('Paulo', 'Barros', NOW()), ('Quésia', 'Dutra', NOW()), ('Renato', 'Elias', NOW()), ('Sofia', 'Ferraz', NOW()), ('Tiago', 'Gomes', NOW()),
('Ursula', 'Holanda', NOW()), ('Victor', 'Igrejas', NOW()), ('Wanda', 'Jardim', NOW()), ('Yuri', 'Klein', NOW()), ('Zelda', 'Lima', NOW());

-- IDIOMA, CATEGORIA e FILME (Mantidos como no script anterior)
INSERT INTO idioma (nome, ultima_atualizacao) VALUES ('Português', NOW()), ('Inglês', NOW()), ('Espanhol', NOW());

INSERT INTO categoria (nome, ultima_atualizacao) VALUES
('Ação', NOW()), ('Comédia', NOW()), ('Drama', NOW()), ('Ficção Científica', NOW()), ('Terror', NOW()), 
('Documentário', NOW()), ('Infantil', NOW()), ('Romance', NOW()), ('Suspense', NOW()), ('Aventura', NOW());

INSERT INTO filme (titulo, descricao, ano_de_lancamento, idioma_id, idioma_original_id, duracao_da_locacao, preco_da_locacao, duracao_do_filme, custo_de_substituicao, clasificacao, recursos_especias, ultima_atualizacao) VALUES
( 'Viagem Fantástica', 'Uma jornada épica pelo universo.', 2005, 2, 2, 7, 4.99, 150, 25.00, 'livre', 'dublagem,audio espacial', NOW()), -- 1
( 'O Mistério da Chave', 'Um detetive investiga um caso complexo.', 2010, 2, 2, 3, 2.99, 120, 19.99, '12', 'audio descricao', NOW()), -- 2
( 'Risadas Ilimitadas', 'Uma comédia sobre amigos desastrados.', 2018, 1, 1, 5, 3.99, 90, 15.50, 'livre', 'dublagem', NOW()), -- 3
( 'A Última Fronteira', 'Drama de guerra emocionante e tenso.', 2014, 2, 2, 7, 4.99, 180, 29.99, '16', 'audio espacial', NOW()), -- 4
( 'Robôs em Guerra', 'Ficção científica com grandes batalhas.', 2021, 2, 2, 3, 5.99, 145, 35.00, '10', '3d', NOW()), -- 5
( 'A Casa Assombrada', 'Filme de terror com muitos sustos.', 2016, 1, 1, 5, 2.99, 100, 17.50, '18', 'audio descricao', NOW()), -- 6
( 'O Planeta Verde', 'Documentário sobre a vida selvagem.', 2019, 2, 2, 7, 1.99, 60, 10.00, 'livre', NULL, NOW()), -- 7
( 'A Princesa e o Dragão', 'Aventura infantil e mágica.', 2008, 1, 1, 3, 3.99, 85, 14.99, 'livre', 'dublagem', NOW()), -- 8
( 'Amor à Segunda Vista', 'Um romance emocionante e cheio de reviravoltas.', 2012, 2, 2, 5, 4.99, 110, 22.00, '10', 'audio espacial', NOW()), -- 9
( 'O Voo da Águia', 'Filme de suspense com espionagem.', 2017, 2, 2, 3, 4.99, 130, 27.50, '16', 'dublagem,audio descricao', NOW()), -- 10
( 'Corrida Mortal', 'Ação ininterrupta nas pistas.', 2015, 1, 1, 7, 5.99, 105, 30.00, '16', '3d', NOW()), -- 11
( 'O Sorriso Perdido', 'Comédia romântica leve.', 2020, 2, 2, 3, 2.99, 95, 16.99, 'livre', 'dublagem', NOW()), -- 12
( 'Lágrimas de Sangue', 'Drama intenso e comovente.', 2013, 2, 2, 5, 4.99, 160, 28.50, '18', 'audio espacial', NOW()), -- 13
( 'Ataque Galáctico', 'Ficção científica de alto orçamento.', 2006, 1, 1, 7, 5.99, 170, 39.99, '12', 'dublagem,3d', NOW()), -- 14
( 'A Maldição', 'Terror psicológico perturbador.', 2022, 2, 2, 3, 4.99, 115, 24.50, '18', 'audio descricao', NOW()), -- 15
( 'Maravilhas da Natureza', 'Documentário sobre o oceano.', 2011, 2, 2, 7, 1.99, 70, 9.99, 'livre', NULL, NOW()), -- 16
( 'O Tesouro Escondido', 'Aventura de caça ao tesouro.', 2019, 1, 1, 3, 3.99, 98, 18.00, 'livre', 'dublagem', NOW()), -- 17
( 'Para Sempre Você', 'Romance clássico e eterno.', 2016, 2, 2, 5, 4.99, 125, 23.00, '10', 'audio espacial', NOW()), -- 18
( 'O Jogo Final', 'Suspense de tirar o fôlego.', 2014, 2, 2, 3, 5.99, 135, 32.50, '16', 'dublagem', NOW()), -- 19
( 'Missão Impossível 10', 'Mais ação e explosões.', 2023, 2, 2, 7, 6.99, 140, 45.00, '12', '3d,audio espacial', NOW()), -- 20
( 'A Lenda do Ninja', 'Aventura de artes marciais.', 2007, 1, 1, 5, 3.99, 100, 20.00, '12', 'dublagem', NOW()), -- 21
( 'A Grande Fuga', 'Drama de prisão baseado em fatos reais.', 2018, 2, 2, 7, 4.99, 155, 31.00, '16', 'audio descricao', NOW()), -- 22
( 'Invasão de Zumbis', 'Terror e ação com mortos-vivos.', 2021, 2, 2, 3, 5.99, 112, 26.50, '18', '3d', NOW()), -- 23
( 'Mistérios do Tempo', 'Ficção científica sobre viagem no tempo.', 2010, 1, 1, 5, 4.99, 128, 24.00, '10', 'dublagem,audio espacial', NOW()), -- 24
( 'O Diário Secreto', 'Romance epistolar e melancólico.', 2017, 2, 2, 3, 3.99, 107, 19.50, 'livre', NULL, NOW()); -- 25

INSERT INTO filme_categoria (filme_id, categoria_id, ultima_atualizacao) VALUES
(1, 4, NOW()), (2, 9, NOW()), (3, 2, NOW()), (4, 3, NOW()), (5, 4, NOW()), (6, 5, NOW()),
(7, 6, NOW()), (8, 7, NOW()), (9, 8, NOW()), (10, 9, NOW()), (11, 1, NOW()), (12, 2, NOW()),
(13, 3, NOW()), (14, 4, NOW()), (15, 5, NOW()), (16, 6, NOW()), (17, 10, NOW()), (18, 8, NOW()),
(19, 9, NOW()), (20, 1, NOW()), (21, 10, NOW()), (22, 3, NOW()), (23, 5, NOW()), (24, 4, NOW()),
(25, 8, NOW()),
(1, 10, NOW()), (5, 1, NOW()), (11, 4, NOW()), (20, 9, NOW());

INSERT INTO ator_filme (ator_id, filme_id, ultima_atualizacao) VALUES
(1, 1, NOW()), (2, 1, NOW()), (3, 2, NOW()), (4, 3, NOW()), (5, 4, NOW()), (6, 5, NOW()),
(7, 6, NOW()), (8, 7, NOW()), (9, 8, NOW()), (10, 9, NOW()), (11, 10, NOW()), (12, 11, NOW()),
(13, 12, NOW()), (14, 13, NOW()), (15, 14, NOW()), (16, 15, NOW()), (17, 16, NOW()), (18, 17, NOW()),
(19, 18, NOW()), (20, 19, NOW()), (21, 20, NOW()), (22, 21, NOW()), (23, 22, NOW()), (24, 23, NOW()),
(25, 24, NOW()),
(1, 25, NOW()), (3, 1, NOW()), (5, 2, NOW()), (7, 3, NOW()), (9, 4, NOW());


-- 3. População de Clientes e Inventário

-- Clientes com Nomes Reais (25 Clientes - IDs 1 a 25. Usando endereços IDs 5 a 29)
INSERT INTO cliente (loja_id, primeiro_nome, segundo_nome, email, endereco_id, ativo, data_criacao) VALUES
(1, 'Adriana', 'Cunha', 'adriana.cunha@email.com', 5, 1, DATE_SUB(NOW(), INTERVAL 25 DAY)),
(2, 'Thiago', 'Lima', 'thiago.lima@email.com', 6, 1, DATE_SUB(NOW(), INTERVAL 24 DAY)),
(1, 'Patrícia', 'Farias', 'patricia.farias@email.com', 7, 1, DATE_SUB(NOW(), INTERVAL 23 DAY)),
(2, 'Ricardo', 'Alves', 'ricardo.alves@email.com', 8, 1, DATE_SUB(NOW(), INTERVAL 22 DAY)),
(1, 'Mariana', 'Vieira', 'mariana.vieira@email.com', 9, 1, DATE_SUB(NOW(), INTERVAL 21 DAY)),
(2, 'Marcelo', 'Ramos', 'marcelo.ramos@email.com', 10, 1, DATE_SUB(NOW(), INTERVAL 20 DAY)),
(1, 'Eliane', 'Rocha', 'eliane.rocha@email.com', 11, 1, DATE_SUB(NOW(), INTERVAL 19 DAY)),
(2, 'Fernando', 'Carvalho', 'fernando.carvalho@email.com', 12, 1, DATE_SUB(NOW(), INTERVAL 18 DAY)),
(1, 'Giovanna', 'Pires', 'giovanna.pires@email.com', 13, 1, DATE_SUB(NOW(), INTERVAL 17 DAY)),
(2, 'Henrique', 'Santos', 'henrique.santos@email.com', 14, 1, DATE_SUB(NOW(), INTERVAL 16 DAY)),
(1, 'Jéssica', 'Moraes', 'jessica.moraes@email.com', 15, 1, DATE_SUB(NOW(), INTERVAL 15 DAY)),
(2, 'Kleber', 'Azevedo', 'kleber.azevedo@email.com', 16, 1, DATE_SUB(NOW(), INTERVAL 14 DAY)),
(1, 'Laura', 'Guedes', 'laura.guedes@email.com', 17, 1, DATE_SUB(NOW(), INTERVAL 13 DAY)),
(2, 'Mauro', 'Duarte', 'mauro.duarte@email.com', 18, 1, DATE_SUB(NOW(), INTERVAL 12 DAY)),
(1, 'Natália', 'Lemos', 'natalia.lemos@email.com', 19, 1, DATE_SUB(NOW(), INTERVAL 11 DAY)),
(2, 'Otávio', 'Gomes', 'otavio.gomes@email.com', 20, 1, DATE_SUB(NOW(), INTERVAL 10 DAY)),
(1, 'Priscila', 'Sales', 'priscila.sales@email.com', 21, 1, DATE_SUB(NOW(), INTERVAL 9 DAY)),
(2, 'Rafael', 'Nogueira', 'rafael.nogueira@email.com', 22, 1, DATE_SUB(NOW(), INTERVAL 8 DAY)),
(1, 'Simone', 'Teixeira', 'simone.teixeira@email.com', 23, 1, DATE_SUB(NOW(), INTERVAL 7 DAY)),
(2, 'Victor', 'Sousa', 'victor.sousa@email.com', 24, 1, DATE_SUB(NOW(), INTERVAL 6 DAY)),
(1, 'Viviane', 'Zanetti', 'viviane.zanetti@email.com', 25, 1, DATE_SUB(NOW(), INTERVAL 5 DAY)),
(2, 'Wallace', 'Monteiro', 'wallace.monteiro@email.com', 26, 1, DATE_SUB(NOW(), INTERVAL 4 DAY)),
(1, 'Xênia', 'Barros', 'xenia.barros@email.com', 27, 1, DATE_SUB(NOW(), INTERVAL 3 DAY)),
(2, 'Yago', 'Cardoso', 'yago.cardoso@email.com', 28, 1, DATE_SUB(NOW(), INTERVAL 2 DAY)),
(1, 'Zuleica', 'Dias', 'zuleica.dias@email.com', 29, 1, DATE_SUB(NOW(), INTERVAL 1 DAY));

-- INVENTARIO (25 cópias, uma de cada filme, todas na Loja 1. IDs 1 a 25)
INSERT INTO inventario (filme_id, loja_id, ultima_atualizacao)
SELECT 
    T.n, 1, NOW()
FROM (
    SELECT 1 AS n UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL
    SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14 UNION ALL SELECT 15 UNION ALL SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19 UNION ALL SELECT 20 UNION ALL
    SELECT 21 UNION ALL SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL SELECT 25
) AS T;


-- 4. População de Aluguéis e Pagamentos (Mantendo o escalonamento)

-- ALUGUEL (25 Aluguéis - um para cada item de inventário)
INSERT INTO aluguel (data_de_aluguel, data_de_devolucao, inventario_id, cliente_id, funcionario_id, ultima_atualizacao)
SELECT
    DATE_SUB(NOW(), INTERVAL T.n * 2 DAY), 
    DATE_ADD(DATE_SUB(NOW(), INTERVAL T.n * 2 DAY), INTERVAL (T.n % 7 + 3) DAY), 
    T.n, -- Inventario ID 1 a 25
    T.n, -- Cliente ID 1 a 25
    CASE WHEN T.n % 2 = 1 THEN 1 ELSE 2 END, -- Funcionário ID 1 ou 2
    NOW()
FROM (
    SELECT 1 AS n UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL
    SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14 UNION ALL SELECT 15 UNION ALL SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19 UNION ALL SELECT 20 UNION ALL
    SELECT 21 UNION ALL SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL SELECT 25
) AS T;

-- PAGAMENTO (25 Pagamentos - um para cada aluguel)
INSERT INTO pagamento (valor, data_de_pagamento, cliente_id, funcionario_id, aluguel_id, ultima_atualizacao)
SELECT
    f.preco_da_locacao, 
    DATE_ADD(a.data_de_aluguel, INTERVAL 1 HOUR), 
    a.cliente_id,
    a.funcionario_id,
    a.id, 
    NOW()
FROM aluguel a
JOIN inventario i ON a.inventario_id = i.id
JOIN filme f ON i.filme_id = f.id
WHERE a.id BETWEEN 1 AND 25;