-- drop table if exists clients ;
-- drop table if exists type_products cascade;
-- drop table if exists products cascade;


create table if not exists clients
(
    client_id    bigint generated by default as identity primary key,
    firstname    varchar(32) not null,
    middlename   varchar(32),
    lastname     varchar(32) not null,
    phone_number varchar(15) not null,
    constraint uq_phone_number unique (phone_number)
);

create table if not exists type_products
(
    type_product_id int generated by default as identity primary key,
    product_type    varchar(64) not null
);

create table if not exists products
(
    product_id      bigint generated by default as identity primary key,
    name_product    varchar(64)      not null,
    price_product   double precision not null,
    amount_product  bigint           not null,
    type_product_id int              not null,

    constraint fk_product_type foreign key (type_product_id) references type_products (type_product_id)
);




