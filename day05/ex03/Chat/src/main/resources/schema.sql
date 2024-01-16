drop table if exists public.user CASCADE;
drop table if exists chatroom CASCADE;
drop table if exists message CASCADE;

create table public.user (
    user_id serial primary key,
    login text unique not null,
    password text not null
);

create table chatroom (
    chatroom_id serial primary key,
    name text unique not null,
    owner integer references public.user(user_id)
);

create table message (
    message_id serial primary key,
    author integer references public.user(user_id) not null,
    room integer references chatroom(chatroom_id) not null,
    text text not null,
    date timestamp
);