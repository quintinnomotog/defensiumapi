/**
 * Objetivo: 	Carga Básica de Dados (Para teste)
 * Data: 		18/06/2025
 * Demanda:		DEFENSIUMAPI20251806511455
 */
insert into tb_pessoa (code_public, nome, data_criacao, data_edicao, active) values (
	'd93d1943-cb92-4dcb-b70c-7e4bb3978c8f',
	'Usuário do Sistema',
	now(),
	now(),
	true
);

insert into tb_categoria_credencial (code_public, descricao, data_criacao, data_edicao) values (
	'c93d1943-cb92-4dcb-b70c-7e4aa3978c3e',
	'Conta Corporativa',
	now(),
	now()
);