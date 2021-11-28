select * from all_tables;

create table board2(
	bid int primary key,
	writer varchar(20) not null,
	content varchar(50) not null
);

select * from board2;
insert into BOARD2 values('1','아니','머임');