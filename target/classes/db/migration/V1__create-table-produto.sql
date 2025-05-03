create table produtos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    categoria varchar(100) not null ,
    descricao varchar(200) not null,
    preco double not null,
    link_imagem varchar(100),
    ativo tinyint,

    primary key(id)

);