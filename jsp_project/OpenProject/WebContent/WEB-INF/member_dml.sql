-- select
select * from project.member;
select * from member where userid=? and password=? ;
select * from project.member where userid='test@gmail.com' and password='1234';




-- insert
INSERT INTO member ( userid, password, username) VALUES (?,?,?)
;