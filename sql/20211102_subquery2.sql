
-- 2021.11.02
-- *** 한번에 만들 욕심 버리기!

-- 중첩 질의
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장
SELECT AVG(sal) FROM emp;
--2073.214285714285714285714285714285714286

SELECT ename, sal
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp) --2073.214285714285714285714285714285714286
;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오
-- 필요한 것 :
-- 평균 주문금액
SELECT AVG(saleprice) FROM orders;
-- 주문금액 이하의 주문에 대해서 주문번호와 금액
SELECT orderid, saleprice
FROM orders
WHERE saleprice <= (SELECT AVG(saleprice) FROM orders)--11800
;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문내역에 대해서 주문번호, 고객번호, 금액을 보익시오
-- 각 고객의 평균 주문금액
-- 조건: 각 고객의 평균 주문금액보다 큰 금액의 주문내역
-- 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
SELECT AVG(saleprice) FROM orders WHERE custi=1;

SELECT custid, orderid, saleprice
FROM orders o
WHERE saleprice > (-- 13000 AND custid = 1
                  SELECT AVG(saleprice) FROM orders OA WHERE OA.custid=o.custid)
;


-- 다중행 서브 쿼리
-- IN, SOME, ANY, ALL, EXISTS
-- 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원
SELECT DISTINCT(deptno) FROM emp WHERE sal >= 3000;
-- 동일한 부서에서 근무하는 사원
SELECT * FROM emp WHERE deptno=10 OR deptno=20;

SELECT * FROM emp WHERE deptno IN(10,20);

SELECT *
FROM emp
WHERE deptno IN(
    SELECT DISTINCT(deptno) FROM emp WHERE sal >= 3000
);


-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오
-- 대한민국에 거주하는 고객
SELECT custid FROM customer WHERE address LIKE '%대한민국%';
-- 도서의 총 판매액
SELECT SUM(saleprice)--custid
FROM orders
-- WHERE custid IN(2, 3, 5)
WHERE custid IN(SELECT custid FROM customer WHERE address LIKE '%대한민국%'
);


-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
-- 3번 고객의 주문 도서의 금액들
SELECT saleprice FROM orders WHERE custid=3;
-- 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오
SELECT saleprice
FROM orders
WHERE saleprice > ALL (
    SELECT saleprice FROM orders WHERE custid=3
    );
--6000
--12000
--13000


-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 많은 급여를 받는 사원의 이름, ㅡㄱㅂ여 출력
-- 부서번호가 30번인 사원들의 급여
SELECT sal FROM emp WHERE deptno=30;
-- 급여 중 가장 작은 값보다 많은 급여를 받는 사원의 이름, 급여를 출력
SELECT ename, sal
FROM emp
WHERE sal > ANY( SELECT sal FROM emp WHERE deptno=30
);
--2850
--1600
--1250
--1250
--1500
--950


-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다
-- 더 많은 급여를 받는 사람의 이름, 급여를 출력하는 쿼리문

-- 30번 부서의 사원들의 급여
SELECT sal FROM emp WHERE deptno=30;
-- 조건 : 30번 부서의 최고 급여보다 큰 급여를 받는 사원
-- 이름과 급여 출력
SELECT ename, sal
FROM emp
WHERE sal > ALL ( SELECT sal FROM emp WHERE deptno=30
);
-- 같은 표현
SELECT ename, sal
FROM emp
WHERE sal > ( SELECT MAX(sal) FROM emp WHERE deptno=30
);
SELECT MAX(sal) FROM emp WHERE deptno=30;


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
-- EXISTS 연산자로 대한민국에 거주하는 고객
SELECT * FROM customer WHERE address LIKE '%대한민국%' AND custid=3;

SELECT saleprice
FROM orders o
WHERE EXISTS(
        SELECT *
        FROM customer c
        WHERE address LIKE '%대한민국%' AND c.custid=o.custid
        )
;