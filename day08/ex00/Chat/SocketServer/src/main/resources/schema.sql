drop schema if exists chat cascade;

create schema if not exists chat;

create table if not exists chat.users (
    id bigserial primary key,
    username text not null,
    password text not null
);

insert into chat.users (username, password)
values ('Isigrin', 'aboba'),
       ('Ppettigr', '1234'),
       ('Papafwen', 'iloveisigrin');