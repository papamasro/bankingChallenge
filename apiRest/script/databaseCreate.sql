CREATE DATABASE testDB;

CREATE TABLE account
(
    account_id  SERIAL PRIMARY KEY,
    name    varchar(255),
    accountNumber   varchar(255),
    balance double precision
);


CREATE TABLE transaction
(
    transaction_id  SERIAL PRIMARY KEY,
    account_number    varchar(255),
    type    varchar(255),
    amount double precision,
    String   varchar(255)
);
