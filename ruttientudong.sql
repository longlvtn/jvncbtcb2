create database ruttientudong;
use ruttientudong;
create table nguoidung(
id int AUTO_INCREMENT primary key,
HoTen varchar(100),
taikhoan varchar(100) unique,
matkhau varchar(100),
quyen varchar(10) default 'user',
soCMND varchar(10) unique,
sodu bigint
);
insert into nguoidung
values	(null,'Lê Văn Long','admin','admin','admin','12345678',null),
		(null,'Lvl','nd1','123456','user','123456789',10000000),
		(null,'Lê','nd2','123456','user','123456788',15000000),
		(null,'Văn','nd3','123456','user','123456787',20000000),
		(null,'Long','nd4','123456','user','123456786',30000000)
