/**
 * Objetivo: 	Modelagem da tabela relacional que representa uma determinada Credencial.
 * Data: 		18/06/2025
 * Demanda:		DEFENSIUMAPI20251806511455
 */
create table if not exists tb_credencial (
	code bigint not null auto_increment comment 'Identificador privado e único da tabela',
	code_public varchar(255) not null comment 'Identificador público e único da tabela',
	descricao varchar(255) not null comment 'Representa a descrição da uma determinada categoria de uma credencial',
	id_categoria_credencial bigint not null comment 'Representa o relacionamento com a Categoria da Credencial',
	id_pessoa bigint not null comment 'Representa o relacionamento com a Pessoa do sistema',
	identificador varchar(100) not null comment 'Representa o identificador (cpf, cnpj, telefone ou email) da Credencial',
	senha varchar(60) null comment 'Representa o relacionamento com a Senha (chave) da Credencial',
	link varchar(255) null comment 'Representa o link de acesso (quando website)',
	observacao varchar(255) null comment 'Representa uma observação pertinente da Credencial',
	active boolean not null comment 'Indica se um determinado registro está ativo ou inativo no sistema',
	data_criacao datetime not null comment 'Representa a Data de Criação do Registro',
	data_delecao datetime null comment 'Representa a Data de Edição do Registro',
	data_edicao datetime null comment 'Representa a Data de Deleção do Registro',
	constraint pk_pessoa primary key (code),
	constraint fk_credencial_categoria_credencial foreign key (id_categoria_credencial) references tb_categoria_credencial (code),
	constraint fk_credencial_categoria_pessoa foreign key (id_pessoa) references tb_pessoa (code)
)
engine=innodb
default charset=utf8mb4
collate=utf8mb4_0900_ai_ci
comment 'Representa de uma Credencial';

/*
drop table if exists db_defensium.flyway_schema_history cascade;
drop table if exists db_defensium.tb_credencial cascade;
drop table if exists db_defensium.tb_categoria_credencial cascade;
drop table if exists db_defensium.tb_pessoa cascade;
*/