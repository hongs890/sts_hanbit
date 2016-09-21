===== CREATE & DROP =====
DROP SEQUENCE grade_seq;
DROP SEQUENCE art_seq;
DROP SEQUENCE subj_seq;
DROP SEQUENCE major_seq;
DROP SEQUENCE exam_seq;

SELECT * FROM member;

CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;


==========VIEW=======

CREATE OR REPLACE VIEW Major_View AS SELECT
	m.major_seq AS major_seq,
	m.title AS major_title,
	u.mem_id AS mem_id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS reg_date,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profile_img,
	u.role AS role,
	u.phone AS phone
FROM Major m, Member u WHERE m.major_seq = u.major_seq;

CREATE OR REPLACE VIEW Grade_View AS SELECT
	u.mem_id AS mem_id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS reg_date,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profile_img,
	u.role AS role,
	u.phone AS phone,
	g.grade_seq AS grade_seq,
	g.grade AS grade,
	g.term AS term,
	s.subj_seq AS subj_seq,
	s.subj_name AS subj_name,
	x.exam_seq AS exam_seq,
	x.score AS score
FROM Member u, Grade g, Subject s, Exam x WHERE u.mem_id = g.mem_id AND u.mem_id = s.mem_id AND u.mem_id = x.mem_id;

CREATE OR REPLACE VIEW Board_View AS SELECT 
	b.art_seq AS art_seq,
	b.category AS category,
	b.title AS title,
	b.reg_date AS board_reg_date,
	b.content AS content
	u.mem_id AS mem_id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS mem_reg_date,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profile_img,
	u.role AS role,
	u.phone AS phone,
	
FROM Member u, Board b WHERE u.mem_id = b.mem_id;


======= insert ========
CREATE OR REPLACE PROCEDURE insertMajor(
	sp_major_seq IN Major.major_seq%TYPE,
	sp_title IN Major.title%TYPE
) AS BEGIN INSERT INTO Major(major_seq, title) VALUES(sp_major_seq, sp_title) END;


CREATE OR REPLACE PROCEDURE insertMember(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE,
	sp_major_seq IN Member.major_seq%TYPE
) AS BEGIN INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq) VALUES(sp_mem_id, sp_pw, sp_name, sp_gender, sp_reg_date, sp_ssn, sp_email, sp_profile_img, sp_role, sp_phone, sp_major_seq) END;

CREATE OR REPLACE PROCEDURE insertGrade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS BEGIN INSERT INTO Grade(grade_seq, grade, term, mem_id) VALUES(sp_grade_seq, sp_grade, sp_term, sp_mem_id) END;

CREATE OR REPLACE PROCEDURE insertBoard(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS BEGIN INSERT INTO Board(art_seq, category, title, reg_date, content, mem_id) VALUES(sp_art_seq, sp_category, sp_title, sp_reg_date, sp_content, sp_mem_id) END;

CREATE OR REPLACE PROCEDURE insertSubject(
	sp_subj_seq IN Subject.subj_seq%TYPE,
	sp_subj_name IN Subject.subj_name%TYPE,
	sp_mem_id IN Subject.mem_id%TYPE
) AS BEGIN INSERT INTO Subject(subj_seq, subj_name, mem_id) VALUES(sp_subj_seq, sp_subj_name, sp_mem_id) END;

CREATE OR REPLACE PROCEDURE insertExam(
	sp_exam_seq IN Exam.exam_seq%TYPE,
	sp_term IN Exam.sp_term%TYPE,
	sp_score IN Exam.sp_score%TYPE,
	sp_subj_seq IN Exam.sp_subj_seq%TYPE,
	sp_mem_id IN Exam.mem_id%TYPE
)AS BEGIN INSERT INTO Exam(exam_seq, term, score, subj_seq, mem_id) VALUES(sp_exam_seq, sp_term, sp_score, sp_subj_seq, sp_mem_id) END;

exec insertMajor (1,'컴퓨터공학'); end;
EXEC insertMember('lee','1','이순신','MALE','2016-07-01','800101-1','lee@test.com','lee.jpg','STUDENT','010-7143-0222','0');


====== select ======
SELECT * FROM tab;
SELECT SEQUENCE_OWNER, SEQUENCE_NAME FROM DBA_SEQUENCES WHERE SEQUENCE_OWNER = 'JUNDEV';














============= HANBIT ==============
/*
===================== META _PROCEDURE ==================
*/
SELECT OBJECT_NAME FROM USER_PROCEDURES ORDER BY OBJECT_NAME ASC;
DROP PROCEDURE JUNDEV.INSERTMEMBER;
/*
===================== MAJOR =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 전공
=================================================
*/
-- TABLE CREATE ORDER #1
DROP TABLE Major CASCADE CONSTRAINT;
CREATE TABLE Major(
	major_seq INT CONSTRAINT major_seq PRIMARY KEY,
	title VARCHAR2(20) NOT NULL UNIQUE
);

--SP_INSERT_MAJOR
CREATE OR REPLACE PROCEDURE insert_major(sp_title IN Major.title%TYPE)AS
BEGIN 
    INSERT INTO Major(major_seq,title) VALUES(major_seq.NEXTVAL,sp_title); 
END insert_major;
--EXE_INSERT_MAJOR
EXEC JUNDEV.INSERT_MAJOR('컴퓨터공학');
--SP_COUNT_MAJOR
CREATE OR REPLACE PROCEDURE count_student(sp_count OUT NUMBER) AS
    BEGIN SELECT COUNT(*) into sp_count FROM Member; 
END count_student;
--EXE_COUNT_MAJOR
DECLARE sp_count NUMBER;BEGIN count_student(sp_count);DBMS_OUTPUT.put_line ('학생수:'||sp_count);END;
--SP_FIND_BY_MAJOR_SEQ
CREATE OR REPLACE PROCEDURE find_by_major_seq(
   sp_major_seq IN OUT Major.major_seq%TYPE,
   sp_title OUT Major.title%TYPE,
   sp_result OUT VARCHAR2
   )AS sp_temp_count NUMBER; BEGIN SELECT COUNT (*) INTO sp_temp_count FROM Major WHERE major_seq = sp_major_seq;
   IF (sp_temp_count >0) THEN SELECT major_seq,title INTO sp_major_seq,sp_title FROM Major WHERE major_seq = sp_major_seq;
   sp_result :='과목번호 :' || sp_major_seq || '과목명 :' || sp_title; ELSE sp_result :='전공 과목이 없습니다'; END IF; END find_by_major_seq;        
--EXE_FIND_BY_MAJOR_SEQ
DECLARE sp_major_seq NUMBER := 1002; sp_result VARCHAR2(100); sp_title VARCHAR2(100); 
BEGIN find_by_major_seq(sp_major_seq,sp_title, sp_result); DBMS_OUTPUT.put_line (sp_result); END;
/*
===================== MEMBER_PROF =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 교수
=================================================
*/
-- TABLE CREATE ORDER #2
DROP TABLE Member CASCADE CONSTRAINT;
CREATE TABLE Member(
	mem_id VARCHAR2(20) CONSTRAINT member_pk PRIMARY KEY,
	pw VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	gender VARCHAR2(20) NOT NULL,
	reg_date VARCHAR2(20) NOT NULL,
	ssn VARCHAR2(10) NOT NULL UNIQUE,
	email VARCHAR2(30),
	profile_img VARCHAR2(100) DEFAULT 'default.jpg',
	role VARCHAR2(10) DEFAULT 'STUDENT',
	phone VARCHAR2(13) NOT NULL UNIQUE,
	major_seq INT,
	CONSTRAINT gender_ck CHECK (gender in ('MALE','FEMALE')),
	CONSTRAINT major_member_fk FOREIGN KEY (major_seq) REFERENCES Major(major_seq) ON DELETE CASCADE
);
--SP_INSERT_PROF
CREATE OR REPLACE PROCEDURE insert_prof(
   sp_mem_id IN Member.mem_id%TYPE,
   sp_pw IN member.pw%TYPE,
   sp_name IN Member.name%TYPE,
   sp_gender IN Member.gender%TYPE,
   sp_reg_date IN Member.reg_date%TYPE,
   sp_ssn IN Member.ssn%TYPE,
   sp_email IN Member.email%TYPE,
   sp_profile_img IN Member.profile_img%TYPE,
   sp_role IN Member.role%TYPE,
   sp_phone IN Member.phone%TYPE
) AS 
BEGIN
   INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone)
   VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone);
END insert_prof;
--EXE_INSERT_PROF
EXEC JUNDEV.INSERT_PROF('profx','1','찰스','MALE','2010-06-01','700101','profx@test.com','default.jpg','PROF','010-1234-5678');
/*
===================== MEMBER_STUDENT =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 학생
=================================================
*/
--SP_INSERT_STUDENT
CREATE OR REPLACE PROCEDURE insert_student(
   sp_mem_id IN Member.mem_id%TYPE,
   sp_pw IN Member.pw%TYPE,
   sp_name IN Member.name%TYPE,
   sp_gender IN Member.gender%TYPE,
   sp_reg_date IN Member.reg_date%TYPE,
   sp_ssn IN Member.ssn%TYPE,
   sp_email IN Member.email%TYPE,
   sp_profile_img IN Member.profile_img%TYPE,
   sp_role IN Member.role%TYPE,
   sp_phone IN Member.phone%TYPE,
   sp_major_seq IN Member.major_seq%TYPE
) AS BEGIN INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq) VALUES(sp_mem_id, sp_pw, sp_name, sp_gender, sp_reg_date, sp_ssn, sp_email, sp_profile_img, sp_role, sp_phone, sp_major_seq); END insert_student;
COMMIT;
-- EXE_INSERT_STUDENT
EXEC JUNDEV.INSERT_STUDENT('hong','1','홍길동','MALE','2016-06-01','800101','hong@test.com','default.jpg','STUDENT','010-1234-5678','1000');
/*
===================== SUBJECT =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 과목
=================================================
*/
--SP_INSERT_SUBJECT
CREATE OR REPLACE PROCEDURE insert_subject(
   sp_subj_name IN Subject.subj_name%TYPE,
   sp_mem_id IN Subject.mem_id%TYPE
) AS BEGIN INSERT INTO Subject(subj_seq, subj_name, mem_id) VALUES(subj_seq.NEXTVAL, sp_subj_name, sp_mem_id); END insert_subject;
--EXE_INSERT_SUBJECT
EXEC JUNDEV.INSERT_SUBJECT('java','profx');
/*
===================== GRADE =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 성적
=================================================
*/
-- TABLE CREATE ORDER #3
DROP TABLE Grade CASCADE CONSTRAINT;
CREATE TABLE Grade(
	grade_seq INT CONSTRAINT grade_pk PRIMARY KEY,
	grade VARCHAR2(5) NOT NULL,
	term VARCHAR2(10) NOT NULL,
	mem_id VARCHAR2(20) NOT NULL,
	CONSTRAINT member_grade_fk FOREIGN KEY (mem_id)	REFERENCES Member(mem_id) ON DELETE CASCADE
);
--SP_INSERT_GRADE
CREATE OR REPLACE PROCEDURE insert_grade(
   sp_grade IN Grade.grade%TYPE,
   sp_term IN Grade.term%TYPE,
   sp_mem_id IN Grade.mem_id%TYPE
) AS BEGIN INSERT INTO Grade (grade_seq, grade, term, mem_id) VALUES(grade_seq.NEXTVAL, sp_grade, sp_term, sp_mem_id); END insert_grade;
COMMIT;
/*
===================== BOARD_QNA =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : QNA
=================================================
*/
-- TABLE CREATE ORDER #4
DROP TABLE Board CASCADE CONSTRAINT;
CREATE TABLE Board(
	art_seq INT CONSTRAINT board_pk PRIMARY KEY,
	category VARCHAR2(20) NOT NULL UNIQUE,
	title VARCHAR2(30) DEFAULT 'NO TITLE',
	reg_date VARCHAR2(20) NOT NULL,
	content VARCHAR2(100) DEFAULT 'NO CONTENT',
	mem_id VARCHAR2(20),
	CONSTRAINT member_board_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
--SP_INSERT_QNA
CREATE OR REPLACE PROCEDURE insert_qna(
   sp_art_seq IN Board.art_seq%TYPE,
   sp_category IN Board.category%TYPE,
   sp_title IN Board.title%TYPE,
   sp_reg_date IN Board.reg_date%TYPE,
   sp_content IN Board.content%TYPE,
   sp_mem_id IN Board.mem_id%TYPE
) AS 
BEGIN
   INSERT INTO Board(art_seq,category,title,reg_date,content,mem_id)
   VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content,sp_mem_id);
END insert_qna;
COMMIT;
/*
===================== BOARD_NOTICE =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 공지사항
=================================================
*/
--SP_INSERT_NOTICE
CREATE OR REPLACE PROCEDURE insert_notice(
   sp_category IN Board.category%TYPE,
   sp_title IN Board.title%TYPE,
   sp_reg_date IN Board.reg_date%TYPE,
   sp_content IN Board.content%TYPE
) AS BEGIN INSERT INTO Board(art_seq, category, title, reg_date, content) VALUES(art_seq.NEXTVAL, sp_category, sp_title, sp_reg_date, sp_content); END insert_notice;
COMMIT;
/*
===================== EXAM =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-9
@ DESC : 시험
=================================================
*/
-- TABLE CREATE ORDER #5
DROP TABLE Subject CASCADE CONSTRAINT;
CREATE TABLE Subject(
	subj_seq INT CONSTRAINT subject_pk PRIMARY KEY,
	subj_name VARCHAR2(20) NOT NULL UNIQUE,
	mem_id VARCHAR2(20) NOT NULL,
	CONSTRAINT member_subject_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
-- TABLE CREATE ORDER #6
DROP TABLE Exam CASCADE CONSTRAINT;
CREATE TABLE Exam(
	exam_seq INT CONSTRAINT exam_seq PRIMARY KEY,
	term VARCHAR2(10) NOT NULL,
	score INT DEFAULT 0,
	subj_seq INT,
	mem_id VARCHAR2(20),
	CONSTRAINT subject_exam_fk FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
	CONSTRAINT member_exam_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
--SP_INSERT_EXAM
CREATE OR REPLACE PROCEDURE insert_exam(
   sp_term IN Exam.term%TYPE,
   sp_score IN Exam.score%TYPE,
   sp_subj_seq IN Exam.subj_seq%TYPE,
   sp_mem_id IN Exam.mem_id%TYPE
)AS BEGIN INSERT INTO Exam(exam_seq, term, score, subj_seq, mem_id) VALUES(exam_seq.NEXTVAL, sp_term, sp_score, sp_subj_seq, sp_mem_id); END insert_exam;
COMMIT;
--SP_COUNT_MAJOR
CREATE OR REPLACE PROCEDURE count_major(
    sp_count OUT NUMBER
) AS BEGIN SELECT COUNT(*) into sp_count FROM Major; END count_major;
--EXE_COUNT_MAJOR
DECLARE sp_count NUMBER;
BEGIN
count_major(sp_count);
DBMS_OUTPUT.put_line ('카운트:'||sp_count);
END;

--SP_ALL_MAJOR
CREATE OR REPLACE PROCEDURE JUNDEV.all_major(
    sp_result OUT CLOB
) AS
    sp_temp CLOB;
    sp_cnt NUMBER := 0;
BEGIN
    FOR major_rec IN (SELECT m.major_seq
                            ,m.title
                      FROM   major m
                      )
    LOOP
        sp_cnt := sp_cnt +1;
        IF sp_cnt =1 THEN
           sp_temp := major_rec.major_seq||','||major_rec.title;
        ELSE
           sp_temp := sp_temp || CHR(10) ||
                      major_rec.major_seq||','||major_rec.title;
        END IF;
    END LOOP;
    sp_result := sp_temp;
END all_major;
--EXE_ALL_MAJOR
DECLARE 
    sp_result CLOB;
    BEGIN
        all_major(sp_result);
        DBMS_OUTPUT.PUT_LINE(sp_result);
END;

--SP_FIND_STUDENT_BY_NAME
CREATE OR REPLACE PROCEDURE find_student(
    sp_mem_id IN OUT Member.mem_id%TYPE,
    sp_name OUT Member.name%TYPE,
    sp_result OUT VARCHAR2
)AS sp_temp_count NUMBER; BEGIN SELECT COUNT (*) INTO sp_temp_count FROM Member WHERE mem_id = sp_mem_id;
IF(sp_temp_count >0) THEN SELECT mem_id, name INTO sp_mem_id, sp_name FROM Member WHERE mem_id = sp_mem_id;
sp_result :='ID : ' || sp_mem_id || '/ NAME : ' || sp_name; ELSE sp_result :='일치하는 회원이 없습니다'; END IF; END find_student;
--EXE_FIND_STUDENT_BY_NAME
DECLARE sp_mem_id VARCHAR2(50) := 'hong'; sp_name VARCHAR2(50); sp_result VARCHAR2(100);
BEGIN find_student(sp_mem_id, sp_name, sp_result);
DBMS_OUTPUT.put_line (sp_result);
END;
--SP_UPDATE_MAJOR
CREATE OR REPLACE PROCEDURE update_major(
    sp_major_seq IN Major.major_seq%TYPE,
    sp_title IN Major.title%TYPE
)AS BEGIN UPDATE Major SET title = sp_title WHERE major_seq = sp_major_seq; END;

BEGIN update_major(1001,'경영학부');END;
--SP_DELETE_MAJOR
CREATE OR REPLACE PROCEDURE delete_major(
    sp_major_seq IN Major.major_seq%TYPE
)
AS BEGIN DELETE FROM Major WHERE major_seq = sp_major_seq; END delete_major;
BEGIN delete_major(1000); END delete_major;



select 
mem_id as id,
pw as pw,
name as name,
gender as gender,
reg_date as regDate,
email as email,
profile_img as profileImg,
role as role,
ssn as ssn,
phone as phone,
major_seq as major_seq
from member where mem_id = 'prof_james'