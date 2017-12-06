#mySql 数据库
#books begin

create table test.books(
  book_id int  primary key auto_increment,
  book_name varchar(30) not null,
  book_price double(16,2) not null,
  book_write varchar(30) not null
)

select * from books;
select * from books where book_id =9;


insert into books (book_name,book_price,book_write) values('夜天子',60.8,'月关');
insert into books (book_name,book_price,book_write) values('终级教师',50.8,'柳下挥');
commit;
insert into books (book_name,book_price,book_write) values('十国千娇',50.6,'西风紧');
commit;
insert into books (book_name,book_price,book_write) values('国士无双',60.8,'李潇');
commit;
insert into books (book_name,book_price,book_write) values('俗人回档',60.58,'锅包肉');
commit;

delete from books where book_id = 7;

#update books set book_name='俗人回档',book_price=60.5,book_write='庚不让' where book_id=9;
commit;



#books end