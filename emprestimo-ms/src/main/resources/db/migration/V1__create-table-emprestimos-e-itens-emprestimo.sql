CREATE TABLE emprestimos (
    id SERIAL PRIMARY KEY,
    data_criacao DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    cliente_id BIGINT NOT NULL
);

CREATE TABLE itens_emprestimo (
    id SERIAL PRIMARY KEY,
    emprestimo_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INTEGER NOT NULL,
    preco_total NUMERIC(10, 2) NOT NULL,
    FOREIGN KEY (emprestimo_id) REFERENCES emprestimos(id)
);
