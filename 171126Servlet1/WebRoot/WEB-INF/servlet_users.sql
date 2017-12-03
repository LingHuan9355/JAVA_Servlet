#mySql 数据库
#users begin
create table test.users(
   user_id int primary key,
   user_name varchar(30) not null,
   user_pwd varchar(30) not null 
);
select * from users;

insert into Users values(1,'雷克斯','lks');
commit;
insert into Users values(2,'常青','changq');

insert into Users values(3,'唐战','tangz');

insert into Users values(4,'马克思','max');
commit;
# users end