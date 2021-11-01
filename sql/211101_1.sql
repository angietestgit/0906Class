

-- 2021-11-01

-- JOIN

-- Cross JOIN : 단순히 테이블 붙이는 조인
--  컬럼을 붙이고, 행(데이터)는 집합의 합 연산(카티즌 곱) -> 전체 행은 (Relation)R1의 행의 개수 곱하기 R2의 행의 개수
--  emp 테이블과 dept 테이블의 join -> 14 * 4 = 56개 행

-- Cross Join 문
-- SELECT * FROM 테이블 명, 테이블 명, ...
SELECT *
FROM emp, dept
ORDER BY dept.deptno
;

-- Equi Join
-- 특정 컬럼의 값을 비교해서 같은 결과 행만 추출
SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno
;

-- SCOTT 사원의 부서이름을 출력 (부서이름은 어느 테이블에 있냐?가 중요! 이걸 알아야됨)
SELECT ename, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
    AND ename = 'SCOTT'
;

-- 테이블의 별칭 이용
SELECT *
FROM EMP e, dept d
WHERE e.deptno=d.deptno
;


SELECT *
FROM salgrade
;

SELECT e.name, e.sal, s.grade--, s.losal, s.hisal
FROM emp e, salgrade s
WHERE e.sal >= s.losal AND e.sal<=s.hisal
ORDER BY e.empno
;


-- Self Join
-- 나 자신을 참조해서 붙이는 조인
SELECt e.ename, e.mgr, m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno
ORDER BY e.mgr
;
-- 결과의 행의 개수가 13이다! =>  mgr -> null -> 무조건 false 계산처리x 

-- OUTTER JOIN
SELECt e.ename AS eName, nvl(m.ename), e.mgr, m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno
ORDER BY e.mgr
;


-- ANSI JOIN
SELECT *
FROM emp.dept

