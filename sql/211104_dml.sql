
--앞에서 생성한 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.
--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
--
SELECT * FROM phoneinfo_basic;

INSERT INTO phoneinfo_basic
VALUES(1, '이효은', '010-1111-1111', 'gydms0136@naver.com', '서울', sysdate);
INSERT INTO phoneinfo_basic
VALUES(2, '이앤지', '010-2222-2222', 'gydms0136@gmail.com', '경기', sysdate);
INSERT INTO phoneinfo_basic
VALUES(3, '이지앤', '010-3333-3333', 'gydms0136@han.net', '강원', sysdate);

DROP TABLE pb_b01;
CREATE TABLE pb_b01
AS
SELECT * FROM phoneinfo_basic
;
SELECT * FROM pb_b01;

UPDATE pb_b01
SET fr_name='이효진', fr_phonenumber='010-0000-0000', fr_email=null, fr_address='제주'
WHERE idx = 1;
SELECT * FROM pb_b01;

--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
--
SELECT * FROM phoneinfo_univ;

INSERT INTO phoneinfo_univ
VALUES(1, '전공1', 1, 1);
INSERT INTO phoneinfo_univ
VALUES(2, '전공2', 2, 2);
SELECT * FROM phoneinfo_univ;

UPDATE phoneinfo_univ
SET fr_u_year='3'
WHERE idx=1;
SELECT * FROM phoneinfo_univ;

DELETE FROM phoneinfo_univ WHERE idx=1;
SELECT * FROM phoneinfo_univ;

--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
SELECT * FROM phoneinfo_com;

INSERT INTO phoneinfo_com
VALUES(1, '삼성', 1);
INSERT INTO phoneinfo_com
VALUES(2, '현대', 2);
INSERT INTO phoneinfo_com
VALUES(3, '엘지', 3);
SELECT * FROM phoneinfo_com;

COMMIT;

UPDATE phoneinfo_com
SET fr_c_company = '기아'
WHERE idx=3;
SELECT * FROM phoneinfo_com;

ROLLBACK;
SELECT * FROM phoneinfo_com;

DELETE FROM phoneinfo_com WHERE idx=1;
SELECT * FROM phoneinfo_com;

COMMIT;