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
SELECT TO_CHAR(100000, '0000000') FROM dual; --빈자리를 0으로 채움
--                      0100000
SELECT TO_CHAR(100000.12, '0,000,000') FROM dual; --빈자리를 0으로 채움
--                         0,100,000
SELECT TO_CHAR(100000, '9,999,999') FROM dual; --9는 빈자리를 표현하지는 않음
SELECT TO_CHAR(100000.123, 'L9,999,999.9') FROM dual; --L은 원화표시, 빈자리를 표현하지는 않음
SELECT sal, TO_CHAR(sal*1200, 'L9,999,999') FROM emp; --예제

-- 문자->날짜 TO_DATE(원본, 패턴)
--SELECT TO_DATE('2021/10/29', 'YYYY/MM/DD') FROM dual;
SELECT TO_DATE('2021.10.29.', 'YYYY.MM.DD.') FROM dual;
SELECT hiredate, TO_CHAR(hiredate, 'YYYY.MM.DD.') from emp; --예제
-- 2021.01.01~오늘 예제
SELECT TRUNC(SYSDATE-TO_DATE('2021-01-01', 'YYYY-MM-DD')) FROM dual;  --디데이

-- 문자->숫자 TO_NUMBER(원본, 패턴)
SELECT TO_NUMBER('100,000', '9,999,999') + 100000 FROM dual; --형변환


-- switch case 와 유사한 decode 함수
-- emp테이블에서 사원 이름, 부서번호, 부서이름 출력
SELECT * FROM dept;
SELECT * FROM EMP;
SELECT ename, deptno,
    decode(deptno,
        10, 'ACCOUNTING',
        20, 'RESEARCH',
        30, 'SALES',
        40, 'OPERATIONS'
    ) as dname
FROM emp
;


-- 직급에 따라 급여를 인상하도록 하자.
-- 직급이 'ANALYST'인 사원은 5%,
--       'SALESMAN'인 사원은 10%,
--       'CLERK'인 사원은 20% 인상한다.
SELECT ENAME, job, sal,
        decode(job,
            'ANALYST', sal*1.05,
            'SALESMAN', sal*1.1,
            'MANAGER', sal*1.15,
            'CLERK', sal*1.2
        ) as upSal
FROM emp
;


-- CASE WHEN THEN : if~else if 구문과 유사 -> 조건식 = 이외의 비교 연산을 할 수 있다.
SELECT ename, sal,
    CASE
        WHEN sal >= 3000 THEN sal*1.3
        WHEN sal < 3000 THEN sal*1.5
    END AS Upsal
FROM emp
;


--------------------------------------------------
-- 집합 함수 (=그룹 함수)
-- 하나의 행의 컬럼이 대상이 아니고, 행 그룹의 컬럼들(집합)이 대상
--------------------------------------------------
SELECT
    TO_CHAR(SUM(sal)*1200, 'L999,999,999') AS "월 급여 총액",
    TO_CHAR(ROUND(AVG(sal)*1200)) AS "월 급여 평균",
    COUNT(*) AS "총 사원의 수",
    COUNT(comm) AS "커미션 등록 수",
    SUM(comm) AS "커미션 합",
    AVG(comm) AS "커미션 평균", -- null은 평균에 들어가지 않음. 나중에 널을 따로 처리해줘야됨
    MAX(sal) AS "가장 높은 급여",
    MIN(sal) AS "가장 낮은 급여"
FROM emp
;


-- 사원들의 업무의 개수
SELECT COUNT(DISTINCT JOB)
FROM emp
;

-- 각 부서별 급여의 총 합
SELECT SUM(sal)
FROM emp
WHERE deptno = 10
;
SELECT SUM(sal)
FROM emp
WHERE deptno = 20
;
SELECT SUM(sal)
FROM emp
WHERE deptno = 30
;

SELECT * FROM emp ORDER BY deptno;


-- GROUP BY : 특정 컬럼으로 그룹핑 -> 그룹 내의 평균이나 합과 같은 집합 함수를 사용할 수 있다.
-- 부서번호를 기준으로 그룹핑
-- -> 급여의 총합, 평균, 최대, 최소, 사원의 수, 커미션 평균, 커미션 총합
SELECT deptno,
       COUNT(*) AS "사원 수",
       SUM(sal) AS "급여 총합",
       TRUNC(AVG(sal)) AS "급여 평균",
       MAX(sal) AS "최대 급여",
       MIN(sal) AS "최소 급여",
       COUNT(comm) AS "커미션 대상자 수",
       NVL(SUM(comm),0) AS "커미션 총합",
       NVL(AVG(comm),0) AS "커미션 평균"
FROM emp
-- WHERE deptno != 20 --20번 부서만 뺌
GROUP BY deptno
-- HAVING AVG(sal) >= 2000 -- 지표같은거 써야될때 잘 쓰임! 해빙함수
HAVING MAX(sal) > 2900
ORDER BY deptno
;


