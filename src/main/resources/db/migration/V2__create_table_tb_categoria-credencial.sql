/**
 * Objetivo: 	Modelagem da tabela relacional que representa a Categoria da Credencial.
 * Data: 		18/06/2025
 * Demanda:		DEFENSIUMAPI20251806511455
 */
create table if not exists tb_categoria_credencial (
	code bigint not null auto_increment comment 'Identificador privado e único da tabela',
	code_public varchar(255) not null comment 'Identificador público e único da tabela',
	descricao varchar(255) not null comment 'Representa a descrição da uma determinada categoria de uma credencial',
	active boolean default true not null comment 'Indica se um determinado registro está ativo ou inativo no sistema',
	data_criacao datetime default current_timestamp not null comment 'Representa a Data de Criação do Registro',
	data_edicao datetime default current_timestamp null comment 'Representa a Data de Deleção do Registro',
	data_delecao datetime null comment 'Representa a Data de Edição do Registro',
	constraint pk_pessoa primary key (code)
)
engine=innodb
default charset=utf8mb4
collate=utf8mb4_0900_ai_ci
comment 'Representa uma categoria de uma credencial';