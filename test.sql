select * from 책;
select * from 회원;
select * from 관심도서;
select * from 카테고리;
select * from 도서추가요청;

select * from 책 where book_title like '%마인크래프트%';
select book_seq, book_title, call_number, publisher, author, loan_possible from 책;

select * from 카테고리;

select *
from 책 JOIN 카테고리
using(book_seq)
where name like '%게임%';

select * from 책 where book_seq = 105280932;