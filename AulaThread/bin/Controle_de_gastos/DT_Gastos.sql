CREATE DATABASE Contas
GO
USE Contas

CREATE TABLE usuarios(
nome VARCHAR(100) NOT NULL,
login VARCHAR(100) NOT NULL,
senha VARCHAR(100) NOT NULL,
PRIMARY KEY (nome)
)

INSERT usuarios VALUES
('Julia','jujuba@gmail.com','123456')

INSERT usuarios VALUES
('Monica','43245@gmail.com','123456'),
('Benedito','Benedito@gmail.com','123456')

select *from usuarios ORDER BY nome