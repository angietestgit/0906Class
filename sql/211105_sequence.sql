
-- 2021.11.05

-- Sequence : 숫자를 생성해주는 객체
--설정을 통해서 일련 번호를 생성 -> 기본키가 대리키인 경우 입력 값으로 사용

-- Sequence의 생성
--CREATE sequence {시퀀스이름} 설정...

--시퀀스 생성
CREATE SEQUENCE test_seq;

DESC dept;
SELECT * FROM dept;
--부서 번호를 자동으로 부여해주는 시퀀스 객체를 생성
-- 시작값은 10 증가값은 10, 10~99
CREATE SEQUENCE dept_deptno_seq
START WITH 10
INCREMENT BY 10
MAXVALUE 90
;

-- SEQUENCE 삭제
DROP SEQUENCE dept_deptno_seq;

-- 시작값이 1이고 1씩 증가하는 시퀀스 EMP_SEQ를 생성
CREATE SEQUENCE emp_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9999
;

-- 시퀀스의 값을 확인
-- 현재값
SELECT emp_seq.CURRVAL FROM dual;
SELECT dept_deptno_seq.currval FROM dual;

-- 다음(새로운) 값
SELECT emp_seq.nextval FROM dual;
SELECT dept_deptno_seq.nextval FROM dual;

