create sequence hibernate_sequence start 1 increment 1;
create table person
(
    id           int8 not null,
    department   varchar(255) not null,
    filename     varchar(255),
    second_name  varchar(255) not null,
    phone_number varchar(255),
    first_name   varchar(255) not null,
    third_name   varchar(255) not null,
    position     varchar(255) not null,
    location     varchar(255),
    user_id      int8,
    primary key (id)
);
create table user_role
(
    user_id int8,
    roles   varchar(255)
);
create table usr
(
    id       int8,
    active   boolean not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);
alter table if exists person
    add constraint person_user_fk
        foreign key (user_id) references usr;
alter table if exists user_role
    add constraint user_role_user_fk
        foreign key (user_id) references usr;