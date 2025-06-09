CREATE TABLE fornecedores (
    id SERIAL PRIMARY KEY,
    cnpj CHAR(14) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    cep CHAR(8) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    rua VARCHAR(50) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(60) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL ,
    pais VARCHAR(50) NOT NULL
);
