create table passkeeper.account
(
    id       serial  not null constraint account_pk primary key,
    username varchar(100)    not null,
    password varchar(100) not null
);

alter table passkeeper.account owner to postgres;

create unique index account_username_uindex on passkeeper.account (username);

create table passkeeper.pw_category
(
    id          serial not null constraint category_pk primary key,
    name        varchar(100) not null,
    description varchar(100) not null
);

alter table passkeeper.pw_category owner to postgres;

create table passkeeper.password
(
    id          serial not null constraint password_pk primary key
                constraint account_id   references passkeeper.account
                constraint category_id  references passkeeper.pw_category,
    input       varchar(1000),
    password    varchar(1000),
    description varchar(1000),
    "TimeStamp" timestamp not null
);

alter table passkeeper.password owner to postgres;

create table passkeeper.bank
(
    id           serial not null constraint bank_pk primary key
                 constraint account_id references passkeeper.account
                 constraint pwcategory_id references passkeeper.pw_category,
    account_number varchar(50)  not null,
    card_number    varchar(50)  not null,
    pw_withdraw    varchar(50),
    banking        varchar(50),
    pw_banking     varchar(50),
    card_type      varchar(100) not null,
    "TimeStamp"    timestamp    not null
);

alter table passkeeper.bank owner to postgres;

create unique index bank_account_number_uindex on passkeeper.bank (account_number);

create unique index bank_card_number_uindex on passkeeper.bank (card_number);

