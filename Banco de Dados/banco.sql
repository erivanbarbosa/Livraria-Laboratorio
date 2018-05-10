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

/* FIM TABELA */



-- Table: public.cliente

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente
(
    cod_cliente integer NOT NULL DEFAULT nextval('cliente_cod_cliente_seq'::regclass),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    login character varying(10) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(10) COLLATE pg_catalog."default" NOT NULL,
    endereco character varying(32) COLLATE pg_catalog."default",
    cidade character varying(32) COLLATE pg_catalog."default",
    bairro character varying(32) COLLATE pg_catalog."default",
    estado character varying(32) COLLATE pg_catalog."default",
    cep character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT cliente_pkey PRIMARY KEY (cod_cliente)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cliente
    OWNER to postgres;

-- Table: public.item_pedido

-- DROP TABLE public.item_pedido;

CREATE TABLE public.item_pedido
(
    cod_item integer NOT NULL DEFAULT nextval('item_pedido_cod_item_seq'::regclass),
    quantidade integer NOT NULL,
    cod_livro bigint NOT NULL,
    cod_pedido bigint NOT NULL,
    CONSTRAINT item_pedido_pkey PRIMARY KEY (cod_item),
    CONSTRAINT item_pedido_cod_livro_fkey FOREIGN KEY (cod_livro)
        REFERENCES public.livro (cod_livro) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT item_pedido_cod_pedido_fkey FOREIGN KEY (cod_pedido)
        REFERENCES public.pedido (cod_pedido) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.item_pedido
    OWNER to postgres;

-- Table: public.livro

-- DROP TABLE public.livro;

CREATE TABLE public.livro
(
    cod_livro integer NOT NULL DEFAULT nextval('livro_cod_livro_seq'::regclass),
    titulo character varying(30) COLLATE pg_catalog."default" NOT NULL,
    autor character varying(20) COLLATE pg_catalog."default" NOT NULL,
    preco numeric NOT NULL,
    imagem character varying(80) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(80) COLLATE pg_catalog."default",
    CONSTRAINT livro_pkey PRIMARY KEY (cod_livro)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.livro
    OWNER to postgres;

-- Table: public.pedido

-- DROP TABLE public.pedido;

CREATE TABLE public.pedido
(
    cod_pedido integer NOT NULL DEFAULT nextval('pedido_cod_pedido_seq'::regclass),
    data_pedido date NOT NULL,
    status character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cod_cliente bigint,
    CONSTRAINT pedido_pkey PRIMARY KEY (cod_pedido),
    CONSTRAINT pedido_cod_cliente_fkey FOREIGN KEY (cod_cliente)
        REFERENCES public.cliente (cod_cliente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pedido
    OWNER to postgres;
