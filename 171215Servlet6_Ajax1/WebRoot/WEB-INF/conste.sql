 create table conste(
    id int primary key auto_increment,
    name varchar(20) not null,
    content varchar(50) not null
)

insert into conste (name,content) values('水瓶座','水瓶座水瓶座');
insert into conste (name,content) values('双鱼座','双鱼座双鱼座');
insert into conste (name,content) values('白羊座','白羊座白羊座');
insert into conste (name,content) values('金牛座','金牛座金牛座');
insert into conste (name,content) values('双子座','双子座双子座');
insert into conste (name,content) values('巨蟹座','巨蟹座巨蟹座');
insert into conste (name,content) values('狮子座','狮子座狮子座');
insert into conste (name,content) values('处女座','处女座处女座');
insert into conste (name,content) values('天秤座','天秤座天秤座');
insert into conste (name,content) values('天蝎座','天蝎座天蝎座');
insert into conste (name,content) values('射手座','射手座射手座');
insert into conste (name,content) values('摩羯座','摩羯座摩羯座');

select id,name,content from conste

select * from conste where name='摩羯座'
select * from conste where id=2

update conste set content='摩羯座摩羯座' where name='摩羯座';