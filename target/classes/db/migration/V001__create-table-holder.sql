create table holder (
	id bigint not null auto_increment,
	cpf varchar(14) not null,
    name varchar(100) not null,
    email varchar(30) not null,
    creation_date datetime not null,
    
    primary key (id)
);