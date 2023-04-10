create database library;




create table borrowing (borrowing_id int8 not null, borrow_date date, due_date date, return_date date, status varchar(255), book_id int8, user_id int8, primary key (borrowing_id));

alter table if exists borrowing add constraint FKpgw9do56tnua1aepwswrbwifh foreign key (book_id) references book;

alter table if exists borrowing add constraint FK2u8cf2qmw1o3f4wiijgns2m5d foreign key (user_id) references users;
