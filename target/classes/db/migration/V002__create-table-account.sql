create table account (
	id bigint not null auto_increment,
	number varchar(100) not null,
	agency varchar(20) not null,
	balance varchar(60) not null,
    
    primary key (id),
    
    holder_id bigint not null,
    
    constraint fk_account_holder foreign key (holder_id) references holder (id)
);