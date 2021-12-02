select * from all_tables;


create table board(
	idx int primary key,
	uname varchar(20) not null,
	title varchar(30) not null,
	content varchar(100) not null
);

insert into BOARD values(1,'카이사','제목','킬줘');
insert into BOARD values(2,'이즈리얼','나도','블루줘');

select * from BOARD;