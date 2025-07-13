/**
 * Objetivo: 	Refatoração na Modelagem de Dados e Carga Básica.
 * Data: 		29/06/2025
 * Demanda:		DEFENSIUMAPI20252906221755
 */
alter table tb_pessoa modify column nome varchar(100) not null comment 'Representa o nome de uma determinada pessoa ou instituição';
alter table tb_pessoa comment = 'Representa uma pessoa ou instituição gerenciada pelo sistema';

/* alter table tb_credencial add column id_bandeira_cartao_bancario char(100) null comment 'Código de Segurança do Cartão Bancário para CARTAO_BANCARIO'; */
alter table tb_credencial add column cartao_bancario_nome_titular 			char(100) 	null 		comment 'Nome do Titular do Cartão Bancário';
alter table tb_credencial add column cartao_bancario_numero_cartao 			char(16) 	null 		comment 'Número do Cartão Bancário';
alter table tb_credencial add column cartao_bancario_mes_vencimento 		char(2) 	null 		comment 'Mês do Vencimento do Cartão Bancário';
alter table tb_credencial add column cartao_bancario_ano_vencimento 		char(4) 	null 		comment 'Ano do Vencimento do Cartão Bancário';
alter table tb_credencial add column cartao_bancario_cvv 					char(3) 	null 		comment 'Código de Segurança do Cartão Bancário';
alter table tb_credencial add column cartao_bancario_senha_alfanumerica		char(50) 	null 		comment 'Senha Alfanumérica do Cartão Bancário';

alter table tb_credencial add column rede_nome varchar(60) null comment 'Nome da Rede para WI_FI';

alter table tb_credencial add column database_hostname varchar(60) null comment 'Host do Banco de Dados';
alter table tb_credencial add column database_porta varchar(5) null comment 'Porta do Banco de Dados';
alter table tb_credencial add column database_nome varchar(60) null comment 'Nome do Banco de Dados';
alter table tb_credencial add column database_usuario varchar(100) null comment 'Nome de Usuário do Banco de Dados';

alter table tb_credencial add column conta_bancaria_codigo_banco varchar(5) null comment 'Código do Banco para CONTA_BANCARIA';
alter table tb_credencial add column conta_bancaria_numero_agencia varchar(10) null comment 'Número da Agência para CONTA_BANCARIA';
alter table tb_credencial add column conta_bancaria_numero_conta varchar(20) null comment 'Número da Conta para CONTA_BANCARIA';
alter table tb_credencial add column conta_bancaria_tipo_conta varchar(20) null comment 'Tipo da Conta (corrente, poupança, investimento) para CONTA_BANCARIA';
alter table tb_credencial add column conta_bancaria_titular_conta varchar(100) null comment 'Titular da Conta para CONTA_BANCARIA';
alter table tb_credencial add column conta_bancaria_data_abertura datetime null default null comment 'Data de Abertura da Conta para CONTA_BANCARIA';
alter table tb_credencial add column conta_bancaria_status_conta varchar(20) null comment 'Status da Conta para CONTA_BANCARIA';

alter table tb_credencial add column operacao_bancaria_nome_operacao varchar(50) null comment 'Nome da Operação Bancária (TED, DOC, PIX) para OPERACAO_BANCARIA';

alter table tb_categoria_credencial add constraint un_categoria_credencial_code_public unique (code_public);

delete from tb_categoria_credencial where code_public = 'c93d1943-cb92-4dcb-b70c-7e4aa3978c3e';

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'c93d1943-cb92-4dcb-b70c-7e4aa3978c4z',
	'Credencial',
	now(),
	now(),
	'#ffffff',
	'#ff4081',
	'lock-closed-outline'
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'5fda040d-eb39-4d40-b3e1-f68e3151cb1a',
	'Cartão Bancário',
	now(),
	now(),
	'#ffffff',
	'#00c853',
	'card-outline'
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'1f9ea341-d71a-4f79-9fbb-cafd97b314ad',
	'Operação Bancária',
	now(),
	now(),
	'#ffffff',
	'#2962ff',
	'cash-outline'
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'c9562d53-73f1-4b88-b445-4f2e76750ea6',
	'Wi-Fi',
	now(),
	now(),
	'#ffffff',
	'#ff9100',
	'wifi-outline'
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'07596132-156e-432d-b62f-23709cf7b3ab',
	'Banco de Dados',
	now(),
	now(),
	'#ffffff',
	'#9c27b0',
	'server-outline'
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'aca00d5b-636c-4440-847a-d6596662e88d',
	'Chave SSH',
	now(),
	now(),
	'#ffffff',
	'#607d8b',
	'key-outline'
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao, cor_icone, cor_fundo, nome_icone) values (
	'b4cf732b-6e6d-41b4-938a-4d1f0b601f13',
	'Senha Simples', now(), now(), '#ffffff', '#4caf50', 
	'lock-closed-outline');
