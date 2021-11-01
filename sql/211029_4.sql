---- 단일행 함수, 집합함수 문제
--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
--81/02/21 => 81/02 => 2, 
SELECT SUBSTR(hiredate, 1, 5)
FROM emp
;

--
--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
SELECT ename,
    SUBSTR(hiredate, 4,2)
FROM emp
;
--
--18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
SELECT ename AS "짝수사원번호인 사람",
    MOD(deptno,2) AS "증거나머지가0"
FROM emp
;

--19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
SELECT hiredate, TO_CHAR(hiredate, 'YY.MM.DD.dy') AS "입사일 출력"
from emp
;
--
--20. 올해 몇 칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
SELECT TRUNC(SYSDATE-TO_DATE('2021-01-01', 'YYYY-MM-DD')) AS "올해 며칠 지났나"
FROM dual
;
--21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
--
SELECT NVL(MGR, 0) AS "사원들의 상관 사번"
FROM emp
;
--
--22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
SELECT ENAME, sal, job, 
    DECODE(job,
    'ANALYST', sal+200,
    'SALESMAN', sal+180,
    'MANAGER', sal+150,
    'CLERK', sal+100
    ) AS upSal
FROM emp
;
    
--23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 평균에 대해서는 정수로 반올림하시오.
SELECT
    MAX(sal) AS "급여 최고액",
    MIN(sal) AS "급여 최저액",
    SUM(sal) AS "급여 총액",
    ROUND(AVG(sal), 0) AS "평균 급여"
FROM emp
;
--
--24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 평균에 대해서는 정수로 반올림 하시오.
SELECT job,
    MAX(sal) AS "급여 최고액",
    MIN(sal) AS "급여 최저액",
    SUM(sal) AS "급여 총액",
    ROUND(AVG(sal), 0) AS "평균 급여"
FROM emp
GROUP by job
;

--25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
SELECT job,
    COUNT(job) AS "담당업무동일사원수"
FROM emp
GROUP BY job
;
--
--26. 관리자 수를 출력하시오.
--
SELECT
    COUNT(job) AS "관리자수"
FROM emp
WHERE job = 'manager'
;
--
--27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
SELECT
    MAX(sal) - MIN(sal) AS "최고최저 급여차액"
FROM emp
;
--28. 직급별 사원의 최저 급여를 출력하시오. 관리자를 알 수 없는 사원과
-- 최저 급여가 2000 미만인 그룹은 제외시키고
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
SELECT job,
    MIN(sal) AS "직급별최저급여"
FROM emp
WHERE mgr IS NOT NULL AND sal >= 2000
GROUP BY job
ORDER BY MIN(sal) DESC
;
--
--29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오.
-- 평균 급여는 소수점 둘째 자리로 반올림 하시오.
SELECT deptno AS "부서 번호",
    COUNT(ename) AS "사원 수",
    ROUND(AVG(sal), 2) AS "평균 급여"
FROM emp
GROUP BY deptno
;

--30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의
--모든 사원의 평균 급여를 출력하시오. 평균 급여는 정수로 반올림 하시오. DECODE 사용.
SELECT deptno,
    DECODE( --부서번호 이름
        10, 'ACCOUNTING',
        20, 'RESEARCH',
        30, 'SALES',
        40, 'OPERATIONS'
    ) AS dname,
    DECODE( --지역명
        10, 'A',
        20, 'B',
        30, 'C',
        40, 'D'
    ) AS "지역 명",
        COUNT(*) AS "사원 수",
        ROUND(AVG(sal), 2) AS "평균 급여"
FROM emp
GROUP BY deptno
;

--31. 업무를 표시한 다음 해당 업무에 대해 부서 번호별 급여
-- 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오.
-- 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오. 
--( hint. Decode, group by )
--
SELECT job, deptno AS "dno",
        DECODE(deptno, 10, SUM(sal)) AS "부서 10",
        DECODE(deptno, 20, SUM(sal)) AS "부서 20",
        DECODE(deptno, 30, SUM(sal)) AS "부서 20",
    SUM(sal) AS "총액"
FROM emp
GROUP BY job, deptno
ORDER BY deptno;
    