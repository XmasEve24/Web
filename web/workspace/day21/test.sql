create table bank1(
	bid int primary key,
	name varchar(10),
	balance int
);

create table bank2(
	bid int primary key,
	name varchar(10),
	balance int
);

insert into bank1 values(11,'Ƽ��',10000);
insert into bank2 values(21,'�Ƹ�',2000);

select * from bank1;
select * from bank2;