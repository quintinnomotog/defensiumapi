/**
 * Objetivo: 	Adicionar colunas de configuração para as Categorias de Credenciais
 * Data: 		26/06/2025
 * Demanda:		DEFENSIUMAPI20252606371311
 */
alter table tb_categoria_credencial add column cor_icone varchar (7) null;
alter table tb_categoria_credencial add column cor_fundo varchar (7) null;
alter table tb_categoria_credencial add column nome_icone varchar (20) null;