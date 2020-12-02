create table shop
(
    id       bigint       not null auto_increment,
    img_link varchar(255) not null,
    link     varchar(255) not null,
    name     varchar(255) not null,
    primary key (id)
)
;
