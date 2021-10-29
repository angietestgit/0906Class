-- 211029 오늘 수업 디비 함수

DESC dual;
SELECT * FROM dual;

-- 함수 : 단일행 함수, 집합 함수
-- 단일행 함수 : 숫자, 문자, 날짜, 변환
-- 숫자함수
SELECT ABS(-15.5) FROM dual;

SELECT FLOOR(35.73) "Floor" FROM DUAL; --wjftkr

SELECT ROUND(15.393) FROM dual; --반올림
SELECT ROUND(15.393, 2) FROM dual;
SELECT ROUND(15.393, -1) FROM dual;

SELECT TRUNC(15.6789) FROM dual; --그냥 자르는거
SELECT TRUNC(15.6789, 2) FROM dual; --그냥 자르는거
SELECT TRUNC(15.6789, -1) FROM dual; --그냥 자르는거

SELECT MOD(10,3) FROM dual; --나머지


--문자처리 함수
SELECT LOWER('MR. SCOTT MCMILLAN') "Lowercase" FROM dual;
SELECT ename, LOWER(ename) FROM emp;
SELECT concat('저는', '손흥민 입니다.') FROM dual;
SELECT ename || 'is a ' FROM emp;
SELECT concat('나의 이름은 ', ename) FROM emp;
SELECT LPAD('Page 1', 15, '*') FROM dual; -- *********Page 1
SELECT RPAD('Page 1', 15, '*') FROM dual; -- Page 1*********
SELECT rpad('001111-3', 14, '*') FROM dual; --주민번호 표현

SELECT SUBSTR('ABCDEFG',3,4) FROM dual;
SELECT SUBSTR('001212-3001234', 1, 8) FROM dual;
SELECT SUBSTR(hiredate, 1, 2) FROM emp; --예제

SELECT RPAD(SUBSTR('001212-3001234', 1, 8), 14, '*') FROM dual; --주민등록번호 특정부분잘라서 *로 치환
SELECT RPAD(SUBSTR(name,1,2), 5, '*') FROM customer; --
SELECT * FROM customer;

SELECT Ltrim('    =from=    ') FROM dual;
SELECT Rtrim('    =from=    ') FROM dual;

SELECT TRIM('+' from '+++++from+++++') AS a FROM dual;
SELECT TRIM(' ' from '     +++++from+++++     ') AS a FROM dual;

SELECT REPLACE('JACK and JUE','J','BL') FROM dual;
SELECT REPLACE('000-0000-0000', '-', '') FROM dual;

-- 날짜 함수
SELECT SYSDATE FROM dual;
SELECT SYSDATE-30 FROM dual;
SELECT add_months(SYSDATE, -4) FROM dual;
SELECT last_day(SYSDATE) FROM dual;


-- 변환 함수
-- 날짜->문자 TO_CHAR(날짜원본, 출력패턴)
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD. day dy AM PM HH HH24 MI SS') FROM dual; --day는 요일을 표시
--2021.10.29. 금요일 금 오후 오후 12 12 59 34
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD. HH24:MI') FROM dual;
-- 2021.10.29. 13:00

-- 숫자->문자 TO_CHAR(원본, 패턴)

-- 문자->날짜 TO_DATE(원본, 패턴)
--SELECT TO_DATE('2021/10/29', 'YYYY/MM/DD') FROM dual;
SELECT TO_DATE('2021.10.29.', 'YYYY.MM.DD.') FROM dual;
SELECT hiredate, TO_CHAR(hiredate, 'YYYY.MM.DD.') from emp; --예제

-- 2021.01.01~오늘 예제
SELECT TRUNC(SYSDATE-TO_DATE('2021-01-01', 'YYYY-MM-DD')) FROM dual;  --디데이

-- 문자->숫자 TO_NUMBER(원본, 패턴)
SELECT TO_CHAR(100000, '0000000') FROM dual; --빈자리를 0으로 채움
--                      0100000
SELECT TO_CHAR(100000.12, '0,000,000') FROM dual; --빈자리를 0으로 채움
--                         0,100,000
SELECT TO_CHAR(100000, '9,999,999') FROM dual; --9는 빈자리를 표현하지는 않음
SELECT TO_CHAR(100000.123, 'L9,999,999.9') FROM dual; --L은 원화표시, 빈자리를 표현하지는 않음
SELECT sal, TO_CHAR(sal*1200, 'L9,999,999') FROM emp; --예제
