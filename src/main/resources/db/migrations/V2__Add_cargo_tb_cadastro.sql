-- V2: Migrations para adicionar a coluna de CARGO na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN cargo VARCHAR(255);