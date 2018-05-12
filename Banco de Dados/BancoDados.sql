/* CRIANDO DATABASE*/

CREATE DATABASE threeway
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
*TABELA DE LIVRO*/

/*LIVRO*/

CREATE TABLE livro(
	COD_LIVRO SERIAL NOT NULL PRIMARY KEY,
	TITULO VARCHAR(30) NOT NULL,
	AUTOR VARCHAR(20) NOT NULL,
	PRECO NUMERIC NOT NULL,
	IMAGEM VARCHAR(80) NOT NULL,
	DESCRICAO VARCHAR(80));
	
/* INSERT DE LIVROS*/

INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('GRANDE SERTAO - VEREDAS', 'ROSA, JOAO GUIMARAES', 100, 'C:\Users\Public\Pictures\Sample Pictures\DESERTO.JPEG');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES	('QUANDO NIETZCHE CHOROU', 'YALOM, IRVIN D.', 49.9, 'C:\Users\Public\Pictures\Sample Pictures\DESERTO.JPEG');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES	('CASSINO ROYALE - JAMESBOND 00', 'Fleming, Ian', 29.9, 'C:\Users\Public\Pictures\Sample Pictures\DESERTO.JPEG');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES	('FILOSOFIA DO TEDIO', 'SVENDSEN, LARS', 29.9, 'C:\Users\Public\Pictures\Sample Pictures\DESERTO.JPEG');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('O CASAMENTO', 'Rodrigues,Nelson', 39.9, 'imagens/casamento.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('NEVE', 'PAMUK, ORHAN', 54,'imagens/neve.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('VOLTA AO MUNDO EM OITENTA DIAS', 'VERNE, JULIO', 16.5, 'imagens/volta_mundo.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('CRISTOVAO COLOMBO','VERNE, JULIO', 16.5, 'imagens/cristovao_colombo.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('VINTE MIL LEGUAS SUBMARINAS', 'VERNE, JULIO', 14.9, 'imagens/submarinas.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('O SENHOR DOS ANEIS','TOLKIEN, J.R.R.', 169.9, 'imagens/senhor.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('HARRY POTTER', 'ROWLING,J.K.', 89.7, 'imagens/harry.png');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('A AVENTURAS DE PI','MARTEL, YANN', 23.5, 'imagens/lifeofpi.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('PARA ONDE ELA FOI?','FORMAN, GAYLE', 20.0, 'imagens/onde.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('O LIVRO DO CEMITERIO','GAILMAN, NEIL', 20.0, 'imagens/cemiterio.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('SANDMAN VOL 1', 'GAILMAN,NEIL', 489.0, 'imagens/sandman.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('WATCHMEN', 'MOORE, ALAN',37.4, 'imagens/watchmen.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('JUSTICEIRO NOIR', 'TIIER, FRANK', 12.5, 'imagens/justiceiro.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('SUPERMAN', 'TOMASI,PETER', 5.9, 'imagens/superman.jpg');
INSERT INTO LIVRO (TITULO, AUTOR, PRECO, IMAGEM) VALUES ('BATMAN', 'SNYDER, SCOTT',5.9, 'imagens/batman.jpeg');

/* FIM TABELA */

/* CRIA TABELA USUARIO*/

CREATE TABLE USUARIO (
	ID SERIAL PRIMARY KEY NOT NULL,
    	USERNAME VARCHAR(255) NOT NULL,
    	NOMEUSUARIO VARCHAR(255) NOT NULL,
    	EMAIL VARCHAR(255) NOT NULL,
	SENHA VARCHAR(255) NULL,
	TIPOUSUARIO VARCHAR(255) NOT NULL
    );

/*INSERI USUARIO ADMINISTRADOR*/

INSERT INTO USUARIO 
		(USERNAME, NOMEUSUARIO, EMAIL, SENHA, TIPOUSUARIO) 
 VALUES 
 		('admimistrador', 'administrador','rudimarcf@gmail.com', '123456','administrador');

 		INSERT INTO USUARIO 
		(USERNAME, NOMEUSUARIO, EMAIL, SENHA, TIPOUSUARIO) 
 VALUES 
 		('admin', 'Douglas','douglaslpolinto@gmail.com', '123456','administrador'); 		

/* FIM TABELA */
