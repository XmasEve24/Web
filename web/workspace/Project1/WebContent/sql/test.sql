select * from all_tables;

create table board(
	bid int primary key,
	writer varchar(20) not null,
	title varchar(30) not null,
	content varchar(50) not null
);

select * from board;
insert into board values(1,'�ۼ���','����','����');
insert into board values(2,'Ƽ��','ž�����?','��������');