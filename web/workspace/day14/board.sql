select * from all_tables;


create table board(
	idx int primary key,
	uname varchar(20) not null,
	title varchar(30) not null,
	content varchar(100) not null
);

insert into BOARD values(1,'ī�̻�','����','ų��');
insert into BOARD values(2,'�����','����','�����');

select * from BOARD;