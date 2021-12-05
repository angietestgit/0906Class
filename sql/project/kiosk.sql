create table SALES (
s_id number(6),
s_name VarChar2(40),
s_price number(6),
s_cal number(4),
s_type Varchar2(40),

constraint PK_Sales_Id primary key(s_id)
);

DROP TABLE SALES;

create table Ingredient(
ingre_id number(6),
inger_name varchar2(40),
ingre_type varchar2(40),
ingre_stock number(5),
ingre_need number(2),
s_id number(6),

constraint PK_Ingre_Id primary key(ingre_id),
constraint FK_Ingre_s_id foreign key (s_id) references SALES(s_id)
);

create table HamOwner(
ho_name varchar2(40),
ho_profit number(9)
);

create table HamOrder(
o_id number(6),
numTicket number(6),
saleDate varchar2(40),
age number(1),
s_id number(6),

constraint PK_o_id primary key(o_id),
constraint FK_o_s_id foreign key (s_id) references SALES(s_id)
);
-- 데이터를 추가시 날짜에는 sysdate 를 문자로 바꾸어 입력되게 한다.

insert into hamorder values(1, 1, to_char(sysdate, 'yyyy/MM/DD'), 0, 1);
insert into hamorder values(2, 5, to_char(sysdate, 'yyyy/MM/DD'), 0, 3);
insert into hamorder values(3, 11, to_char(sysdate, 'yyyy/MM/DD'), 0, 6);
insert into hamorder values(4, 12, to_char(sysdate, 'yyyy/MM/DD'), 0, 5);
insert into hamorder values(5, 16, to_char(sysdate, 'yyyy/MM/DD'), 0, 5);
insert into hamorder values(6, 20, to_char(sysdate, 'yyyy/MM/DD'), 0, 6);
insert into hamorder values(7, 26, to_char(sysdate, 'yyyy/MM/DD'), 0, 16);
insert into hamorder values(8, 29, to_char(sysdate, 'yyyy/MM/DD'), 0, 16);
insert into hamorder values(9, 33, to_char(sysdate, 'yyyy/MM/DD'), 0, 17);
insert into hamorder values(10, 39, to_char(sysdate, 'yyyy/MM/DD'), 0, 1);
insert into hamorder values(11, 44, to_char(sysdate, 'yyyy/MM/DD'), 0, 2);







drop table hamorder;
drop table sales;
drop table ingredient;
insert into sales values(1,'cheeseburger', 5300, 620, '햄버거');
insert into sales values(2, 'tomatoburger' , 5000, 400, '햄버거');
insert into sales values(3, 'baconburger', 5500, 600, '햄버거');
insert into sales values(4, 'chickenburger', 4700, 630, '햄버거');
insert into sales values(5, 'cheesestick', 2500, 500, '사이드메뉴');
insert into sales values(6, 'frenchfries', 2300, 377, '사이드메뉴');
insert into sales values(7, 'coke', 2500, 190, '음료');
insert into sales values(8, 'sprite', 3000, 5, '음료');

SELECT * FROM sales;

update ingregient
set ingre_stock = ingre_stock + ?
where ingre_name = ?;

insert into ingredient values(1, '?', '채소', (select ingre_stock from ingredient where ingre_name = 
'?'),'?',100);

insert into ingredient values(1, '양파' , '채소',1000, 1,1);
insert into ingredient values(2, '치즈', '유제품',1000,2,1);
insert into ingredient values(3, '소고기패티', '육류',150,1,1);
insert into ingredient values(4, '빵 ', '가공품',2000,2,1);
insert into ingredient values(5, '양상추', '채소',1000,1,1);
insert into ingerdient values(6, '양파', '채소', (select ingre_stock from ingredient where ingre_name = '양파'), 1,2);
insert into ingredient values(7, '토마토', '채소', 500, 1, 2);
insert into ingredient values(8, '빵', '가공품', 2000, 2, 2);
insert into ingredient values(9, '양상추', '채소', 1000, 1, 2);
insert into ingredient values(10, '양파', '채소', 1000, 1, 3);
insert into ingredient values(11, '베이컨', '육류', 200, 1, 3);
insert into ingredient values(12, '치즈', '유제품', 1000, 1, 3);
insert into ingredient values(13, '빵', '가공품', 2000, 2, 3);
insert into ingredient values(14, '양상추', '채소', 1000, 1, 3);
insert into ingredient values(15, '토마토', '채소', 500, 1, 3);
insert into ingredient values(16, '양파', '채소', 1000, 1, 4);
insert into ingredient values(17, '치킨패티', '육류', 500, 1, 4);
insert into ingredient values(18, '양상추', '채소', 1000, 1, 4);
insert into ingredient values(19, '빵', '가공', 2000, 2, 4 );
insert into ingredient values(20, '치즈', '유제품', 1, 5);
insert into ingredient values(21, '감자', '채소', 1, 6);
insert into ingredient values(22, '콜라', '.', 1, 7);
insert into ingredient values(23, '커피', '.', 1, 8);



update ingredient i1
set ingre_stock = ingre_stock - ingre_need
where i1.s_id =
(select s_id from ingredient i2,
sales s1 where i2.s_id = s1.s_id);


-- JAVA 의 ResultSet 타입 변수에 넣어줄 SQL문
-- 고객이 주문한 '상품명' 을 가진 상품의 필요한 재료 갯수들을 재고에서 뺀 결과를 보내준다.
-- 그 ResultSet rs 에 저장된 값을 하나씩 체크하면서 
-- 만약 0보다 작은 수가 나왔다면, 재고가 부족하다는 의미이므로, 주문을 취소시킨다.
select ingre_stock-ingre_need from
(select *from sales s1 natural join ingredient where s1.s_name = 'cheeseburger');


-- 만약 0이 아니라면 주문을 접수하고 재료의 재고에서 상품이 필요하는 재료의 갯수를 뺀다 (Update)
-- = 주문을 받고 조리 시작.
update ingredient i1
set ingre_stock = ingre_stock - ingre_need
where i1.s_id =  (
select s_id from sales s1 where s1.s_name = 'cheeseburger' );






select *from sales s1 natural join ingredient where s1.s_name = 'cheeseburger';