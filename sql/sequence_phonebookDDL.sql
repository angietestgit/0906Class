-- phonebook DDL 생성하기
-- 제시된 테이블 정의서를 보고 DDL을 완성해봅시다.

CREATE TABLE phoneInfo_basic (
    idx number(6) constraint pi_basic_idx_PK primary key,
    fr_name VARCHAR2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20) ,
    fr_address varchar2(20),
    fr_regdate date default sysdate
);




create table phoneinfo_univ (
    idx number(6),
    fr_u_major VARCHAR2(20) default 'N' not null,
    fr_u_year number(1) default 1  not null, --check (fr_u_year between 1 and 4),
    fr_ref number(6) not null,
    constraint pi_univ_idx_PK primary key (idx),
    constraint chk check (fr_u_year between 1 and 4), -- 테이블 레벨에서 check  제약 설정 
    constraint pi_univ_ref_FK FOREIGN KEY (fr_ref) REFERENCES phoneInfo_basic (idx)
);


create table phoneinfo_com (
    idx number(6) constraint pi_com_idx_PK primary key,
    fr_c_company VARCHAR2(20) default 'N' not null,
    fr_ref number(6) not null constraint pi_com_ref_FK REFERENCES phoneinfo_basic (idx)
);

DELETE FROM phoneinfo_basic;
DELETE FROM phoneinfo_univ;
DELETE FROM phoneinfo_com;
------------------------------

-- Phoneinfo_basic 테이블 pk -> idx 에 입력할 일련번호
-- 시퀀스 생성
CREATE sequence pib_idx_seq
START WITH 1
MINVALUE 1
INCREMENT BY 1
MAXVALUE 999999
;

DROP TABLE phoneinfo_univ;
DROP TABLE phoneinfo_com;
DROP TABLE phoneinfo_basic;





--insert : CREATE
DESC phoneinfo_basic;

INSERT INTO phoneinfo_basic --()
    -- idx가 1번인지 2번인지 고민할 필요 없음 pib_idx_seq.nextval
    VALUES (pib_idx_seq.nextval, '손흥민', '010-0000-0000', 'song@gmail.com', 'LONDON', sysdate);
INSERT INTO phoneinfo_basic --()
    VALUES (pib_idx_seq.nextval, '이강인', '010-9999-9999', 'lee@gmail.com', 'LONDON', sysdate);

--select
SELECT * FROM phoneinfo_basic;

--이름으로 검색
SELECT * FROM phoneinfo_basic WHERE fr_name LIKE '%손%';
--전화번호 검색
SELECT * FROM phoneinfo_basic WHERE fr_phonenumber LIKE '%999%';

--시스템 내부에서 관리자가 검색
-- 예) 리스트->상세보기
SELECT * FROM phoneinfo_basic WHERE idx=1;

--update
-- 시스템 내부에서 변경 페이지를 이용한 데이터 수정
UPDATE phoneinfo_basic
SET fr_name='SON', fr_phonenumber='010-7777-5555', fr_email='son@naver.com', fr_address='서울'
WHERE idx=1
;


-------------------------------------
--sequence
CREATE sequence piu_idx_seq
MAXVALUE 999999;


--insert
--친구 정보를 입력 : 기본 정보 + 학교 정보
-- 1. 기본 정보 입력

INSERT INTO phoneinfo_basic --()
    VALUES(pib_idx_seq.nextval, '황희찬', '010-3333-1111', 'hh@gmail.com', 'LONDON', sysdate);
SELECT pib_idx_seq.currval FROM dual;
-- 2. 학교 정보 입력
INSERT INTO phoneinfo_univ
    VALUES(piu_idx_seq.nextval, '축구', 1, PIB_IDX_SEQ.currval) --3외래키
;

--select
SELECT * FROM phoneinfo_univ; --이 테이블의 데이터만으로는 의미가 없다!

SELECT *
    FROM phoneinfo_basic pb, phoneinfo_univ pu
    WHERE pb.idx = pu.fr_ref
    ;
    
-- 기본 정보만 입력된 데이터도 출력 : OUTTER JOIN
SELECT pb.fr_name, pb.fr_phonenumber,
    NVL(pu.fr_u_major, '입력정보 없음') major, NVL(pu.fr_u_year, 0) year,
    to_char(pb.fr_regdate, 'YYYY.MM.DD HH24:mm') regdate 
FROM phoneinfo_basic pb, phoneinfo_univ pu
WHERE pb.idx = pu.fr_ref(+) --OUTTER JOIN
;

--update
UPDATE phoneinfo_univ
SET fr_u_major='야구', fr_u_year=5
WHERE idx=1
;

--delete
-- 자식 테이블의 데이터를 먼저 삭제
DELETE FROM phoneinfo_univ WHERE idx=1;

-- 부모 데이블의 데이터를 삭제
DELETE FROM phoneinfo_basic WHERE idx=3;


-------------------------------------------
--sequence
CREATE sequence pic_idx_seq;



-- insert
SELECT idx FROM phoneinfo_basic;
INSERT INTO phoneinfo_basic
    VALUES(PIB_IDX_SEQ.nextval, '황의조', '010-2222-1111', 'h@gmail.com', 'SEOUL', sysdate);
DESC phoneinfo_com;
INSERT INTO phoneinfo_com
    VALUES(pic_idx_seq.nextval, 'NAVER', PIB_IDX_SEQ.nextval);


-- 회사 친구 입력 : 기본 정보 입력 -> 회사 정보 입력

-- select
SELECT pb.fr_name, pb.fr_phonenumber, pb.fr_email,
    NVL(pc.fr_c_company, '입력데이터 없음') company,
    TO_CHAR(pb.fr_regdate, 'yyyy.MM.DD HH24:mi') regdate
FROM phoneinfo_basic pb, phoneinfo_com pc
WHERE pb.idx=pc.fr_ref(+) --OUTTER JOIN
;

-- update
UPDATE phoneinfo_com
SET fr_c_company = '쿠팡'
WHERE idx=1
;

-- delete
-- 자식 테이블 행 먼저 삭제
DELETE FROM phoneinfo_com WHERE idx=1;
-- 부모 테이블 행 삭제
DELETE FROM phoneinfo_basic WHERE idx=4;


---------------------------------------------
--전체 데이터 리스트 출력 : 테이블 세개 JOIN
SELECT pb.fr_name, pb.fr_phonenumber, pu.fr_u_major, pc.fr_c_company
FROM phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
WHERE pb.idx=pc.fr_ref(+) AND pb.idx=pu.fr_ref(+)
;

SELECT * FROM phoneinfo_view;

SELECT * FROM  phoneinfo_view WHERE fr_name='손흥민';

-- view 생성

CREATE OR REPLACE VIEW phoneinfo_view
AS
SELECT pb.fr_name, pb.fr_phonenumber, pu.fr_u_major, pc.fr_c_company
FROM phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
WHERE pb.idx=pc.fr_ref(+) AND pb.idx=pu.fr_ref(+)
;