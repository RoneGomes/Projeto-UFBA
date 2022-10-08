CREATE TABLE  usuario (
matricula INTEGER PRIMARY KEY auto_increment,
nomeUsuario VARCHAR(50),
email varchar(50),
senha varchar(50),
pendencias varchar(50)
);

CREATE TABLE livro (
id integer PRIMARY KEY auto_increment,
nomeLivro VARCHAR(50),
autor VARCHAR(50),
statu VARCHAR(50),
editora VARCHAR(50)
 
);

CREATE TABLE emprestimo (
id integer PRIMARY KEY auto_increment,
nomeUsuario VARCHAR(50),
dataEmprestimo VARCHAR(50),
prazoEntrega VARCHAR(50),
nomeLivro VARCHAR(50)

)