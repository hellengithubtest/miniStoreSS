drop table if exists public.products;
create table products (id SERIAL, name varchar(25) not null, cost int not null);
