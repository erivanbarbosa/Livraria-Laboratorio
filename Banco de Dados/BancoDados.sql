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
	ID SERIAL NOT NULL PRIMARY KEY,
	TITULO VARCHAR(30) NOT NULL,
	AUTOR VARCHAR(20) NOT NULL,
	PRECO NUMERIC NOT NULL,
	IMAGEM VARCHAR NOT NULL,
	DESCRICAO VARCHAR);
	
/* INSERT DE LIVROS*/

INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (13, 'PARA ONDE ELA FOI?', 'FORMAN, GAYLE', 20, 'imagens/onde.jpg', 'Meu primeiro impulso não é agarrá-la nem beijá-la. Eu só quero tocar sua bochecha, ainda corada pela apresentação desta noite. Eu quero atravessar o espaço que nos separa, medido em passos – não em milhas, não em continentes, não em anos –, e acariciar seu rosto com um dedo calejado.');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (14, 'O LIVRO DO CEMITERIO', 'GAILMAN, NEIL', 20, 'imagens/cemiterio.jpg', 'Enquanto seus pais e irmã são impiedosamente assassinados por um misterioso homem chamado Jack, um bebê consegue escapar de seu berço e se aventurar pelo mundo. Uma série de coincidências, aliada a uma grande dose de sorte, salva o pequeno de ter um destino tão trágico quanto o de sua família.');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (15, 'SANDMAN VOL 1', 'GAILMAN,NEIL', 489, 'imagens/sandman.jpg', 'A saga de Morfeus, o Mestre do Sonhar, continua. Quando Delirium – a mais jovem dos Perpétuos – decide partir em busca de Destruição – seu irmão há muito perdido –, cabe aos seus outros irmãos tentarem colocar juízo em sua cabeça. Mas essa nunca é uma tarefa muito fácil. E essa jornada pode desencad');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (5, 'O CASAMENTO', 'Rodrigues,Nelson', 39.9, 'imagens/casamento.jpg', 'A apenas um dia do casamento de Glorinha e Teófilo, o médico da noiva avisa ao pai dela que seu futuro genro foi flagrado em um incidente homossexual. Esse é o ponto de partida para Nelson Rodrigues desfilar sua genialidade irônica e o humor negro tão característicos de sua narrativa.');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (7, 'VOLTA AO MUNDO EM OITENTA DIAS', 'VERNE, JULIO', 16.5, 'imagens/volta_mundo.jpg', 'Phileas Fogg tinha uma vida regrada e solitária, mas com muito dinheiro. Devido a uma aposta com seus amigos, resolve dar a volta ao mundo em 80 dias, acompanhado apenas de seu fiel empregado. Nessa viagem, viverá diversas aventuras e conhecerá vários lugares do mundo. Será que Fogg conseguirá?');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (8, 'CRISTOVAO COLOMBO', 'VERNE, JULIO', 16.5, 'imagens/cristovao_colombo.jpg', 'Cristóvão Colombo é uma personalidade que tangencia a esfera da lenda. Sua pertinácia e audácia lhe conferem o traço de homem invulgar, o extraordinário acompanha seus feitos, a aventura e o maravilhoso caracterizam sua trajetória pelo Atlântico desconhecido. Esses traços alimentam a imaginação');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (9, 'VINTE MIL LEGUAS SUBMARINAS', 'VERNE, JULIO', 14.9, 'imagens/submarinas.jpg', 'Vinte Mil Léguas Submarinas é uma das obras literárias mais famosas do escritor Júlio Verne. Originalmente publicada em forma de uma série no periódico Magasin d''Éducation et de Récréation, de Março de 1869 a Junho de 1870, teve uma edição ilustrada ...');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (10, 'O SENHOR DOS ANEIS', 'TOLKIEN, J.R.R.', 169.9, 'imagens/senhor.jpg', 'É impossível transmitir ao novo leitor todas as qualidades e o alcance do livro. Alternadamente cômica, singela, épica, monstruosa e diabólica, a narrativa desenvolve-se em meio a inúmeras mudanças de cenários e de personagens, num mundo imaginário absolutamente convincente em seu detalhes.');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (11, 'HARRY POTTER', 'ROWLING,J.K.', 89.7, 'imagens/harry.png', 'A vida do menino Harry Potter não tem um pingo de magia. Ele vive com os tios e o primo, que não gostam nem um pouco dele. O quarto de Harry é, na verdade, um armário sob a escada, e ele nunca comemorou um aniversário sequer em onze anos. Até que, um dia, Harry recebe uma carta misteriosa...');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (12, 'A AVENTURAS DE PI', 'MARTEL, YANN', 23.5, 'imagens/lifeofpi.jpg', 'Um dos romances mais importantes do século, As aventuras de Pi é uma narrativa singular de Yann Martel que se tornou um grande best-seller. O livro narra a trajetória do jovem Pi Patel, um garoto cuja vida é revirada quando seu pai, dono de um zoológico na Índia, decide embarcar em um navio... ');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (16, 'WATCHMEN', 'MOORE, ALAN', 37.4, 'imagens/watchmen.jpg', 'Um de seus antigos colegas é assassinado, e o vigilante mascarado Rorschach decide investigar um plano para matar e desacreditar todos os super-heróis do passado e do presente. À medida que ele se reconecta com sua antiga legião de combate ao crime, um grupo desorganizado de super-heróis aposentados');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (17, 'JUSTICEIRO NOIR', 'TIIER, FRANK', 12.5, 'imagens/justiceiro.jpg', 'Nova York, 1935. Frank Castelione, um veterano da Primeira Guerra Mundial, defende, junto com o filho, Frankie, sua pequena loja contra o crime organizado liderado pelo gângster Dutch Schultz. No entanto, que esperança eles podem ter diante de assassinos como Barracuda e Retalho? ');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (18, 'SUPERMAN', 'TOMASI,PETER', 5.9, 'imagens/superman.jpg', 'Neste emocionante encadernado, Jeph Loeb, Tim Sale e Bjarne Hansen, unem-se para apresentar uma visão única e profunda sobre os primórdios do Superman. Acompanhando os primeiros passos do jovem Clark Kent, sua vida na pequena Smallville e a interação com seus pais adotivos, e a chegada à Metrópolis,');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (19, 'BATMAN', 'SNYDER, SCOTT', 5.9, 'imagens/batman.jpeg', 'Em 1986, Frank Miller e David Mazzucchelli produziram esta reinterpretação da origem do Batman - sobre quem ele é e como se tornou o que é. Esta edição inclui a história na íntegra, uma introdução pelo escritor Frank Miller e um posfácio ilustrado pelo artista David Mazzucchelli. Inclui também mais ');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (20, 'GRANDE SERTAO - VEREDAS', 'ROSA, JOAO GUIMARAES', 100, 'imagens/grande_sertao.jpg', 'Durante a primeira parte da obra, o narrador em primeira pessoa, Riobaldo, faz um relato de fatos diversos e aparentemente desconexos entre si, que versam sobre suas inquietações sobre a vida. Os temas giram em torno das clássicas questões filosóficas ocidentais, tais como a origem do homem...');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (21, 'QUANDO NIETZCHE CHOROU', 'YALOM, IRVIN D.', 49.9, 'imagens/nietzche_chorou.jpg', 'Josef Breuer, um dos pais da psicanálise, está prestes a se deparar com um grande desafio: tratar do filósofo Friedrich Nietzsche, atormentado por uma crise existencial e por uma depressão suicida. Mentor de Freud, Breuer, entretanto, também vive um momento de angústia, obcecado pelas fantasias...');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (22, 'CASSINO ROYALE - JAMESBOND 00', 'Fleming, Ian', 29.9, 'imagens/cassino_royale.jpg', 'Bond, James Bond, é um charmoso e sofisticado agente secreto. Em “Cassino Royale”, primeiro volume da série do agente 007, Bond assume a arriscada missão de derrotar Le Chiffre, um perigoso agente comunista, em um jogo de cartas que pode ser fatal. Antes de se tornar escritor, Ian Fleming trabalhou');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (23, 'FILOSOFIA DO TEDIO', 'SVENDSEN, LARS', 29.9, 'imagens/filosofia_tedio.jpg', 'Esse livro investiga uma das preocupações centrais de nossa era ao sondar a natureza do tédio, quando ele se origina, como nos aflige e por que, ao que parece, somos incapazes de superá-lo por qualquer ato de vontade. De forma leve e espirituosa, com citações abrangentes que abarcam nomes como Heide');
INSERT INTO public.livro (id, titulo, autor, preco, imagem, descricao) VALUES (6, 'NEVE', 'PAMUK, ORHAN', 54, 'imagens/neve.jpg', '''Neve'', que o autor Ohran Pamuk - o vencedor do Prêmio Nobel de Literatura de 2006 - define como ''seu primeiro e último romance político'', conta a história de Ka, poeta exilado na Alemanha, que viaja a uma pequena cidade turca sob o pretexto de investigar a onda de suicídios entre mulçumanos que ass');


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
 		('administrador', 'administrador','rudimarcf@gmail.com', '123456','ADMINISTRADOR');

/* FIM TABELA */
