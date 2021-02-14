create table buildings
(
    id          serial not null
        constraint buildings_pkey
            primary key,
    geolocation varchar(255),
    name        varchar(255)
);

alter table buildings owner to rhlbmescnferpw;

create table producers
(
    id           serial not null
        constraint producers_pkey
            primary key,
    country      varchar(255),
    name         varchar(255),
    phone_number varchar(255)
);

alter table producers owner to rhlbmescnferpw;

create table products
(
    id          serial not null
        constraint products_pkey
            primary key,
    name        varchar(255),
    price       serial not null,
    quantity    serial not null,
    weight      serial not null,
    building_id serial
        constraint fk8bi1tvra8wxv383qpbxa30oox
            references buildings,
    producer_id serial
        constraint fkponvuhms7f447e47sn69rs5gf
            references producers
);

alter table products owner to rhlbmescnferpw;

create table ledgers
(
    id          serial not null
        constraint ledgers_pkey
            primary key,
    bookkeeping varchar(255),
    price       serial not null,
    quantity    serial not null,
    good_id     serial
        constraint fk2ac4dj6bc3tufqut0vw061wk5
            references products
);

alter table ledgers owner to rhlbmescnferpw;

create table sellers
(
    id          serial      not null
        constraint sellers_pkey
            primary key,
    name        varchar(35) not null,
    patronymic  varchar(35) not null,
    surname     varchar(35) not null,
    time_type   varchar(255),
    building_id serial
        constraint fknme4u425l0ilr4vmvokmevtam
            references buildings
);

alter table sellers owner to rhlbmescnferpw;

