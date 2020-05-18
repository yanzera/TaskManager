CREATE DATABASE web_tarefas;

USE web_tarefas;

CREATE TABLE usuario (
	email VARCHAR(256) NOT NULL PRIMARY KEY,
    senha VARCHAR(16) NOT NULL,
    nome VARCHAR(126)
);

CREATE TABLE tarefas (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(256),
    descricao TEXT,
    fk_usuario_email VARCHAR(256) NOT NULL,
    FOREIGN KEY(fk_usuario_email) REFERENCES usuario(email)
);

INSERT INTO usuario (email, senha, nome) VALUES ("maria@gmail.com", "123456", "Maria");
INSERT INTO usuario (email, senha, nome) VALUES ("joao@gmail.com", "456789", "Jo�o");
INSERT INTO usuario (email, senha, nome) VALUES ("joaquim@gmail.com", "abc123", "Joaquim");
INSERT INTO usuario (email, senha, nome) VALUES ("jessica@gmail.com", "gatos123", "J�ssica");

INSERT INTO tarefas (id, titulo, descricao, fk_usuario_email) VALUES (null, "Praticar Java Web", "Praticar todo o conte�do visto em aula: JSP, Servlets, Padr�es de projeto e muito mais...", "maria@gmail.com");
INSERT INTO tarefas (id, titulo, descricao, fk_usuario_email) VALUES (null, "Instalar o Linux", "Para n�o sofrer com sistemas inst�veis, formatarei meu computador e instalarei uma distro do Linux! :)", "joao@gmail.com");
INSERT INTO tarefas (id, titulo, descricao, fk_usuario_email) VALUES (null, "Ler um artigo sobre JSP", "Procurar na Web, algum artigo que trate do assunto JSP", "joaquim@gmail.com");
INSERT INTO tarefas (id, titulo, descricao, fk_usuario_email) VALUES (null, "Semestre que vem n�o tem JAVA \o/", "Professor, obrigada pelo semestre, desculpa as brincadeiras!", "jessica@gmail.com");