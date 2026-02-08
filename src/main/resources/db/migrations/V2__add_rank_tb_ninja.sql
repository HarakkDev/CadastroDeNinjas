-- V2: Migration para ADD column RANK na tabela tb_ninja

alter table tb_ninja
add column rank varchar(255);