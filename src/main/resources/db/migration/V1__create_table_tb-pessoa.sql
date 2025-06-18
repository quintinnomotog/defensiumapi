/**
 * Objetivo: 	Modelagem da tabela relacional que representa uma pessoa do sistema.
 * Data: 		18/06/2025
 * Demanda:		DEFENSIUMAPI20251806511455
 */
create table if not exists tb_pessoa (
	code bigint not null auto_increment comment 'Identificador privado e único da tabela',
	code_public varchar(255) not null comment 'Identificador público e único da tabela',
	nome varchar(100) not null comment 'Representa o nome da uma determinada pessoa',
	active boolean default true not null comment 'Indica se um determinado registro está ativo ou inativo no sistema',
	data_criacao datetime default current_timestamp not null comment 'Representa a Data de Criação do Registro',
	data_edicao datetime default current_timestamp null comment 'Representa a Data de Deleção do Registro',
	data_delecao datetime null comment 'Representa a Data de Edição do Registro',
	constraint pk_pessoa primary key (code)
)
engine=innodb
default charset=utf8mb4
collate=utf8mb4_0900_ai_ci
comment 'Representa uma pessoa do sistema';