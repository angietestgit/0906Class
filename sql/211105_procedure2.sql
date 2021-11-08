
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
CREATE OR REPLACE PROCEDURE BookInsertOrUpdate(
    -- 매개변수
    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number
    )
AS
 -- 변수 선언
    mycount number;
BEGIN
    -- 입력 받은 책이름으로 같은 이름의 책을 보유하는지 여부 확인
    SELECT COUNT(*) into mycount FROM book WHERE bookname
    -- 책의 개수로 분기 : 수정 또는 입력
    if mycount != 0 then
        -- 가격 수정
        update vook set price = myPrice where bookname like mybook
    else
        -- 데이터 (행) 입력
        insert into book value (myBookId, myId)
    end if;

END
;



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