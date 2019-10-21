
/*
###########################################
# START DATABASE Pessoa
###########################################
*/
CREATE DATABASE Pessoa VERSION '1' OPTIONS (ANNOTATION '', "connection-type" 'ANY', validationDateTime 'Thu Oct 17 16:37:43 BRT 2019', validationVersion '8.12.18');
USE DATABASE Pessoa VERSION '1';

--############ Translators ############
CREATE FOREIGN DATA WRAPPER mysql5;

CREATE FOREIGN DATA WRAPPER postgresql;


--############ Servers ############
CREATE SERVER JDVDB_MY FOREIGN DATA WRAPPER mysql5 OPTIONS ("resource-name" 'java:/JDVDB_MY_DS');

CREATE SERVER JDVDB_PG FOREIGN DATA WRAPPER postgresql OPTIONS ("resource-name" 'java:/JDVDB_PG_DS');


--############ Schemas ############
CREATE SCHEMA JDVDB_PG SERVER JDVDB_PG;

CREATE VIRTUAL SCHEMA PessoaCanonical OPTIONS (imports 'JDVDB_PG');

CREATE SCHEMA JDVDB_MY SERVER JDVDB_MY;


--############ Schema:JDVDB_PG ############
SET SCHEMA JDVDB_PG;



CREATE FOREIGN TABLE endereco (
	idendereco integer NOT NULL OPTIONS(NAMEINSOURCE '"idendereco"', NATIVE_TYPE 'int4', FIXED_LENGTH 'TRUE'),
	pessoa_idpessoa integer OPTIONS(NAMEINSOURCE '"pessoa_idpessoa"', NATIVE_TYPE 'int4', FIXED_LENGTH 'TRUE'),
	endereco string(100) OPTIONS(NAMEINSOURCE '"endereco"', NATIVE_TYPE 'varchar'),
	CONSTRAINT endereco_pkey PRIMARY KEY(idendereco) OPTIONS(NAMEINSOURCE '"endereco_pkey"')
) OPTIONS(NAMEINSOURCE '"public"."endereco"', UPDATABLE 'TRUE');



--############ Schema:PessoaCanonical ############
SET SCHEMA PessoaCanonical;



CREATE VIEW Pessoa (
	idPessoa integer NOT NULL OPTIONS(FIXED_LENGTH 'TRUE'),
	DataNascimento timestamp NOT NULL OPTIONS(FIXED_LENGTH 'TRUE'),
	Nome string(100) NOT NULL,
	Sexo integer NOT NULL OPTIONS(FIXED_LENGTH 'TRUE'),
	pessoa_idpessoa integer OPTIONS(FIXED_LENGTH 'TRUE'),
	idendereco integer NOT NULL OPTIONS(FIXED_LENGTH 'TRUE'),
	endereco string(100),
	CNH string(15) NOT NULL,
	idPessoa_1 integer NOT NULL OPTIONS(FIXED_LENGTH 'TRUE'),
	CPF string(11) NOT NULL,
	idDetalhePessoa integer NOT NULL OPTIONS(FIXED_LENGTH 'TRUE'),
	IFP string(15) NOT NULL
) 
AS
	SELECT
		JDVDB_MY.Pessoa.idPessoa, JDVDB_MY.Pessoa.DataNascimento, JDVDB_MY.Pessoa.Nome, JDVDB_MY.Pessoa.Sexo, JDVDB_PG.endereco.pessoa_idpessoa, JDVDB_PG.endereco.idendereco, JDVDB_PG.endereco.endereco, JDVDB_MY.DetalhePessoa.CNH, JDVDB_MY.DetalhePessoa.idPessoa AS idPessoa_1, JDVDB_MY.DetalhePessoa.CPF, JDVDB_MY.DetalhePessoa.idDetalhePessoa, JDVDB_MY.DetalhePessoa.IFP
	FROM
		JDVDB_MY.Pessoa, JDVDB_PG.endereco, JDVDB_MY.DetalhePessoa
	WHERE
		(JDVDB_MY.Pessoa.idPessoa = JDVDB_PG.endereco.pessoa_idpessoa) AND (JDVDB_MY.Pessoa.idPessoa = JDVDB_MY.DetalhePessoa.idPessoa);



--############ Schema:JDVDB_MY ############
SET SCHEMA JDVDB_MY;



CREATE FOREIGN TABLE DetalhePessoa (
	idDetalhePessoa integer NOT NULL OPTIONS(NAMEINSOURCE '`idDetalhePessoa`', NATIVE_TYPE 'INT', FIXED_LENGTH 'TRUE'),
	idPessoa integer NOT NULL OPTIONS(NAMEINSOURCE '`idPessoa`', NATIVE_TYPE 'INT', FIXED_LENGTH 'TRUE'),
	CPF string(11) NOT NULL OPTIONS(NAMEINSOURCE '`CPF`', NATIVE_TYPE 'VARCHAR'),
	IFP string(15) NOT NULL OPTIONS(NAMEINSOURCE '`IFP`', NATIVE_TYPE 'VARCHAR'),
	CNH string(15) NOT NULL OPTIONS(NAMEINSOURCE '`CNH`', NATIVE_TYPE 'VARCHAR'),
	CONSTRAINT "PRIMARY" PRIMARY KEY(idDetalhePessoa) OPTIONS(NAMEINSOURCE '`PRIMARY`'),
	CONSTRAINT fk_DetalhePessoa_Pessoa FOREIGN KEY(idPessoa) REFERENCES Pessoa(idPessoa) OPTIONS(NAMEINSOURCE '`fk_DetalhePessoa_Pessoa`')
) OPTIONS(NAMEINSOURCE '`jdvdb`.`DetalhePessoa`', UPDATABLE 'TRUE');

CREATE FOREIGN TABLE Pessoa (
	idPessoa integer NOT NULL OPTIONS(NAMEINSOURCE '`idPessoa`', NATIVE_TYPE 'INT', FIXED_LENGTH 'TRUE'),
	Nome string(100) NOT NULL OPTIONS(NAMEINSOURCE '`Nome`', NATIVE_TYPE 'VARCHAR'),
	DataNascimento timestamp NOT NULL OPTIONS(NAMEINSOURCE '`DataNascimento`', NATIVE_TYPE 'DATETIME', FIXED_LENGTH 'TRUE'),
	Sexo integer NOT NULL OPTIONS(NAMEINSOURCE '`Sexo`', NATIVE_TYPE 'INT', FIXED_LENGTH 'TRUE'),
	CONSTRAINT "PRIMARY" PRIMARY KEY(idPessoa) OPTIONS(NAMEINSOURCE '`PRIMARY`')
) OPTIONS(NAMEINSOURCE '`jdvdb`.`Pessoa`', UPDATABLE 'TRUE');



/*
###########################################
# END DATABASE Pessoa
###########################################
*/

