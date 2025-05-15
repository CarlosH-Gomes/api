create table products(

    id bigint not null auto_increment,
    name varchar(100) not null,
    category varchar(100) not null ,
    description varchar(200) not null,
    price double not null,
    link_imagem varchar(100),
    active tinyint,

    primary key(id)

);