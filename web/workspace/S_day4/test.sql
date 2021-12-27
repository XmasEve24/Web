select * from all_tables;

create table board_S(
	bid int primary key,
	title varchar(20),
	writer varchar(10),
	content varchar(50),
	bdate date default sysdate,
	cnt int default 0
);

select * from board_S;

drop table board_S;

create table member_S(
	mid varchar(10) primary key,
	password varchar(10),
	name varchar(10),
	role varchar(10)
);

insert into member_S values('ko','1234','¿Ã¡Ó','USER');


