
-- 부서의 전체 리스트 출력
select * from project.dept;

SELECT `dept`.`deptno`,
    `dept`.`dname`,
    `dept`.`loc`
FROM `project`.`dept`;