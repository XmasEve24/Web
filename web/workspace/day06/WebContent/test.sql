select * from all_tables;

create table test(
	a int,
	b varchar(10)
);
insert into test values(10,'Ƽ��');
insert into test values(20,'�Ƹ�');
insert into test values(30,'ī�̻�');
insert into test values(40,'���');
insert into test values(50,'�����');
insert into test values(60,'��þ�');
insert into test values(70,'���');
insert into test values(80,'��Į��');
select * from test;
drop table test;