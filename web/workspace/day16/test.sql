select * from all_tables;

create table member(
	mid varchar(20) primary key,
	mpw varchar(20) not null,
	mname varchar(15) not null
);

create table board(
	bid int primary key,
	mid varchar(20) not null,
	msg varchar(50) not null,
	favcnt int default 0
);

create table reply(
	rid int primary key,
	bid int not null,
	mid varchar(20) not null,
	rmsg varchar(30) not null,
	constraint board_fk foreign key(bid) references board(bid) on delete cascade
); 
select * from member;
insert into board values(1, '�ۼ���1','�Խñ۳���1',0);
insert into board values(2, '�ۼ���2','�Խñ۳���2',0);
insert into board values(3, '�ۼ���3','�Խñ۳���3',0);
insert into board values(4, '�ۼ���3','�Խñ۳���3',0);
insert into board values(5, '�ۼ���3','�Խñ۳���3',0);
insert into board values(6, '�ۼ���3','�Խñ۳���3',0);
insert into board values(7, '�ۼ���3','�Խñ۳���3',0);
insert into board values(8, '�ۼ���3','�Խñ۳���3',0);
select * from board;
insert into reply values(1,1,'�ۼ���1','��۳���1');
insert into reply values(2,1,'�ۼ���2','��۳���2');
insert into reply values(3,3,'�ۼ���3','��۳���3');
insert into reply values(4,3,'�ۼ���3','��۳���4');
select * from reply;
drop table board;
select * from board order by bid desc; 
