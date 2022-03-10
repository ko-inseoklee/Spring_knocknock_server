drop table if exists topic_of_day cascade
CREATE table topic_of_day (today int primary key,contents varchar(200) not null,likecnt int,title varchar(30))
