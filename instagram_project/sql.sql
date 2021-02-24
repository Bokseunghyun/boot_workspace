create table users(
id number(38) primary key not null,
username varchar2(50) not null,
name nvarchar2(15) not null,
password varchar2(100) not null,
website nvarchar2(100),
intro long,
phone varchar2(30),
email varchar2(100),
gender varchar2(10),
profile_Image varchar2(100),
reg_Date timestamp default sysdate,
update_Date timestamp default sysdate
)

create table Follow(
id number(38) primary key not null,
following number(38) not null,
follower number(38) not null,
reg_Date timestamp default sysdate,
update_Date timestamp default sysdate

)



drop table users;
drop table Follow;
drop table images;
drop table likes;
drop table tag;


select * from users;
select * from images;
select * from tag;
select * from follow;

insert into users(id,username,name,password) values(user_seq.nextval,'java123','자바','java123')

alter table users modify profile_Image varchar2(150);
alter table users rename column profileImage to profile_Image;
alter table users rename column regDate to reg_Date;
alter table users rename column updateDate to update_Date;
alter table images rename column user_Id to userId;

alter table images add column userId varchar2(25);


create sequence user_seq start with 1 increment by 1 maxvalue 100;

drop sequence user_seq;


