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
insert into board values(1, '작성자1','게시글내용1',0);
insert into board values(2, '작성자2','게시글내용2',0);
insert into board values(3, '작성자3','게시글내용3',0);
insert into board values(4, '작성자3','게시글내용3',0);
insert into board values(5, '작성자3','게시글내용3',0);
insert into board values(6, '작성자3','게시글내용3',0);
insert into board values(7, '작성자3','게시글내용3',0);
insert into board values(8, '작성자3','게시글내용3',0);
select * from board;
insert into reply values(1,1,'작성자1','댓글내용1');
insert into reply values(2,1,'작성자2','댓글내용2');
insert into reply values(3,3,'작성자3','댓글내용3');
insert into reply values(4,3,'작성자3','댓글내용4');
select * from reply;
drop table board;
select * from board order by bid desc; 
