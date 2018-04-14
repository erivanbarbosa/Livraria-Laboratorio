-- Database: threeway

-- DROP DATABASE threeway;

CREATE DATABASE threeway
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    

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