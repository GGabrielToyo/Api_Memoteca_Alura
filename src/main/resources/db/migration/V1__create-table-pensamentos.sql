create table pensamentos(
    id bigint not null auto_increment,
    conteudo varchar(1000) not null,
    autoria varchar(100) not null,
    modelo varchar(100) not null,
    favorito tinyint not null,

    primary key(id)
);