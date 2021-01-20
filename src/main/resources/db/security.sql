create table authorities
(
    id        serial primary key,
    authority varchar(50) not null
);

create table users
(
    id           serial primary key,
    username     varchar(50),
    password     varchar(100),
    enabled      boolean default true,
    authority_id integer not null references authorities
);

insert into authorities (authority)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, authority_id)
values ('admin', '$2a$10$5CI1YuZ2r9c/479xw2YrrueQQcLYhG0Ct3vJey.Fr24QXQWaYCqwy',
        (select id from authorities where authority = 'ROLE_ADMIN'));
