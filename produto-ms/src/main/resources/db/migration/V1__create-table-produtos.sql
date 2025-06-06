CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    descricao VARCHAR(255) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    tamanho VARCHAR(20) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    departamento VARCHAR(20) NOT NULL
);