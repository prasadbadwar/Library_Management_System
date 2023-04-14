create database library;

create table users (user_id int8 not null, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), primary key (user_id))

create table book (book_id int8 not null, author varchar(255), available_quantity int4, date date, isbn varchar(50) not null, publisher varchar(255), quantity int4 not null, subject varchar(255), title varchar(255), primary key (book_id))

create table borrowing (borrowing_id int8 not null, borrow_date date, due_date date, return_date date, status varchar(255), book_id int8, user_id int8, primary key (borrowing_id))

create table loan_management (loan_id int8 not null, due_date date, fine float8, book_id int8, user_id int8, primary key (loan_id))

create table reports (report_id int8 not null, fines_collected float8, book_id int8, user_id int8, primary key (report_id))

create table reservation (reservation_id int8 not null, reservation_date date, book_id int8, user_id int8, primary key (reservation_id))


alter table if exists borrowing add constraint FKpgw9do56tnua1aepwswrbwifh foreign key (book_id) references book

alter table if exists borrowing add constraint FK2u8cf2qmw1o3f4wiijgns2m5d foreign key (user_id) references users

alter table if exists loan_management add constraint FKncmxw1vyb50as04ribhc11ifu foreign key (book_id) references book

alter table if exists loan_management add constraint FK6e5vnao5y6xdymkq53ccp8lt8 foreign key (user_id) references users

alter table if exists reports add constraint FKfvidf1w7ciolnjcifqsnblcov foreign key (book_id) references book

alter table if exists reports add constraint FK2o32rer9hfweeylg7x8ut8rj2 foreign key (user_id) references users

alter table if exists reservation add constraint FKirxtcw4s6lhwi6l9ocrk6bjfy foreign key (book_id) references book

alter table if exists reservation add constraint FKrea93581tgkq61mdl13hehami foreign key (user_id) references users