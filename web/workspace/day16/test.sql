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

insert into board values(1, '작성자','게시글내용',0)
select * from board;
insert into reply values(1,1,'작성자','댓글내용');
select * from reply;
drop table board;
delete from board where bid=1;