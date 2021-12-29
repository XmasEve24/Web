create table admin(
    adminNum int primary key,
    adminName varchar(20) not null,
    adminId varchar(20) not null,
    adminPw varchar(20) not null,
    adminEmail varchar(30) not null
);
select * from admin;
insert into admin values('1','ko','admin','1234','pbi@naver.com');
insert into admin values('2','������','aaa','1234','pbi@naver.com');
create table member(
    memberNum int primary key ,
    memberName varchar(20) not null,
    memberID varchar(20) not null,
    memberPw varchar(20) not null,
    memberEmail varchar(30) not null
);
select * from member;
insert into member values('1','ko','eve','1234','pbi@naver.com');
create table portfolio(
	portNum int primary key, 
    adminNum  int foreign key,
    portTitle varchar(50) not null,
    portContent varchar(200),
    portTime DateTime,
    constraint admin_fk foreign key(adminNum) references admin(adminNum) on DELETE CASCADE 
);
select * from portfolio;

create table reply(
    replyNum int primary key,
    portNum int not null,
    replyContent varchar(50),
    memberNum int not null,
    memberName varchar(20) not null,
    replyTime DateTime
    constraint portfolio_fk foreign key(portNum) references portfolio(portNum) on DELETE CASCADE  
);
select * from reply;


create table contact (
    contactNum int primary key,
    contactType varchar(30) not null,
    portNum int not null,
    memberNum int not null,
    contactContent varchar(250) not null,
    memberEmail varchar(30) not null
);
select * from contact;