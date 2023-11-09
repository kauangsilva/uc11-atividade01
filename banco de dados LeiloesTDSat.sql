create database leiloesTDSat;
use leiloesTDSat;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    valor VARCHAR(30) NOT NULL,
    status VARCHAR(20) NOT NULL
);