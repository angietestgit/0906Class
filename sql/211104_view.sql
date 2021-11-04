
-- 2021.11.04

-- VIEW
--가상테이블: 물리적인 테이블 SELECT의 결과를 테이블로 사용
-- 1. 복잡한 sql(SELECT)문을 간단히 사용하기 위해
-- 2. 보안이 필요한 컬럼의 데이터를 보호하기 위해

-- CREATE OR REPLACE VIEW(뷰 이름) = CREATE VIEW(뷰이름)도 가능
-- AS (sub query)


-- 자주 사용되는 30번 부서에서 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한
-- SELECT문을 하나의 뷰로 정의해봅시다.

SELECT empno, ename, deptno from emp where deptno=30;
-- View 생성
CREATE OR REPLACE VIEW emp_view30
AS SELECT empno, ename, deptno from emp where deptno=30;

-- 가상테이블 View를 이용해서 질의
SELECT * FROM emp_view30; --자주쓰는건 이렇게 만들어두고 사용
 
SELECT * FROM user_views WHERE view_name='EMP_VIEW30'; --사용자의 뷰 확인


-- View 삭제
DROP VIEW emp_view30;



--SELECT * FROM emp ORDER BY hiredate --limit 1, 10; MySQL기능

SELECT rownum, ename, hiredate FROM emp ORDER BY hiredate;

SELECT rownum, ename, hiredate
FROM (SELECT * FROM emp ORDER BY hiredate) --인라인 뷰
WHERE rownum <= 5
;

-- 급여액 TOP3
SELECT ename, sal, job
FROM (SELECT * FROM emp ORDER BY sal desc)
WHERE rownum <= 3
;


-- 게시물의 리스트
-- 회원 리스트
-- 1 Page = 10 => 1~10
-- 2 Page = 10 => 11~20

-- 입사일 기준으로 정렬한 가상 테이블
CREATE OR REPLACE VIEW emp_hir
AS
SELECT * FROM emp ORDER BY hiredate
;

-- 입사일이 가장 빠른 5명
SELECT rownum, ename
FROM emp_hir
WHERE rownum <= 5
;