-- 2021.10.28

-- 로그인한 사용자가 보유하고 있는
-- 테이블 정보를 가지고 있는 메타데이터 테이블
select * from tab;

-- 테이블의 구조 확인
desc dept;

select * from emp;
select * from dept;
select loc, deptno, dname from dept;
select * from book;
select * from customer;
select * from orders;
select orderid, custid, saleprice from orders;

-- 연봉에 +comm, 주의! comm의 값 중에는 null;
-- null : 정해지지 않은 값 -있는 것도 아니고 없는 것도 아니다!
select ename, sal, sal*12, comm, sal*12+comm
from emp
;

-- null 값을 치환해주는 nvl함수
-- nvl(컬럼명, 치환할 데이터)=>커럼의 값중 null 값은 치환 값으로 출력
select comm, nvl(comm, 100)
from emp
;

-- nvl함수를 이용해서 결과 값 도출
select ename, sal, sal*12, comm, sal*12+comm,
       comm, nvl(comm,0), sal*12+nvl(comm,0) 
from emp
;

-- 별칭을 이용해서 컬럼이름 사용
select ename as "사원이름", sal as "월급여", sal*12+nvl(comm,0) as "연봉"
from emp
;
-- 같은 의미 별칭 생략
select ename name, sal sal, sal*12+nvl(comm,0) SalFORYEAR
from emp
;

-- 문자열을 연결해주는 || 연산자 (파이프 연산자)
select ename || ' is a ' || job msg
from emp;

-- 사원들이 소속된 부서 번호 출력
select distinct deptno
from emp;

-- 우리 서점에 입점한 출판서 리스트
select publicsher
from book;

select distinct deptno, job
from emp;

select *  -- 출력하고자 하는 컬럼
from emp  -- 대상 테이블
where sal >= 3000 -- where 조건 : 비교연산, 논리연산 -> 행을 찾을 조건 
;

-- 10번 부서의 소속된 -> 행을 검색할 조건
-- 사원의 리스트 출력
select *
from emp
where deptno = 10
;

-- 이름이 FORD인 사원의 :행
-- 사원번호(EMPNO)과 사원이름(ENAME)과 급여(SAL)을 출력 :컬럼
select empno, ename, sal
from emp
where ename='FORD' -- 문자열 비교시 반드시 작은 따옴표 사용!!!
; -- 비교하는 문자열 데이터는 대소문자 구별!!!!!

-- 날짜 비교 : 82년 이후 입사자
select *
from emp
where hiredate >= '81/01/01'
;

-- 10번 부서 소속인 사원들 중에서 ->and
-- 직급이 MANAGER인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력
select *
from emp
where deptno=10 and job='MANAGER'
;

-- 10번 부서에 소속된 사원이거나 ->or
-- 직급이 MANAGER인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno=10 or job='MANAGER'
;

-- 부서번호가 10번이 아닌 사원의
-- 사원이름, 부서번호, 직급을 출력해
select *
from emp
-- where not dept=10
-- where dept<>10
where not dept!=10 --세가지 모두 같은 표현
;

-- 2000에서 3000 사이의 급여를 받는 사원과 : 조건
select *
from emp
-- where sal >= 2000 and sal <= 3000
where sal BETWEEN 2000 AND 3000 --위와 같은 표현(between이 더 직관적)
;

-- 1987년에 입사한 사원을 출력해 봅시다.
select *
from emp
where hiredate between '87/01/01' and '98/12/12'
;

-- 커미션이 300이거나 500이거나 1400인 사원을
-- 검색하기 위해서 IN 연산자를 사용해 봅시다.
select *
from emp
-- where comm=300 or comm=500 or comm=1400
where comm IN(300, 500, 1400) --위와 같은 표현
;

-- like 패턴 검색
-- F로 시작하는 이름을 가진 사원을 검색
select *
from emp
where ename like 'S%'
;

-- 이름 중 A를 포함하는 사원을 검색해봅시다.
select *
from emp
where ename like '%A%'
;

-- 이름이 N으로 끝나는 사원을 검색
select *
from emp
where ename like '%N'
;

-- 이름의 두번째 글자가 A인 사원을 검색
select *
from emp
--where ename like '__A%'
where ename not like '__A%'
;

-- 이름이 N인
select *
from emp
where ename like '_A%'
;

-- 커미션을 받지 않는 사원을 검색해 봅시다.
select *
from emp 
-- where comm is null
where comm is not null and comm != 0
;

-- 정렬을 위한 order by 절
-- order by 컬럼명 {[asc] } desc} , asc(오름차순) desc(내림차순)
-- 급여 컬럼을 기준으로 오름차순으로 정렬
select *
from emp
--order by sal asc
--order by sal  -- 기본 정렬 asc
order by sal desc
;

-- 사원 이름순으로 정렬
select *
from emp
order by ename
;

-- 입사일 순 정렬
select *
from emp
order by hiredate, sal asc
;
