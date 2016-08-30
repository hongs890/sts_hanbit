=======create=======
create sequence seq increment by 1 start with 1000 nocycle;


create table member(
	id varchar2(20) primary key,
	pw varchar2(20),
	name varchar2(20),
	reg_date varchar2(20),
	ssn varchar2(10),	
	email varchar2(30),
	phone varchar2(15),
	profile_img varchar2(100)
);

create table subject(
	major varchar2(10),
	subjects varchar2(100),
	id varchar2(20)
);

create table grade(
	seq number constraint grade_pk primary key,
	grade varchar2(1),
	java number,
	sql number,
	html number,
	javascript number,
	id varchar2(20),
	constraint grade_member_fk foreign key (id)
	references member(id) on delete cascade
);

create table account(
	id varchar2(20) ,
	account_no number constraint bank_pk primary key,
	money number,
	constraint bank_member_fk foreign key (id)
	references member(id) on delete cascade
);




======= insert ========

insert into account(id, account_no, money) values('hong', '123456', '5000');
insert into grade(seq, grade, java, sql, html, javascript, id) values(seq.nextval,'A','50','50','50','50','hong');
insert into subject(subj_seq, major, subjects, id) values(1000, 'test', 'test','hong');
insert into member(id,pw,name,reg_date,ssn,email,phone,profile_img)
values('lee','1','이순신','2016-07-01','800101-1','lee@test.com','010-7143-0222','lee.jpg');
insert into member(id,pw,name,reg_date,ssn,email,phone,profile_img)
values('hong','1','홍길동','2015-07-01','100701-1','hong@test.com','010-7143-0222','hong.jpg');
insert into member(id,pw,name,reg_date,ssn,email,phone,profile_img)
values('you','1','유관순','2014-07-01','010701-4','you@test.com','010-7143-0222','you.jpg');


drop table member;
drop table grade;
drop table subject;
drop table account;


====== select ========

select * from member;
select * from grade;
select * from account;
select * from subject;
select * from tab;
