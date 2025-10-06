-- É esperado que os scripts create_locadora_db.sql e insert_data_locadora_db.sql ja foram rodados na instancia/conexão atual

use locadora;

-- 1. Liste todos os clientes com nome, sobrenome e e-mail.
SELECT
    primeiro_nome,
    segundo_nome,
    email
FROM
    cliente;

-- 2. Mostre os filmes cadastrados, exibindo título, ano de lançamento e preço de locação.
SELECT
    titulo,
    ano_de_lancamento,
    preco_da_locacao
FROM
    filme;

-- 3. Liste os clientes em ordem alfabética pelo sobrenome.
SELECT
    primeiro_nome,
    segundo_nome,
    email
FROM
    cliente
ORDER BY
    segundo_nome;

-- 4. Conte quantos clientes cada loja possui.
SELECT
    l.id AS loja_id,
    COUNT(c.id) AS total_clientes
FROM
    loja l
JOIN
    cliente c ON l.id = c.loja_id
GROUP BY
    l.id;

-- 5. Liste os filmes com preço de locação maior que R$ 6,00.
SELECT
    titulo,
    preco_da_locacao
FROM
    filme
WHERE
    preco_da_locacao > 6.00
ORDER BY
    preco_da_locacao DESC;

-- 6. Mostre todos os aluguéis com nome do cliente e data.
SELECT
    c.primeiro_nome,
    c.segundo_nome,
    a.data_de_aluguel
FROM
    aluguel a
JOIN
    cliente c ON a.cliente_id = c.id
ORDER BY
    a.data_de_aluguel DESC;

-- 7. Exiba cliente, filme alugado e data do aluguel.
SELECT
    c.primeiro_nome AS cliente_nome,
    f.titulo AS filme_titulo,
    a.data_de_aluguel
FROM
    aluguel a
JOIN
    cliente c ON a.cliente_id = c.id
JOIN
    inventario i ON a.inventario_id = i.id
JOIN
    filme f ON i.filme_id = f.id
ORDER BY
    a.data_de_aluguel DESC;

-- 8. Calcule quanto cada cliente já gastou em locações.
SELECT
    c.primeiro_nome,
    c.segundo_nome,
    SUM(p.valor) AS total_gasto
FROM
    pagamento p
JOIN
    cliente c ON p.cliente_id = c.id
GROUP BY
    c.id
ORDER BY
    total_gasto DESC;

-- 9. Mostre os 5 filmes mais alugados.
SELECT
    f.titulo,
    COUNT(a.id) AS total_alugueis
FROM
    aluguel a
JOIN
    inventario i ON a.inventario_id = i.id
JOIN
    filme f ON i.filme_id = f.id
GROUP BY
    f.id, f.titulo
ORDER BY
    total_alugueis DESC
LIMIT 5;

-- 10. Calcule a receita total de cada loja.
SELECT
    l.id AS loja_id,
    SUM(p.valor) AS receita_total
FROM
    pagamento p
JOIN
    aluguel a ON p.aluguel_id = a.id
JOIN
    funcionario func ON a.funcionario_id = func.id
JOIN
    loja l ON func.loja_id = l.id
GROUP BY
    l.id
ORDER BY
    receita_total DESC;