select * from all_tables;

create table test(
	a int,
	b varchar(10)
);
insert into test values(10,'티모');
insert into test values(20,'아리');
insert into test values(30,'카이사');
insert into test values(40,'룰루');
insert into test values(50,'이즈리얼');
insert into test values(60,'루시안');
insert into test values(70,'요네');
insert into test values(80,'아칼리');
select * from test;
drop table test;