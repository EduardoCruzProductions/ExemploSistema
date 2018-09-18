CREATE DATABASE aula30;
USE aula30;

CREATE TABLE pessoa(
  
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL

);

CREATE TABLE venda (

    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_venda DATE NOT NULL,
    total_venda DOUBLE NOT NULL,
    id_pessoa INTEGER NOT NULL,
    CONSTRAINT fk_venda_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)

);

CREATE TABLE produto (
    
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    quantidade_estoque INTEGER NOT NULL,
    preco DOUBLE NOT NULL

);

CREATE TABLE itens_venda(
    
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_produto INTEGER NOT NULL,
    id_venda INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    valor_unitario DOUBLE NOT NULL,
    valor_total DOUBLE NOT NULL,
    CONSTRAINT fk_itens_venda_produto FOREIGN KEY (id_produto) REFERENCES produto(id),
    CONSTRAINT fk_itens_venda_venda FOREIGN KEY (id_venda) REFERENCES venda(id)

);

CREATE TABLE usuario(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL
);

INSERT INTO usuario(nome,login,senha) values ('Administrador','admin','123');
