create table holder (
	id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(30) not null,
    
    account_holder_id bigint,
	account_number varchar(100) not null,
	account_agency varchar(20) not null,
	account_balance varchar(60) not null,
    
    primary key (id)
);