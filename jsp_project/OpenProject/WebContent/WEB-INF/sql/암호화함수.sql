
select md5('111') from project.member;
-- select password('111') from project.member;
select sha1('111') from project.member;
select sha2('111', 512) from project.member;

-- select password('111') from project.member;
--------------------------------------------------
-- hex() : 값을 16진수의 문자 값으로 변환
insert into project.test(name, pw)
values('cool', hex(aes_encrypt("111", sha2('key'), 512)) );
select * from project.test;

-- unhex() : 16진수 숫자를 문자로 변경

select name,
		convert( aes_decrypt(unhex(pw), sha2('key', 512)) using utf8) as password
from project.test;

select * from project.test;

