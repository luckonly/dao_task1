CREATE SCHEMA netology;

create table if not exists netology.customers
(
    id           int primary key,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int check (age > 0),
    phone_number varchar(255)
    );

INSERT INTO netology.customers(id, name, surname, age, phone_number)
VALUES ('1', 'Alexey', 'Ivanov', '28', '375298876754');
INSERT INTO netology.customers(id, name, surname, age, phone_number)
VALUES ('2', 'Dmitry', 'Petrov', '25', '375295649374');

create table if not exists netology.orders
(
    id           int primary key,
    date         timestamp default now(),
    customer_id  int          not null,
    product_name varchar(255) not null,
    amount       int          not null,
    FOREIGN KEY (customer_id) REFERENCES netology.customers (id)
    );

INSERT INTO netology.orders(id, customer_id, product_name, amount)
VALUES ('1', '1', 'Samsung Galaxy S20', '1');
INSERT INTO netology.orders(id, customer_id, product_name, amount)
VALUES ('2','2', 'iPhone 12 PRO MAX', '1');
