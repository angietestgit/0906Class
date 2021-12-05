create table SALES (
s_id number(6),
s_name VarChar2(40),
s_price number(6),
s_cal number(4),
s_type Varchar2(40),

constraint PK_Sales_Id primary key(s_id)
);

create table Ingredient(
ingre_id number(6),
inger_name varchar2(40),
ingre_type varchar2(40),
s_id number(6),

constraint PK_Ingre_Id primary key(ingre_id),
constraint FK_Ingre_s_id foreign key (s_id) references SALES(s_id)
);

drop table sales;
drop table ingredient;

insert into sales values(1,'cheeseburger', 6700, 650, '햄버거');
insert into sales values(2, 'tomatoburger' , 5000, 400, '햄버거');

insert into ingredient values(1, '양파' , '채소', 1);
insert into ingredient values(2, '치즈', '유제품',1);
insert into ingredient values(3, '소고기패티', '육류',1);
insert into ingredient values(4, '토마토', '채소',2);
insert into ingredient values(5, '양상추', '채소',1);

SELECT * FROM sales;

SELECT * FROM INGREDIENT;

--insert into ingredient values(1, '양파' , '채소', 2, 1);
--insert into ingredient values(2, '치즈', '유제품', 3, 1);
--insert into ingredient values(3, '소고기패티', '육류', 5, 1);
--insert into ingredient values(4, '토마토', '채소',4, 2);
--insert into ingredient values(5, '양상추', '채소',1, 1);

select * from SALES natural join Ingredient
order by s_id;

select ingre_stock-ingre_need from (select *from sales s1 natural join ingredient where s1.s_name = '?');



