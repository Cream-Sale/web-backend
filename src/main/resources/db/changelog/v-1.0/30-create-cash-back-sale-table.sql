create table cash_back_sale
(
    id           bigint       not null auto_increment,
    description  varchar(255) not null,
    sale         float        not null,
    cash_back_id bigint       not null,
    shop_id      bigint       not null,
    primary key (id)
)
;

alter table cash_back_sale
    add constraint FK4d3xscq0ylps50c3nb310tg95 foreign key (cash_back_id) references cash_back (id)
;

alter table cash_back_sale
    add constraint FK59aa67ac1tehml95dknxi6uc7 foreign key (shop_id) references shop (id)
;
