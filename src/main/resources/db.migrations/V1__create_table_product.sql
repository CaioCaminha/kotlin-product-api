create table product(
    id bigint not null,
    title varchar(100) not null,
    description varchar(250) not null,
    createdAt datetime not null,
    value bigint not null
);

insert into product values(1, "caneca", "caneca java", 11-11-2021, 200);