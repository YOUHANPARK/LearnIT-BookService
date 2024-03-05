select * from 책;
select * from 회원;

select * from 책 where book_title like '%마인크래프트%';
select book_seq, book_title, call_number, publisher, author, loan_possible from 책;