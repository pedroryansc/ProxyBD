CREATE SCHEMA lojinha;

USE lojinha;

CREATE TABLE produto(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    descricao varchar(255) NOT NULL,
    preco decimal(10, 2) NOT NULL,
    PRIMARY KEY (id)
);