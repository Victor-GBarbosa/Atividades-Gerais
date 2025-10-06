create database locadora;

use locadora;

create table ator(
	id tinyint(5) primary key auto_increment not null,
    primeiro_nome varchar(50) not null,
    ultimo_nome varchar(50) not null,
    ultima_atualizacao timestamp
);

create table idioma (
	id tinyint auto_increment primary key not null,
    nome varchar(50) not null,
    ultima_atualizacao timestamp
);

create table filme (
	id smallint(5) primary key auto_increment not null,
    titulo varchar(255) not null,
    descricao TEXT not null,
    ano_de_lancamento YEAR(4) not null,
    idioma_id tinyint(3) not null,
    foreign key (idioma_id) references idioma(id),
    idioma_original_id tinyint(3) not null,
    foreign key (idioma_original_id) references idioma(id),
    duracao_da_locacao tinyint(3) not null,
    preco_da_locacao decimal(4,2) not null,
    duracao_do_filme smallint(5) not null,
    custo_de_substituicao decimal(5,2) not null,
    clasificacao enum("livre","10","12","16","18") not null,
    recursos_especias set("dublagem","audio espacial","audio descricao","3d"),
    ultima_atualizacao timestamp not null
);

create table categoria (
	id tinyint(5) primary key auto_increment,
    nome varchar(25),
    ultima_atualizacao timestamp
);

create table filme_categoria (
	primary key (filme_id, categoria_id),

	filme_id smallint(5)  not null,
    foreign key (filme_id) references filme(id) ,
	categoria_id tinyint(5) not null,
    foreign key (categoria_id) references categoria(id),
    ultima_atualizacao timestamp
);

create table ator_filme (
	primary key (ator_id, filme_id),

	ator_id tinyint(5) not null,
    foreign key (ator_id) references ator(id),
    filme_id smallint(5) not null,
    foreign key (filme_id) references filme(id),
    ultima_atualizacao timestamp
);


create table pais(
id smallint(5) primary key auto_increment not null,
pais varchar(50) not null,
ultima_atualizacao timestamp
);

create table cidade (
id smallint(5) primary key auto_increment not null,
cidade varchar(50) not null,
pais_id smallint(5) not null,
foreign key (pais_id) references pais(id),
ultima_atualizacao timestamp not null
);

create table endereco (
id smallint(5) primary key auto_increment not null,
endereco varchar(50) not null,
endereco2 varchar(50),
bairro varchar(20) not null,
cidade_id smallint(5) not null,
foreign key (cidade_id) references cidade(id),
cep varchar(10) not null,
telefone varchar(20),
ultima_atualizacao timestamp not null
);

create table loja (
id tinyint(3) primary key auto_increment not null,
gerente_id tinyint(3) null,
endereco_id smallint(5) not  null,
foreign key (endereco_id) references endereco(id),
ultima_atualizacao timestamp not null
);

create table cliente (
id smallint(5) primary key auto_increment not null,
loja_id tinyint(3) not null,
foreign key (loja_id) references loja(id),
primeiro_nome varchar(45) not null, 
segundo_nome varchar(45) not null,
email varchar(50) not null,
endereco_id smallint(5) not null,
foreign key (endereco_id) references endereco(id),
ativo tinyint(1) not null,
data_criacao dateTime not null
);

create table funcionario (
id tinyint(3) primary key auto_increment,
primeiro_nome varchar(45) not null,
ultimo_nome varchar(45) not null,
foto blob,
email varchar(50) not null,
ativo tinyint(1) not null,
usuario varchar(16) not null,
senha varchar (40) not null,
ultima_atualizacao timestamp not null, 

loja_id tinyint(3),
foreign key (loja_id) references loja(id),
endereco_id smallint(45),
foreign key (endereco_id) references endereco(id)
);

create table inventario (
id mediumint(8) primary key auto_increment,
ultima_atualizacao timestamp not null,

filme_id smallint(5) not null,
foreign key (filme_id) references filme(id),
loja_id tinyint(3) not null,
foreign key (loja_id) references loja(id)
);

create table aluguel (
id int(11) primary key auto_increment,
data_de_aluguel datetime not null,
data_de_devolucao datetime not null,
ultima_atualizacao timestamp not null,

inventario_id mediumint(8) not null,
foreign key (inventario_id) references inventario(id),
cliente_id smallint(5) not null,
foreign key (cliente_id) references cliente(id),
funcionario_id tinyint(3) not null,
foreign key (funcionario_id) references funcionario(id)
);

create table pagamento (
id smallint(5) primary key auto_increment,
valor decimal(5,2) not null,
data_de_pagamento datetime not null,
ultima_atualizacao timestamp not null,

cliente_id smallint(5) not null,
foreign key (cliente_id) references cliente(id),
funcionario_id tinyint(3) not null,
foreign key (funcionario_id) references funcionario(id),
aluguel_id int(11) not null,
foreign key (aluguel_id) references aluguel(id)
);

-- drop database locadora;
