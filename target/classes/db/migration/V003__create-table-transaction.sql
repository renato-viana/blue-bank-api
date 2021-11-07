CREATE TABLE transaction
(
    id                 bigint        NOT NULL auto_increment,
    origin_account_id  BIGINT        NOT NULL,
    destination_account_id BIGINT        NOT NULL,
    transaction_value  VARCHAR(4000) NOT NULL,
    transaction_date   DATETIME      NOT NULL,

    PRIMARY KEY (ID),
    CONSTRAINT fk_origin_account FOREIGN KEY (origin_account_id) REFERENCES account (id),
    CONSTRAINT fk_destiny_account FOREIGN KEY (destination_account_id) REFERENCES account (id)
);