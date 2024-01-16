drop table if exists public.user CASCADE;
drop table if exists chatroom CASCADE;
drop table if exists message CASCADE;

create table public.user (
    user_id serial primary key,
    login text,
    password text
);

create table chatroom (
    chatroom_id serial primary key,
    name text,
    owner bigint,
    constraint fk_chatroom_user foreign key (owner) references public.user(user_id)
);

create table message (
    message_id serial primary key,
    author bigint,
    room bigint,
    text text,
    date timestamp,
    constraint fk_message_user foreign key (author) references public.user(user_id),
    constraint fk_message_chatroom foreign key (room) references chatroom(chatroom_id)
);