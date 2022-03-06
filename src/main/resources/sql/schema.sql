CREATE table topic_of_day (
    today int primary key,
    contents varchar(200) not null,
    likecnt int not null,
    title varchar(30) not null,
)