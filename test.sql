select * from 책;
select * from 회원;
select * from 관심도서;
select * from 카테고리;
select * from 도서추가요청;
select * from 별점;
select * from 대여;
select * from 대여상세;

select * from 책 where book_title like '%마인크래프트%';
select book_seq, book_title, call_number, publisher, author, loan_possible from 책;

select * from 카테고리;

select *
from 책 JOIN 카테고리
using(book_seq)
where name like '%게임%';

select * from 책 where book_seq = 105280932;

select * from 대여 join 대여상세 using(borrow_seq) join 책 using(book_seq);

select book_title,call_number,publisher,author,publication_year,rental_date,expectedreturn_date 
from 대여 join 대여상세 using(borrow_seq) join 책 using(book_seq) where user_seq=21;

select book_title,call_number,publisher,author,loan_possible,publication_year, dense_rank() over (order by score desc, book_title desc) as 순위
from 별점 join 책 using(book_seq)
join 회원 on 회원.category = 책.name
where user_seq = ? and 순위>=1 and 순위<=5;

select book_seq, book_title, call_number, publisher, author, loan_possible, dense_rank() over (order by 책.book_title) as num from 책 where book_title like 스마트 and num>=1 and num<=10";

select book_seq, book_title, call_number, publisher, author, loan_possible, dense_rank() over (order by 책.book_title) as num from 책 where book_title like '%스마트%';

SELECT * FROM
    (SELECT 책.*, DENSE_RANK() OVER(ORDER BY 책.book_title) AS rnum FROM 책 where book_title like '%스마트%')
WHERE rnum >=1 and rnum<=10 ;

insert into 도서추가요청 (request_date, request_status, addbook_title, addbook_author,publisher, user_seq) 
values ((select sysdate from dual),'처리 중','test','test','test','85');