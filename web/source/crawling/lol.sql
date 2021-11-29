create table lol(
	deck varchar(20) not null,
	champ varchar(50) not null,
	gold varchar(10) not null
);

select * from lol;

insert into lol values('arcane lux', 'lux lulu', 'a'); 
DELETE FROM lol where BID = '2';

drop table lol;