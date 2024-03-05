USE trembo_store;

CREATE TABLE IF NOT EXISTS cadastro(
ID smallint AUTO_INCREMENT PRIMARY KEY,
Nome varchar(48) NOT NULL,
Email varchar(48) NOT NULL,
Senha varchar(48) NOT NULL,
Grupo varchar (48) NOT NULL
);

show tables;