
 --2021.11.04
 -- DML : 데이터의 변경 -> 데이터의 삽입, 수정, 삭제
 --삭제
 DROP TABLE emp01;
 --생성
 CREATE TABLE emp01
 AS
 SELECT * FROM emp
 ;
 --확인
 SELECT * FROM emp01;
 
 -- UPDATE 테이블이름 SET 컬럼이름=값, 컬럼이름=값, ... WHERE 행 선택 조건
 
 -- 1. 모든 사원의 부서번호를 30번으로 수정합시다.
 -- 모든 사원은 WHERE 절을 사용하지 않은 경우
 UPDATE emp01
 SET deptno=30
 ;
 SELECT * FROM emp01; -- 확인
 
 -- 2. 이번엔 모든 사원의 급여를 10% 인상시키는 UPDATE문을 작성
 UPDATE emp01
 SET sal = sal*1.1
 ;
 SELECT * FROM emp01;
 
 -- 3. 모든 사원의 입사일을 오늘로 수정
 UPDATE emp01
 SET hiredate = sysdate
 ;
 SELECT * FROM emp01;
 
 
 -- 1. "부서번호가 10번인 사원"의 부서번호를 30번으로 수정 -- "~" 명확하게 찾는게 중요!
 UPDATE emp01
 SET deptno=30
 WHERE deptno=10
 ;
 SELECT * FROM emp01 WHERE deptno=10;
 SELECT * FROM emp01 ORDER BY deptno;
 
 -- 2. 급여가 3000이상인 사원만 급여를 10% 인상
 UPDATE emp01
 SET sal = sal*1.1
 WHERE sal >= 4000
 ;
SELECT * FROM emp01 WHERE sal>=3000;
 
 -- 3. 1987년에 입사한 사원의 입사일을 오늘로 수정
UPDATE emp01
SET hiredate = sysdate
WHERE substr(hiredate, 1, 2) = '87'
;
SELECT * FROM emp01 WHERE substr(hiredate, 1, 2) = '87';


-- 2개 이상의 컬럼을 변경할 때는 컴머(,)를 쓰고 바꾸고자 하는 컬럼을 추가한다.
-- 1. SCOTT 사원의
-- 부서 번호는 40번으로, 직급은 MANAGER로
-- 한꺼번에 수정
UPDATE emp01
SET deptno=40,job='MANAGER'
WHERE ename = 'SCOTT'
;
SELECT * FROM emp01 WHERE ename= 'SCOTT';

-- 2. SCOTT 사원의
-- 입사일자는 오늘로,
-- 급여를 50으로,
-- 커미션을 4000 으로 수정
UPDATE emp01
SET hiredate=sysdate, sal=50, comm=4000
WHERE ename= 'SCOTT'
;
SELECT * FROM emp01 WHERE ename='SCOTT';

--------------------------------------------
-- 설정 : dept01 -> 새로 만들기
DROP TABLE dept01;
CREATE TABLE dept01
AS
SELECT * FROM dept
;
SELECT * FROM dept01;

-- 1. 20번 부소의 지역명을
-- 40번 부서의 지역명으로 변경하기 위해서
-- 서브 쿼리문을 사용해 봅시다.
SELECT loc FROM dept01 WHERE deptno=20;
-- DALLAS
UPDATE dept01
SET loc=(SELECT loc FROM dept01 WHERE deptno=20) --loc='DALLAS'
WHERE deptno=40
;
SELECT * FROM dept01;

-- 2. 서브쿼리를 이용해서
-- 부서번호가 20인 부서의 부서명과 지역명을
-- 부서번호가 40번인 부서와 동일하게 변경
UPDATE dept01
SET (dname, loc) = (SELECT dname, loc FROM dept01 WHERE deptno=40)
WHERE deptno=20
;
SELECT * FROM dept01;


-- "행"을 삭제하는 DELETE문
-- dept01 테이블의 모든 데이터(행)을 지우자
DELETE FROM dept01;
DELETE FROM emp01;
SELECT * FROM emp01;
SELECT * FROM dept01;

ROLLBACK; --> 마지막 커밋된 위치로 이동, 마지막 커밋 후 작업된 DML반영이 되지 않는다!

-- 부서 테이블에서 30번 부서만 삭제
DELETE FROM dept01 WHERE deptno=30;
SELECT * FROM dept01;

COMMIT;

-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제
DELETE FROM emp01
WHERE deptno = (SELECT deptno FROM dept WHERE dname='SALES')
;

SELECT * FROM emp01;