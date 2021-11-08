
-- 2021.11.05
-- procedure
-- 

-- create or replace procedure { }{
-- 
-- }
-- as
-- begin --프로그램 코드 시작
-- ......
-- end
-- ;


DESC book;
-- Book 테이블에 한 개의 튜플을 삽입하는 프로싲
CREATE OR REPLACE PROCEDURE InsertBook(
    -- 매개변수 선언
    myBookId in number,
    myBookName in varchar2,
    myPublisher in varchar2,
    myPrice in number
)
AS
BEGIN  --코드 실행 시작
       -- 핵심 처리 코드
       -- 매개변수로 받은 데이터를 이용해서 데이터 삽입.
       insert into book (bookid, bookname, publisher, price)
       values (myBookId, myBookNames, mypublisher, myPrice);
END    --코드 실행 종료
;


-- 프로시저 호출 : 실행 요청
-- EXEC 프로시저 이름(매개변수 값, ......);
EXEC insertBook(13, '스포츠과학', '마당과학서적', 25000);
SELECT * FROM book;