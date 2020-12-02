create table product
(
    id            bigint       not null auto_increment,
    currency      varchar(255) not null,
    full_name     varchar(255),
    image_link    varchar(255) not null,
    name          varchar(255) not null,
    price         float        not null,
    shop_category varchar(255) not null,
    shop_id       bigint       not null,
    primary key (id)
)
;
